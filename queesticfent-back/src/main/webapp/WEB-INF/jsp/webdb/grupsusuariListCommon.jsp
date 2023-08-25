<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${grupsusuariFilterForm.contexte}"/>
  <c:set var="formName" value="grupsusuari" />
  <c:set var="__theFilterForm" value="${grupsusuariFilterForm}" />
  <c:if test="${empty grupsusuariFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="grupsusuari.grupsusuari"/>
  </c:if>
  <c:if test="${not empty grupsusuariFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${grupsusuariFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty grupsusuariFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="grupsusuari.grupsusuari"/>
  </c:if>
  <c:if test="${not empty grupsusuariFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${grupsusuariFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.grupsusuari.submit();  
  }
</script>
