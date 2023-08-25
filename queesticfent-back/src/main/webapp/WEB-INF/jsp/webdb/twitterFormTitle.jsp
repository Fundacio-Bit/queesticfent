<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(twitterForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(twitterForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty twitterForm.titleCode}">
    <fmt:message key="${twitterForm.titleCode}" >
      <fmt:param value="${twitterForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty twitterForm.entityNameCode}">
      <fmt:message var="entityname" key="twitter.twitter"/>
    </c:if>
    <c:if test="${not empty twitterForm.entityNameCode}">
      <fmt:message var="entityname" key="${twitterForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${twitterForm.nou?'genapp.createtitle':(twitterForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty twitterForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(twitterForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(twitterForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${twitterForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>