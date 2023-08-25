  <c:if test="${empty projectesItems}">
     <%@include file="projectesListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty projectesItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="projectesListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="projectesListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="projectesListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="projectes" items="${projectesItems}">

        <tr id="projectes_rowid_${projectes.projecteid}">
          <%@include file="projectesListCoreMultipleSelect.jsp" %>

          <%@include file="projectesListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="projectesListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
