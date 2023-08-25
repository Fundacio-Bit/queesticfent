
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="usuarisForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="usuarisFormTitle.jsp" %>
 
  <c:set var="contexte" value="${usuarisForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="usuarisFormCorePre.jsp" %>

  <%@include file="usuarisFormCore.jsp" %>

  <%@include file="usuarisFormCorePost.jsp" %>

  <%@include file="usuarisFormButtons.jsp" %>

  <c:if test="${not empty usuarisForm.sections}">
     <c:set var="__basename" value="usuaris" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${usuarisForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/usuarisFormModificable.jsp" %>
  </c:if>

</form:form>


