<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(entradaForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(entradaForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty entradaForm.titleCode}">
    <fmt:message key="${entradaForm.titleCode}" >
      <fmt:param value="${entradaForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty entradaForm.entityNameCode}">
      <fmt:message var="entityname" key="entrada.entrada"/>
    </c:if>
    <c:if test="${not empty entradaForm.entityNameCode}">
      <fmt:message var="entityname" key="${entradaForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${entradaForm.nou?'genapp.createtitle':(entradaForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty entradaForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(entradaForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(entradaForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${entradaForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>