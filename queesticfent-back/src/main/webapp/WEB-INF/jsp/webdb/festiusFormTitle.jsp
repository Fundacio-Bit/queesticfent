<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(festiusForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(festiusForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty festiusForm.titleCode}">
    <fmt:message key="${festiusForm.titleCode}" >
      <fmt:param value="${festiusForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty festiusForm.entityNameCode}">
      <fmt:message var="entityname" key="festius.festius"/>
    </c:if>
    <c:if test="${not empty festiusForm.entityNameCode}">
      <fmt:message var="entityname" key="${festiusForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${festiusForm.nou?'genapp.createtitle':(festiusForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty festiusForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(festiusForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(festiusForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${festiusForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>