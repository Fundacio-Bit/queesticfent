<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(modificacionsQueEsticFentForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(modificacionsQueEsticFentForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty modificacionsQueEsticFentForm.titleCode}">
    <fmt:message key="${modificacionsQueEsticFentForm.titleCode}" >
      <fmt:param value="${modificacionsQueEsticFentForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty modificacionsQueEsticFentForm.entityNameCode}">
      <fmt:message var="entityname" key="modificacionsQueEsticFent.modificacionsQueEsticFent"/>
    </c:if>
    <c:if test="${not empty modificacionsQueEsticFentForm.entityNameCode}">
      <fmt:message var="entityname" key="${modificacionsQueEsticFentForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${modificacionsQueEsticFentForm.nou?'genapp.createtitle':(modificacionsQueEsticFentForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty modificacionsQueEsticFentForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(modificacionsQueEsticFentForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(modificacionsQueEsticFentForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${modificacionsQueEsticFentForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>