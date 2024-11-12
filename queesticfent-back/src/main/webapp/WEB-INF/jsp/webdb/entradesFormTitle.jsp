<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(entradesForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(entradesForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty entradesForm.titleCode}">
    <fmt:message key="${entradesForm.titleCode}" >
      <fmt:param value="${entradesForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty entradesForm.entityNameCode}">
      <fmt:message var="entityname" key="entrades.entrades"/>
    </c:if>
    <c:if test="${not empty entradesForm.entityNameCode}">
      <fmt:message var="entityname" key="${entradesForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${entradesForm.nou?'genapp.createtitle':(entradesForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty entradesForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(entradesForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(entradesForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${entradesForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>