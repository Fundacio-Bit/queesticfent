<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${entradesFilterForm.contexte}"/>
  <c:set var="formName" value="entrades" />
  <c:set var="__theFilterForm" value="${entradesFilterForm}" />
  <c:if test="${empty entradesFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="entrades.entrades"/>
  </c:if>
  <c:if test="${not empty entradesFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${entradesFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty entradesFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="entrades.entrades"/>
  </c:if>
  <c:if test="${not empty entradesFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${entradesFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.entrades.submit();  
  }
</script>
