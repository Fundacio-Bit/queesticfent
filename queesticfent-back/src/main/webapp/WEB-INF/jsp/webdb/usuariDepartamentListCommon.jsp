<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${usuariDepartamentFilterForm.contexte}"/>
  <c:set var="formName" value="usuariDepartament" />
  <c:set var="__theFilterForm" value="${usuariDepartamentFilterForm}" />
  <c:if test="${empty usuariDepartamentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="usuariDepartament.usuariDepartament"/>
  </c:if>
  <c:if test="${not empty usuariDepartamentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${usuariDepartamentFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty usuariDepartamentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="usuariDepartament.usuariDepartament"/>
  </c:if>
  <c:if test="${not empty usuariDepartamentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${usuariDepartamentFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.usuariDepartament.submit();  
  }
</script>
