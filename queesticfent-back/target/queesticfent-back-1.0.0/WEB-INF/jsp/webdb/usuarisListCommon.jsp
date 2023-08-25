<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${usuarisFilterForm.contexte}"/>
  <c:set var="formName" value="usuaris" />
  <c:set var="__theFilterForm" value="${usuarisFilterForm}" />
  <c:if test="${empty usuarisFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="usuaris.usuaris"/>
  </c:if>
  <c:if test="${not empty usuarisFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${usuarisFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty usuarisFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="usuaris.usuaris"/>
  </c:if>
  <c:if test="${not empty usuarisFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${usuarisFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.usuaris.submit();  
  }
</script>
