<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menuItemList.title"/></title>
    <meta name="menu" content="MenuItemMenu"/>
</head>

<div class="span10">
    <h2><fmt:message key="menuItemList.heading"/></h2>

    <form method="get" action="${ctx}/menuItems" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="menuItemList.message"/>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/editMenuItem'/>" >
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
        </a>
        <a class="btn" href="<c:url value="/mainMenu"/>" >
            <i class="icon-ok"></i> <fmt:message key="button.done"/>
        </a>
    </div>

    <display:table name="menuItems" class="table table-condensed table-striped table-hover" requestURI="" id="menuItemList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="editMenuItem" media="html"
            paramId="id" paramProperty="id" titleKey="menuItem.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="menuItem.id"/>
        <display:column property="action" sortable="true" titleKey="menuItem.action"/>
        <display:column property="altImage" sortable="true" titleKey="menuItem.altImage"/>
        <display:column property="description" sortable="true" titleKey="menuItem.description"/>
        <display:column property="forward" sortable="true" titleKey="menuItem.forward"/>
        <display:column property="height" sortable="true" titleKey="menuItem.height"/>
        <display:column property="image" sortable="true" titleKey="menuItem.image"/>
        <display:column property="location" sortable="true" titleKey="menuItem.location"/>
        <display:column property="name" sortable="true" titleKey="menuItem.name"/>
        <display:column property="onclick" sortable="true" titleKey="menuItem.onclick"/>
        <display:column property="onmouseout" sortable="true" titleKey="menuItem.onmouseout"/>
        <display:column property="onmouseover" sortable="true" titleKey="menuItem.onmouseover"/>
        <display:column property="page" sortable="true" titleKey="menuItem.page"/>
        <display:column property="roles" sortable="true" titleKey="menuItem.roles"/>
        <display:column property="target" sortable="true" titleKey="menuItem.target"/>
        <display:column property="title" sortable="true" titleKey="menuItem.title"/>
        <display:column property="tooltip" sortable="true" titleKey="menuItem.tooltip"/>
        <display:column property="width" sortable="true" titleKey="menuItem.width"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="menuItemList.menuItem"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="menuItemList.menuItems"/></display:setProperty>

        <display:setProperty name="export.excel.filename"><fmt:message key="menuItemList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="menuItemList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="menuItemList.title"/>.pdf</display:setProperty>
    </display:table>
</div>
