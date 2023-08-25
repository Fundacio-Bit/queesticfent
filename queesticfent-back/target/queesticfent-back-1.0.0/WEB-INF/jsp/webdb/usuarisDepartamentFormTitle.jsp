<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(usuarisDepartamentForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(usuarisDepartamentForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty usuarisDepartamentForm.titleCode}">
    <fmt:message key="${usuarisDepartamentForm.titleCode}" >
      <fmt:param value="${usuarisDepartamentForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty usuarisDepartamentForm.entityNameCode}">
      <fmt:message var="entityname" key="usuarisDepartament.usuarisDepartament"/>
    </c:if>
    <c:if test="${not empty usuarisDepartamentForm.entityNameCode}">
      <fmt:message var="entityname" key="${usuarisDepartamentForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${usuarisDepartamentForm.nou?'genapp.createtitle':(usuarisDepartamentForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty usuarisDepartamentForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(usuarisDepartamentForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(usuarisDepartamentForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${usuarisDepartamentForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>