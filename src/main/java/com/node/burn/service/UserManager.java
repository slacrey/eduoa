package com.node.burn.service;

import com.node.burn.dao.UserDao;
import com.node.burn.model.SysUserEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *  Modified by <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface UserManager extends GenericManager<SysUserEntity, Long> {
    /**
     * Convenience method for testing - allows you to mock the DAO and set it on an interface.
     * @param userDao the UserDao implementation to use
     */
    void setUserDao(UserDao userDao);

    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return SysUserEntity
     */
    SysUserEntity getUser(String userId);

    /**
     * Finds a user by their username.
     * @param username the user's username used to login
     * @return SysUserEntity a populated user object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *         exception thrown when user not found
     */
    SysUserEntity getUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<SysUserEntity> getUsers();

    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @throws UserExistsException thrown when user already exists
     * @return user the updated user object
     */
    SysUserEntity saveUser(SysUserEntity user) throws UserExistsException;

    /**
     * Removes a user from the database
     *
     * @param user the user to remove
     */
    void removeUser(SysUserEntity user);

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    void removeUser(String userId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<SysUserEntity> search(String searchTerm);
}
