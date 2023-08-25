
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="usuarisDepartamentForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="usuarisDepartamentFormTitle.jsp" %>
 
  <c:set var="contexte" value="${usuarisDepartamentForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="usuarisDepartamentFormCorePre.jsp" %>

  <%@include file="usuarisDepartamentFormCore.jsp" %>

  <%@include file="usuarisDepartamentFormCorePost.jsp" %>

  <%@include file="usuarisDepartamentFormButtons.jsp" %>

  <c:if test="${not empty usuarisDepartamentForm.sections}">
     <c:set var="__basename" value="usuarisDepartament" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${usuarisDepartamentForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/usuarisDepartamentFormModificable.jsp" %>
  </c:if>

</form:form>


