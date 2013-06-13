<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="empList.title"/></title>
    <meta name="menu" content="EmpMenu"/>
</head>

<div class="span10">
    <h2><fmt:message key="empList.heading"/></h2>

    <form method="get" action="${ctx}/emps" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="empList.message"/>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/editEmp'/>" >
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
        </a>
        <a class="btn" href="<c:url value="/mainMenu"/>" >
            <i class="icon-ok"></i> <fmt:message key="button.done"/>
        </a>
    </div>

    <display:table name="emps" class="table table-condensed table-striped table-hover" requestURI="" id="empList" export="true" pagesize="25">
        <display:column property="eid" sortable="true" href="editEmp" media="html"
            paramId="eid" paramProperty="eid" titleKey="emp.eid"/>
        <display:column property="eid" media="csv excel xml pdf" titleKey="emp.eid"/>
        <display:column property="eage" sortable="true" titleKey="emp.eage"/>
        <display:column property="ename" sortable="true" titleKey="emp.ename"/>
        <display:column property="estate" sortable="true" titleKey="emp.estate"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="empList.emp"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="empList.emps"/></display:setProperty>

        <display:setProperty name="export.excel.filename"><fmt:message key="empList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="empList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="empList.title"/>.pdf</display:setProperty>
    </display:table>
</div>
