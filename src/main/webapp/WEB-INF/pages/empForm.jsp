<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="empDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='empDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="empList.emp"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="empDetail.heading"/></h2>
    <fmt:message key="empDetail.message"/>
</div>

<div class="span7">
    <s:form id="empForm" action="saveEmp" method="post" validate="true" cssClass="well form-horizontal">
            <s:hidden key="emp.eid"/>
        <s:textfield key="emp.eage" required="false" maxlength="255" />
        <s:textfield key="emp.ename" required="false" maxlength="50" />
        <s:textfield key="emp.estate" required="false" maxlength="255" />

        <div id="actions" class="form-actions">
            <s:submit type="button" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty emp.eid}">
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
        $("input[type='text']:visible:enabled:first", document.forms['empForm']).focus();
    });
</script>
