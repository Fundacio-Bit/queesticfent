
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="entradesForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="entradesFormTitle.jsp" %>
 
  <c:set var="contexte" value="${entradesForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="entradesFormCorePre.jsp" %>

  <%@include file="entradesFormCore.jsp" %>

  <%@include file="entradesFormCorePost.jsp" %>

  <%@include file="entradesFormButtons.jsp" %>

  <c:if test="${not empty entradesForm.sections}">
     <c:set var="__basename" value="entrades" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${entradesForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/entradesFormModificable.jsp" %>
  </c:if>

</form:form>


