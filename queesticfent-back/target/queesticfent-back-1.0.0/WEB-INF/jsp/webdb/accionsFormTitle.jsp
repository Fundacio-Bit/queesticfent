<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(accionsForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(accionsForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty accionsForm.titleCode}">
    <fmt:message key="${accionsForm.titleCode}" >
      <fmt:param value="${accionsForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty accionsForm.entityNameCode}">
      <fmt:message var="entityname" key="accions.accions"/>
    </c:if>
    <c:if test="${not empty accionsForm.entityNameCode}">
      <fmt:message var="entityname" key="${accionsForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${accionsForm.nou?'genapp.createtitle':(accionsForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty accionsForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(accionsForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(accionsForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${accionsForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>