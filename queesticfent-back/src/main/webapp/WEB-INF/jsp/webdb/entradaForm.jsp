
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="entradaForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="entradaFormTitle.jsp" %>
 
  <c:set var="contexte" value="${entradaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="entradaFormCorePre.jsp" %>

  <%@include file="entradaFormCore.jsp" %>

  <%@include file="entradaFormCorePost.jsp" %>

  <%@include file="entradaFormButtons.jsp" %>

  <c:if test="${not empty entradaForm.sections}">
     <c:set var="__basename" value="entrada" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${entradaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/entradaFormModificable.jsp" %>
  </c:if>

</form:form>


