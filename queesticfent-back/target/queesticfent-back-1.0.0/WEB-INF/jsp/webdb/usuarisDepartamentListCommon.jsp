<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${usuarisDepartamentFilterForm.contexte}"/>
  <c:set var="formName" value="usuarisDepartament" />
  <c:set var="__theFilterForm" value="${usuarisDepartamentFilterForm}" />
  <c:if test="${empty usuarisDepartamentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="usuarisDepartament.usuarisDepartament"/>
  </c:if>
  <c:if test="${not empty usuarisDepartamentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${usuarisDepartamentFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty usuarisDepartamentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="usuarisDepartament.usuarisDepartament"/>
  </c:if>
  <c:if test="${not empty usuarisDepartamentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${usuarisDepartamentFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.usuarisDepartament.submit();  
  }
</script>
