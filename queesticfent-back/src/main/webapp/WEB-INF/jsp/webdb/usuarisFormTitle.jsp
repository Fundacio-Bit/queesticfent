<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(usuarisForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(usuarisForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty usuarisForm.titleCode}">
    <fmt:message key="${usuarisForm.titleCode}" >
      <fmt:param value="${usuarisForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty usuarisForm.entityNameCode}">
      <fmt:message var="entityname" key="usuaris.usuaris"/>
    </c:if>
    <c:if test="${not empty usuarisForm.entityNameCode}">
      <fmt:message var="entityname" key="${usuarisForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${usuarisForm.nou?'genapp.createtitle':(usuarisForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty usuarisForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(usuarisForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(usuarisForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${usuarisForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>