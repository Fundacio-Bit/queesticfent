  <c:if test="${empty accionsItems}">
     <%@include file="accionsListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty accionsItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="accionsListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="accionsListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="accionsListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="accions" items="${accionsItems}">

        <tr id="accions_rowid_${accions.accioid}">
          <%@include file="accionsListCoreMultipleSelect.jsp" %>

          <%@include file="accionsListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="accionsListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
