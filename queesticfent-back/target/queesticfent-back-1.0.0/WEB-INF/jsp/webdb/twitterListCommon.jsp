<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${twitterFilterForm.contexte}"/>
  <c:set var="formName" value="twitter" />
  <c:set var="__theFilterForm" value="${twitterFilterForm}" />
  <c:if test="${empty twitterFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="twitter.twitter"/>
  </c:if>
  <c:if test="${not empty twitterFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${twitterFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty twitterFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="twitter.twitter"/>
  </c:if>
  <c:if test="${not empty twitterFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${twitterFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.twitter.submit();  
  }
</script>
