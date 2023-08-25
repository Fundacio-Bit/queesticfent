<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(grupsForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(grupsForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty grupsForm.titleCode}">
    <fmt:message key="${grupsForm.titleCode}" >
      <fmt:param value="${grupsForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty grupsForm.entityNameCode}">
      <fmt:message var="entityname" key="grups.grups"/>
    </c:if>
    <c:if test="${not empty grupsForm.entityNameCode}">
      <fmt:message var="entityname" key="${grupsForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${grupsForm.nou?'genapp.createtitle':(grupsForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty grupsForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(grupsForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(grupsForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${grupsForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>