<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${festiusFilterForm.contexte}"/>
  <c:set var="formName" value="festius" />
  <c:set var="__theFilterForm" value="${festiusFilterForm}" />
  <c:if test="${empty festiusFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="festius.festius"/>
  </c:if>
  <c:if test="${not empty festiusFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${festiusFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty festiusFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="festius.festius"/>
  </c:if>
  <c:if test="${not empty festiusFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${festiusFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.festius.submit();  
  }
</script>
