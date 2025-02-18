
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="usuariDepartamentForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="usuariDepartamentFormTitle.jsp" %>
 
  <c:set var="contexte" value="${usuariDepartamentForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="usuariDepartamentFormCorePre.jsp" %>

  <%@include file="usuariDepartamentFormCore.jsp" %>

  <%@include file="usuariDepartamentFormCorePost.jsp" %>

  <%@include file="usuariDepartamentFormButtons.jsp" %>

  <c:if test="${not empty usuariDepartamentForm.sections}">
     <c:set var="__basename" value="usuariDepartament" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${usuariDepartamentForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/usuariDepartamentFormModificable.jsp" %>
  </c:if>

</form:form>


