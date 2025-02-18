<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${modificacioQueEsticFentFilterForm.contexte}"/>
  <c:set var="formName" value="modificacioQueEsticFent" />
  <c:set var="__theFilterForm" value="${modificacioQueEsticFentFilterForm}" />
  <c:if test="${empty modificacioQueEsticFentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="modificacioQueEsticFent.modificacioQueEsticFent"/>
  </c:if>
  <c:if test="${not empty modificacioQueEsticFentFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${modificacioQueEsticFentFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty modificacioQueEsticFentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="modificacioQueEsticFent.modificacioQueEsticFent"/>
  </c:if>
  <c:if test="${not empty modificacioQueEsticFentFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${modificacioQueEsticFentFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.modificacioQueEsticFent.submit();  
  }
</script>
