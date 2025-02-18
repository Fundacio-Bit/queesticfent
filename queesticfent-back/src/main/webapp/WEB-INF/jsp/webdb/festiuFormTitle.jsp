<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(festiuForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(festiuForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty festiuForm.titleCode}">
    <fmt:message key="${festiuForm.titleCode}" >
      <fmt:param value="${festiuForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty festiuForm.entityNameCode}">
      <fmt:message var="entityname" key="festiu.festiu"/>
    </c:if>
    <c:if test="${not empty festiuForm.entityNameCode}">
      <fmt:message var="entityname" key="${festiuForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${festiuForm.nou?'genapp.createtitle':(festiuForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty festiuForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(festiuForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(festiuForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${festiuForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>