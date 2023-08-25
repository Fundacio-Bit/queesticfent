<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(projectesForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(projectesForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty projectesForm.titleCode}">
    <fmt:message key="${projectesForm.titleCode}" >
      <fmt:param value="${projectesForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty projectesForm.entityNameCode}">
      <fmt:message var="entityname" key="projectes.projectes"/>
    </c:if>
    <c:if test="${not empty projectesForm.entityNameCode}">
      <fmt:message var="entityname" key="${projectesForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${projectesForm.nou?'genapp.createtitle':(projectesForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty projectesForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(projectesForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(projectesForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${projectesForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>