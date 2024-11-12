<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${modificacionsFilterForm.contexte}"/>
  <c:set var="formName" value="modificacions" />
  <c:set var="__theFilterForm" value="${modificacionsFilterForm}" />
  <c:if test="${empty modificacionsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="modificacions.modificacions"/>
  </c:if>
  <c:if test="${not empty modificacionsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${modificacionsFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty modificacionsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="modificacions.modificacions"/>
  </c:if>
  <c:if test="${not empty modificacionsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${modificacionsFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.modificacions.submit();  
  }
</script>
