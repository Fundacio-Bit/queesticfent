
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="modificacionsForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="modificacionsFormTitle.jsp" %>
 
  <c:set var="contexte" value="${modificacionsForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="modificacionsFormCorePre.jsp" %>

  <%@include file="modificacionsFormCore.jsp" %>

  <%@include file="modificacionsFormCorePost.jsp" %>

  <%@include file="modificacionsFormButtons.jsp" %>

  <c:if test="${not empty modificacionsForm.sections}">
     <c:set var="__basename" value="modificacions" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${modificacionsForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/modificacionsFormModificable.jsp" %>
  </c:if>

</form:form>


