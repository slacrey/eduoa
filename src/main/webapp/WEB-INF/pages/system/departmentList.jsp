<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="empList.title"/></title>
    <meta name="menu" content="EmpMenu"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/zTreeStyle/zTreeStyle.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/zTree/js/jquery.ztree.core-3.5.js'/>"></script>
    <script type="text/javascript">
        <!--
        var setting = {
            async: {
                enable: true,
                url:"${ctx}/system/initTree?ajax=true",
                autoParam:["id=parentId", "name=n", "level=lv"],
                otherParam:{"otherParam":"zTreeAsyncTest"},
                dataFilter: filter
            },
            callback: {
                onClick: onClick
            }
        };

        function onClick(event, treeId, treeNode, clickFlag) {

        }

        function filter(treeId, parentNode, childNodes) {
            if (!childNodes) return null;
            for (var i=0, l=childNodes.length; i<l; i++) {
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
            }
            return childNodes;
        }


        $(document).ready(function(){
//            $.fn.zTree.init($("#treeDemo"), setting, zNodes);

            var treeObj = $.fn.zTree.init($("#treeDemo"), setting);
            treeObj.expandAll(true);

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

            <display:table name="oaDepartmentEntities" class="table table-condensed table-striped table-hover" requestURI=""
                           id="departmentList" export="true" pagesize="25">
                <display:column property="departName" escapeXml="true"  media="html" sortable="true" titleKey="department.departName" style="width: 25%"
                                url="/editUser?from=list" paramId="id" paramProperty="id"/>
                <display:column property="description" sortable="true" titleKey="department.description"/>

                <display:setProperty name="paging.banner.item_name"><fmt:message key="empList.emp"/></display:setProperty>
                <display:setProperty name="paging.banner.items_name"><fmt:message key="empList.emps"/></display:setProperty>

                <display:setProperty name="export.excel.filename"><fmt:message key="empList.title"/>.xls</display:setProperty>
                <display:setProperty name="export.csv.filename"><fmt:message key="empList.title"/>.csv</display:setProperty>
                <display:setProperty name="export.pdf.filename"><fmt:message key="empList.title"/>.pdf</display:setProperty>
            </display:table>
        </div>
    </div>
</div>

