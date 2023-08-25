
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="personalProjecteForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="personalProjecteFormTitle.jsp" %>
 
  <c:set var="contexte" value="${personalProjecteForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="personalProjecteFormCorePre.jsp" %>

  <%@include file="personalProjecteFormCore.jsp" %>

  <%@include file="personalProjecteFormCorePost.jsp" %>

  <%@include file="personalProjecteFormButtons.jsp" %>

  <c:if test="${not empty personalProjecteForm.sections}">
     <c:set var="__basename" value="personalProjecte" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${personalProjecteForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/personalProjecteFormModificable.jsp" %>
  </c:if>

</form:form>


