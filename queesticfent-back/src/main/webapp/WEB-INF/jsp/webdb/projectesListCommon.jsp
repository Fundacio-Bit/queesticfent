<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${projectesFilterForm.contexte}"/>
  <c:set var="formName" value="projectes" />
  <c:set var="__theFilterForm" value="${projectesFilterForm}" />
  <c:if test="${empty projectesFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="projectes.projectes"/>
  </c:if>
  <c:if test="${not empty projectesFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${projectesFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty projectesFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="projectes.projectes"/>
  </c:if>
  <c:if test="${not empty projectesFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${projectesFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.projectes.submit();  
  }
</script>
