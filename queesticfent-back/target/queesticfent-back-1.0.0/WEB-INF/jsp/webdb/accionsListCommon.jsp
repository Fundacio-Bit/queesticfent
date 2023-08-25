<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${accionsFilterForm.contexte}"/>
  <c:set var="formName" value="accions" />
  <c:set var="__theFilterForm" value="${accionsFilterForm}" />
  <c:if test="${empty accionsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="accions.accions"/>
  </c:if>
  <c:if test="${not empty accionsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${accionsFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty accionsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="accions.accions"/>
  </c:if>
  <c:if test="${not empty accionsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${accionsFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.accions.submit();  
  }
</script>
