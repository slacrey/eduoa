package com.node.burn.service.impl;

import com.node.burn.Constants;
import com.node.burn.dao.RoleDao;
import com.node.burn.dao.UserDao;
import com.node.burn.model.SysRoleEntity;
import com.node.burn.model.SysUserEntity;
import com.node.burn.service.UserExistsException;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.Assert.*;

public class UserManagerImplTest extends BaseManagerMockTestCase {
    //~ Instance fields ========================================================
    private UserManagerImpl userManager = new UserManagerImpl();
    private RoleManagerImpl roleManager;
    private UserDao userDao;
    private RoleDao roleDao;

    //~ Methods ================================================================
    @Before
    public void setUp() throws Exception {
        userDao = context.mock(UserDao.class);
        userManager.setUserDao(userDao);
        roleDao = context.mock(RoleDao.class);
        roleManager = new RoleManagerImpl(roleDao);
    }

    @Test
    public void testGetUser() throws Exception {
        final SysUserEntity testData = new SysUserEntity("1");
        testData.getRoles().add(new SysRoleEntity("user"));

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(userDao).get(with(equal(1L)));
            will(returnValue(testData));
        }});
        
        SysUserEntity user = userManager.getUser("1");
        assertTrue(user != null);
        assert user != null;
        assertTrue(user.getRoles().size() == 1);
    }

    @Test
    public void testSaveUser() throws Exception {                                           
        final SysUserEntity testData = new SysUserEntity("1");
        testData.getRoles().add(new SysRoleEntity("user"));

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(userDao).get(with(equal(1L)));
            will(returnValue(testData));
        }});
        
        final SysUserEntity user = userManager.getUser("1");
        user.setPhoneNumber("303-555-1212");

        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user)));
            will(returnValue(user));
        }});
        
        SysUserEntity returned = userManager.saveUser(user);
        assertTrue(returned.getPhoneNumber().equals("303-555-1212"));
        assertTrue(returned.getRoles().size() == 1);
    }

    @Test
    public void testAddAndRemoveUser() throws Exception {
        SysUserEntity user = new SysUserEntity();

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (SysUserEntity) populate(user);
        
        // set expected behavior on role dao
        context.checking(new Expectations() {{
            one(roleDao).getRoleByName(with(equal("ROLE_USER")));
            will(returnValue(new SysRoleEntity("ROLE_USER")));
        }});
                
        SysRoleEntity role = roleManager.getRole(Constants.USER_ROLE);
        user.addRole(role);

        // set expected behavior on user dao
        final SysUserEntity user1 = user;
        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user1)));
            will(returnValue(user1));
        }});

        user = userManager.saveUser(user);
        assertTrue(user.getUsername().equals("john"));
        assertTrue(user.getRoles().size() == 1);

        context.checking(new Expectations() {{
            one(userDao).remove(with(equal(5L)));
        }});

        userManager.removeUser("5");

        context.checking(new Expectations() {{
            one(userDao).get(with(equal(5L)));
            will(returnValue(null));
        }});
        
        user = userManager.getUser("5");
        assertNull(user);
    }

    @Test
    public void testUserExistsException() {
        // set expectations
        final SysUserEntity user = new SysUserEntity("admin");
        user.setEmail("matt@raibledesigns.com");

        final Exception ex = new DataIntegrityViolationException("");

        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user)));
            will(throwException(ex));
        }});
        
        // run test
        try {
            userManager.saveUser(user);
            fail("Expected UserExistsException not thrown");
        } catch (UserExistsException e) {
            log.debug("expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}
