<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menuItemDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='menuItemDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="menuItemList.menuItem"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="menuItemDetail.heading"/></h2>
    <fmt:message key="menuItemDetail.message"/>
</div>

<div class="span7">
    <s:form id="menuItemForm" action="saveMenuItem" method="post" validate="true" cssClass="well form-horizontal">
            <s:hidden key="menuItem.id"/>
        <s:textfield key="menuItem.action" required="false" maxlength="50" />
        <s:textfield key="menuItem.altImage" required="false" maxlength="30" />
        <s:textfield key="menuItem.description" required="false" maxlength="50" />
        <s:textfield key="menuItem.forward" required="false" maxlength="50" />
        <s:textfield key="menuItem.height" required="false" maxlength="5" />
        <s:textfield key="menuItem.image" required="false" maxlength="50" />
        <s:textfield key="menuItem.location" required="false" maxlength="255" />
        <s:textfield key="menuItem.name" required="false" maxlength="30" />
        <s:textfield key="menuItem.onclick" required="false" maxlength="100" />
        <s:textfield key="menuItem.onmouseout" required="false" maxlength="100" />
        <s:textfield key="menuItem.onmouseover" required="false" maxlength="100" />
        <s:textfield key="menuItem.page" required="false" maxlength="255" />
        <!-- todo: change this to read the identifier field from the other pojo -->
        <s:select name="menuItem.parentMenuItem.id" list="parentMenuItemList" listKey="id" listValue="id"></s:select>
        <s:textfield key="menuItem.roles" required="false" maxlength="100" />
        <s:textfield key="menuItem.target" required="false" maxlength="10" />
        <s:textfield key="menuItem.title" required="false" maxlength="30" />
        <s:textfield key="menuItem.tooltip" required="false" maxlength="100" />
        <s:textfield key="menuItem.width" required="false" maxlength="5" />

        <div id="actions" class="form-actions">
            <s:submit type="button" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty menuItem.id}">
                <s:submit type="button" cssClass="btn btn-warning" method="delete" key="button.delete"
                    onclick="return confirmMessage(msgDelConfirm)" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <s:submit type="button" cssClass="btn" method="cancel" key="button.cancel" theme="simple">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </s:submit>
        </div>
    </s:form>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['menuItemForm']).focus();
    });
</script>
