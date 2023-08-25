  <c:if test="${empty festiusItems}">
     <%@include file="festiusListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty festiusItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="festiusListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="festiusListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="festiusListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="festius" items="${festiusItems}">

        <tr id="festius_rowid_${festius.festiuid}">
          <%@include file="festiusListCoreMultipleSelect.jsp" %>

          <%@include file="festiusListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="festiusListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
