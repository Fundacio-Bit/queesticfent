<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(departamentsForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(departamentsForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty departamentsForm.titleCode}">
    <fmt:message key="${departamentsForm.titleCode}" >
      <fmt:param value="${departamentsForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty departamentsForm.entityNameCode}">
      <fmt:message var="entityname" key="departaments.departaments"/>
    </c:if>
    <c:if test="${not empty departamentsForm.entityNameCode}">
      <fmt:message var="entityname" key="${departamentsForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${departamentsForm.nou?'genapp.createtitle':(departamentsForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty departamentsForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(departamentsForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(departamentsForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${departamentsForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>