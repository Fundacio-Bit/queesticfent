  <c:if test="${empty modificacionsItems}">
     <%@include file="modificacionsListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty modificacionsItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="modificacionsListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="modificacionsListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="modificacionsListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="modificacions" items="${modificacionsItems}">

        <tr id="modificacions_rowid_${modificacions.modificacioid}">
          <%@include file="modificacionsListCoreMultipleSelect.jsp" %>

          <%@include file="modificacionsListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="modificacionsListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
