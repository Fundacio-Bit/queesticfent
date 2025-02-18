<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${accioFilterForm.contexte}"/>
  <c:set var="formName" value="accio" />
  <c:set var="__theFilterForm" value="${accioFilterForm}" />
  <c:if test="${empty accioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="accio.accio"/>
  </c:if>
  <c:if test="${not empty accioFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${accioFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty accioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="accio.accio"/>
  </c:if>
  <c:if test="${not empty accioFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${accioFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.accio.submit();  
  }
</script>
