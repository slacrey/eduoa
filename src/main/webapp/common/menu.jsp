<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer permissions="rolesAdapter" name="Velocity" config="navbarMenu.vm" >
<div class="nav-collapse collapse">
<ul class="nav">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>

    <%--<!--SysMenuItemEntity-START-->--%>
    <%--<menu:displayMenu name="MenuItemMenu"/>--%>
    <%--<!--SysMenuItemEntity-END-->--%>
    <!--Emp-START-->
    <menu:displayMenu name="DepartmentMenu"/>
    <!--Emp-END-->
</ul>
</div>
</menu:useMenuDisplayer>
