
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="projectesForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="projectesFormTitle.jsp" %>
 
  <c:set var="contexte" value="${projectesForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="projectesFormCorePre.jsp" %>

  <%@include file="projectesFormCore.jsp" %>

  <%@include file="projectesFormCorePost.jsp" %>

  <%@include file="projectesFormButtons.jsp" %>

  <c:if test="${not empty projectesForm.sections}">
     <c:set var="__basename" value="projectes" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${projectesForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/projectesFormModificable.jsp" %>
  </c:if>

</form:form>


