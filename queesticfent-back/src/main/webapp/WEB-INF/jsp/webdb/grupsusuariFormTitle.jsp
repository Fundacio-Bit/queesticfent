<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(grupsusuariForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(grupsusuariForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty grupsusuariForm.titleCode}">
    <fmt:message key="${grupsusuariForm.titleCode}" >
      <fmt:param value="${grupsusuariForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty grupsusuariForm.entityNameCode}">
      <fmt:message var="entityname" key="grupsusuari.grupsusuari"/>
    </c:if>
    <c:if test="${not empty grupsusuariForm.entityNameCode}">
      <fmt:message var="entityname" key="${grupsusuariForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${grupsusuariForm.nou?'genapp.createtitle':(grupsusuariForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty grupsusuariForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(grupsusuariForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(grupsusuariForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${grupsusuariForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>