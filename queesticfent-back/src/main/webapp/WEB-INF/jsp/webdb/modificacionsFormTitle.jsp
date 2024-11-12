<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(modificacionsForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(modificacionsForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty modificacionsForm.titleCode}">
    <fmt:message key="${modificacionsForm.titleCode}" >
      <fmt:param value="${modificacionsForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty modificacionsForm.entityNameCode}">
      <fmt:message var="entityname" key="modificacions.modificacions"/>
    </c:if>
    <c:if test="${not empty modificacionsForm.entityNameCode}">
      <fmt:message var="entityname" key="${modificacionsForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${modificacionsForm.nou?'genapp.createtitle':(modificacionsForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty modificacionsForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(modificacionsForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(modificacionsForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${modificacionsForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>