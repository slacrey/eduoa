<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="empList.title"/></title>
    <meta name="menu" content="EmpMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/zTreeStyle/zTreeStyle.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/zTree/js/jquery.ztree.core-3.5.js'/>"></script>
    <script type="text/javascript">
        <!--
        var setting = {};
        var zNodes =[
            { name:"父节点1 - 展开", open:true,
                children: [
                    { name:"父节点11 - 折叠",
                        children: [
                            { name:"叶子节点111"},
                            { name:"叶子节点112"},
                            { name:"叶子节点113"},
                            { name:"叶子节点114"}
                        ]},
                    { name:"父节点12 - 折叠",
                        children: [
                            { name:"叶子节点121"},
                            { name:"叶子节点122"},
                            { name:"叶子节点123"},
                            { name:"叶子节点124"}
                        ]},
                    { name:"父节点13 - 没有子节点", isParent:true}
                ]},
            { name:"父节点2 - 折叠",
                children: [
                    { name:"父节点21 - 展开", open:true,
                        children: [
                            { name:"叶子节点211"},
                            { name:"叶子节点212"},
                            { name:"叶子节点213"},
                            { name:"叶子节点214"}
                        ]},
                    { name:"父节点22 - 折叠",
                        children: [
                            { name:"叶子节点221"},
                            { name:"叶子节点222"},
                            { name:"叶子节点223"},
                            { name:"叶子节点224"}
                        ]},
                    { name:"父节点23 - 折叠",
                        children: [
                            { name:"叶子节点231"},
                            { name:"叶子节点232"},
                            { name:"叶子节点233"},
                            { name:"叶子节点234"}
                        ]}
                ]},
            { name:"父节点3 - 没有子节点", isParent:true}

        ];


        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
        //-->

    </script>
</head>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2">
            <div class="show_dialog">12321</div>
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <div class="span8">
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
    </div>
</div>

