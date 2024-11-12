<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<form:form name="modificacions" cssClass="form-search"  modelAttribute="modificacionsFilterForm" 
        method="${(empty method)?'post':method}"  enctype="multipart/form-data">

  <%@include file="modificacionsListCommon.jsp" %>
  <div id="${formName}_listheader" class="filterLine lead" style="margin-bottom:10px">
    <%@include file="modificacionsListHeaderButtons.jsp" %>
    <%-- ADD HERE NEW HEADER BUTTONS (Multiple Select or similar to add item)  --%>

  </div>
  <%@include file="modificacionsListSubtitle.jsp" %>
  <%@include file="modificacionsListFilterBy.jsp" %>
  <%-- Inici de div d'AGRUPACIO i TAULA CONTINGUTS --%>  
  <div>
  <%@include file="modificacionsListGroupBy.jsp" %>
  <%-- Inici de div de TAULA CONTINGUTS --%>
  <div style="width: 100%;">
  <%@include file="modificacionsListCore.jsp" %>
  <c:if test="${not empty modificacionsItems && __theFilterForm.footerListVisible}">
          <%@include file="webdbPagination.jsp" %>

  </c:if>

  </div> <%-- Final de div de TAULA CONTINGUTS --%>
  <%--  ADD HERE OTHER CONTENT --%>

  <c:if test="${__theFilterForm.attachedAdditionalJspCode}">
          <%@include file="../webdbmodificable/modificacionsListModificable.jsp" %>
  </c:if>
  
  </div> <%-- Final de div d'AGRUPACIO i TAULA CONTINGUTS --%>

</form:form> 
    

