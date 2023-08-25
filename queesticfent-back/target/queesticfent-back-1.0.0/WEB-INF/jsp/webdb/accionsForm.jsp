
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="accionsForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="accionsFormTitle.jsp" %>
 
  <c:set var="contexte" value="${accionsForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="accionsFormCorePre.jsp" %>

  <%@include file="accionsFormCore.jsp" %>

  <%@include file="accionsFormCorePost.jsp" %>

  <%@include file="accionsFormButtons.jsp" %>

  <c:if test="${not empty accionsForm.sections}">
     <c:set var="__basename" value="accions" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${accionsForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/accionsFormModificable.jsp" %>
  </c:if>

</form:form>


