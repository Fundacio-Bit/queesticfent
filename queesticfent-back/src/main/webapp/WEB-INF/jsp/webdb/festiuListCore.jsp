  <c:if test="${empty festiuItems}">
     <%@include file="festiuListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty festiuItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="festiuListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="festiuListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="festiuListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="festiu" items="${festiuItems}">

        <tr id="festiu_rowid_${festiu.festiuID}">
          <%@include file="festiuListCoreMultipleSelect.jsp" %>

          <%@include file="festiuListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="festiuListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
