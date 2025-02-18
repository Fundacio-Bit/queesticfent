
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="festiuForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="festiuFormTitle.jsp" %>
 
  <c:set var="contexte" value="${festiuForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="festiuFormCorePre.jsp" %>

  <%@include file="festiuFormCore.jsp" %>

  <%@include file="festiuFormCorePost.jsp" %>

  <%@include file="festiuFormButtons.jsp" %>

  <c:if test="${not empty festiuForm.sections}">
     <c:set var="__basename" value="festiu" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${festiuForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/festiuFormModificable.jsp" %>
  </c:if>

</form:form>


