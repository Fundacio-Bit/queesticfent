<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(accioForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(accioForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty accioForm.titleCode}">
    <fmt:message key="${accioForm.titleCode}" >
      <fmt:param value="${accioForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty accioForm.entityNameCode}">
      <fmt:message var="entityname" key="accio.accio"/>
    </c:if>
    <c:if test="${not empty accioForm.entityNameCode}">
      <fmt:message var="entityname" key="${accioForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${accioForm.nou?'genapp.createtitle':(accioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty accioForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(accioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(accioForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${accioForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>