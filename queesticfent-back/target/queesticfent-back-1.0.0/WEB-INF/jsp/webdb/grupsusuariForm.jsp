
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="grupsusuariForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="grupsusuariFormTitle.jsp" %>
 
  <c:set var="contexte" value="${grupsusuariForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="grupsusuariFormCorePre.jsp" %>

  <%@include file="grupsusuariFormCore.jsp" %>

  <%@include file="grupsusuariFormCorePost.jsp" %>

  <%@include file="grupsusuariFormButtons.jsp" %>

  <c:if test="${not empty grupsusuariForm.sections}">
     <c:set var="__basename" value="grupsusuari" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${grupsusuariForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/grupsusuariFormModificable.jsp" %>
  </c:if>

</form:form>


