<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<form:form name="entrades" cssClass="form-search"  modelAttribute="entradesFilterForm" 
        method="${(empty method)?'post':method}"  enctype="multipart/form-data">

  <%@include file="entradesListCommon.jsp" %>
  <div id="${formName}_listheader" class="filterLine lead" style="margin-bottom:10px">
    <%@include file="entradesListHeaderButtons.jsp" %>
    <%-- ADD HERE NEW HEADER BUTTONS (Multiple Select or similar to add item)  --%>

  </div>
  <%@include file="entradesListSubtitle.jsp" %>
  <%@include file="entradesListFilterBy.jsp" %>
  <%-- Inici de div d'AGRUPACIO i TAULA CONTINGUTS --%>  
  <div>
  <%@include file="entradesListGroupBy.jsp" %>
  <%-- Inici de div de TAULA CONTINGUTS --%>
  <div style="width: 100%;">
  <%@include file="entradesListCore.jsp" %>
  <c:if test="${not empty entradesItems && __theFilterForm.footerListVisible}">
          <%@include file="webdbPagination.jsp" %>

  </c:if>

  </div> <%-- Final de div de TAULA CONTINGUTS --%>
  <%--  ADD HERE OTHER CONTENT --%>

  <c:if test="${__theFilterForm.attachedAdditionalJspCode}">
          <%@include file="../webdbmodificable/entradesListModificable.jsp" %>
  </c:if>
  
  </div> <%-- Final de div d'AGRUPACIO i TAULA CONTINGUTS --%>

</form:form> 
    

