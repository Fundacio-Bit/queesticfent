
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="departamentsForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="departamentsFormTitle.jsp" %>
 
  <c:set var="contexte" value="${departamentsForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="departamentsFormCorePre.jsp" %>

  <%@include file="departamentsFormCore.jsp" %>

  <%@include file="departamentsFormCorePost.jsp" %>

  <%@include file="departamentsFormButtons.jsp" %>

  <c:if test="${not empty departamentsForm.sections}">
     <c:set var="__basename" value="departaments" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${departamentsForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/departamentsFormModificable.jsp" %>
  </c:if>

</form:form>


