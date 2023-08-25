<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${departamentsFilterForm.contexte}"/>
  <c:set var="formName" value="departaments" />
  <c:set var="__theFilterForm" value="${departamentsFilterForm}" />
  <c:if test="${empty departamentsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="departaments.departaments"/>
  </c:if>
  <c:if test="${not empty departamentsFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${departamentsFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty departamentsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="departaments.departaments"/>
  </c:if>
  <c:if test="${not empty departamentsFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${departamentsFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.departaments.submit();  
  }
</script>
