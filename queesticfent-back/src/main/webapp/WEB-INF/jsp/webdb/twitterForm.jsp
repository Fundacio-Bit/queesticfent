
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>


<form:form modelAttribute="twitterForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <%@include file="twitterFormTitle.jsp" %>
 
  <c:set var="contexte" value="${twitterForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="twitterFormCorePre.jsp" %>

  <%@include file="twitterFormCore.jsp" %>

  <%@include file="twitterFormCorePost.jsp" %>

  <%@include file="twitterFormButtons.jsp" %>

  <c:if test="${not empty twitterForm.sections}">
     <c:set var="__basename" value="twitter" scope="page" />
     <%@include file="sections.jsp"%>
  </c:if>


  <c:if test="${twitterForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/twitterFormModificable.jsp" %>
  </c:if>

</form:form>


