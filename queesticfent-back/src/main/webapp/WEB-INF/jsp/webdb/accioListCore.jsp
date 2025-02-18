  <c:if test="${empty accioItems}">
     <%@include file="accioListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty accioItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="accioListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="accioListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="accioListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="accio" items="${accioItems}">

        <tr id="accio_rowid_${accio.accioID}">
          <%@include file="accioListCoreMultipleSelect.jsp" %>

          <%@include file="accioListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="accioListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
