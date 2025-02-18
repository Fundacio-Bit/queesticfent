<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(usuariDepartamentForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(usuariDepartamentForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty usuariDepartamentForm.titleCode}">
    <fmt:message key="${usuariDepartamentForm.titleCode}" >
      <fmt:param value="${usuariDepartamentForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty usuariDepartamentForm.entityNameCode}">
      <fmt:message var="entityname" key="usuariDepartament.usuariDepartament"/>
    </c:if>
    <c:if test="${not empty usuariDepartamentForm.entityNameCode}">
      <fmt:message var="entityname" key="${usuariDepartamentForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${usuariDepartamentForm.nou?'genapp.createtitle':(usuariDepartamentForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty usuariDepartamentForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(usuariDepartamentForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(usuariDepartamentForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${usuariDepartamentForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>