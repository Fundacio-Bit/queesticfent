
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="projecteForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="projecteFormTitle.jsp" %>
 
  <c:set var="contexte" value="${projecteForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="projecteFormCorePre.jsp" %>

  <%@include file="projecteFormCore.jsp" %>

  <%@include file="projecteFormCorePost.jsp" %>

  <%@include file="projecteFormButtons.jsp" %>

  <c:if test="${not empty projecteForm.sections}">
     <c:set var="__basename" value="projecte" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${projecteForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/projecteFormModificable.jsp" %>
  </c:if>

</form:form>


