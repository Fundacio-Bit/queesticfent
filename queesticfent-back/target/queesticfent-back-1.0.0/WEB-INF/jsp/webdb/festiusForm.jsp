
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="festiusForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="festiusFormTitle.jsp" %>
 
  <c:set var="contexte" value="${festiusForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="festiusFormCorePre.jsp" %>

  <%@include file="festiusFormCore.jsp" %>

  <%@include file="festiusFormCorePost.jsp" %>

  <%@include file="festiusFormButtons.jsp" %>

  <c:if test="${not empty festiusForm.sections}">
     <c:set var="__basename" value="festius" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${festiusForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/festiusFormModificable.jsp" %>
  </c:if>

</form:form>


