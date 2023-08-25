<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${modificacionsQueEsticFentFilterForm.contexte}"/>
  <c:set var="formName" value="modificacionsQueEsticFent" />
  <c:set var="__theFilterForm" value="${modificacionsQueEsticFentFilterForm}" />
  <c:if test="${empty modificacionsQueEsticFentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="modificacionsQueEsticFent.modificacionsQueEsticFent"/>
  </c:if>
  <c:if test="${not empty modificacionsQueEsticFentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${modificacionsQueEsticFentFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty modificacionsQueEsticFentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="modificacionsQueEsticFent.modificacionsQueEsticFent"/>
  </c:if>
  <c:if test="${not empty modificacionsQueEsticFentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${modificacionsQueEsticFentFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.modificacionsQueEsticFent.submit();  
  }
</script>
