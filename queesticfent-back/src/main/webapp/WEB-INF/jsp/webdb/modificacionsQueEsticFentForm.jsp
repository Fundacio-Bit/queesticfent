
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="modificacionsQueEsticFentForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="modificacionsQueEsticFentFormTitle.jsp" %>
 
  <c:set var="contexte" value="${modificacionsQueEsticFentForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="modificacionsQueEsticFentFormCorePre.jsp" %>

  <%@include file="modificacionsQueEsticFentFormCore.jsp" %>

  <%@include file="modificacionsQueEsticFentFormCorePost.jsp" %>

  <%@include file="modificacionsQueEsticFentFormButtons.jsp" %>

  <c:if test="${not empty modificacionsQueEsticFentForm.sections}">
     <c:set var="__basename" value="modificacionsQueEsticFent" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${modificacionsQueEsticFentForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/modificacionsQueEsticFentFormModificable.jsp" %>
  </c:if>

</form:form>


