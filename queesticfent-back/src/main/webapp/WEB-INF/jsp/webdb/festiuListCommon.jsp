<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${festiuFilterForm.contexte}"/>
  <c:set var="formName" value="festiu" />
  <c:set var="__theFilterForm" value="${festiuFilterForm}" />
  <c:if test="${empty festiuFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="festiu.festiu"/>
  </c:if>
  <c:if test="${not empty festiuFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${festiuFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty festiuFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="festiu.festiu"/>
  </c:if>
  <c:if test="${not empty festiuFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${festiuFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.festiu.submit();  
  }
</script>
