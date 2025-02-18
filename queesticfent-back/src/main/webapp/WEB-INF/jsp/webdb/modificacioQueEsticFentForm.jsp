
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="modificacioQueEsticFentForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="modificacioQueEsticFentFormTitle.jsp" %>
 
  <c:set var="contexte" value="${modificacioQueEsticFentForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="modificacioQueEsticFentFormCorePre.jsp" %>

  <%@include file="modificacioQueEsticFentFormCore.jsp" %>

  <%@include file="modificacioQueEsticFentFormCorePost.jsp" %>

  <%@include file="modificacioQueEsticFentFormButtons.jsp" %>

  <c:if test="${not empty modificacioQueEsticFentForm.sections}">
     <c:set var="__basename" value="modificacioQueEsticFent" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${modificacioQueEsticFentForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/modificacioQueEsticFentFormModificable.jsp" %>
  </c:if>

</form:form>


