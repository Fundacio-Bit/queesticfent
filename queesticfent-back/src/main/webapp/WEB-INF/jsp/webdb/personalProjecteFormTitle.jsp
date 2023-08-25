<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(personalProjecteForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(personalProjecteForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty personalProjecteForm.titleCode}">
    <fmt:message key="${personalProjecteForm.titleCode}" >
      <fmt:param value="${personalProjecteForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty personalProjecteForm.entityNameCode}">
      <fmt:message var="entityname" key="personalProjecte.personalProjecte"/>
    </c:if>
    <c:if test="${not empty personalProjecteForm.entityNameCode}">
      <fmt:message var="entityname" key="${personalProjecteForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${personalProjecteForm.nou?'genapp.createtitle':(personalProjecteForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty personalProjecteForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(personalProjecteForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(personalProjecteForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${personalProjecteForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>