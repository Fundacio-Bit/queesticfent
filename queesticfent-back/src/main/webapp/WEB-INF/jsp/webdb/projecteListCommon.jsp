<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${projecteFilterForm.contexte}"/>
  <c:set var="formName" value="projecte" />
  <c:set var="__theFilterForm" value="${projecteFilterForm}" />
  <c:if test="${empty projecteFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="projecte.projecte"/>
  </c:if>
  <c:if test="${not empty projecteFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${projecteFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty projecteFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="projecte.projecte"/>
  </c:if>
  <c:if test="${not empty projecteFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${projecteFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.projecte.submit();  
  }
</script>
