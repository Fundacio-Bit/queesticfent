
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="accioForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="accioFormTitle.jsp" %>
 
  <c:set var="contexte" value="${accioForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="accioFormCorePre.jsp" %>

  <%@include file="accioFormCore.jsp" %>

  <%@include file="accioFormCorePost.jsp" %>

  <%@include file="accioFormButtons.jsp" %>

  <c:if test="${not empty accioForm.sections}">
     <c:set var="__basename" value="accio" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${accioForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/accioFormModificable.jsp" %>
  </c:if>

</form:form>


