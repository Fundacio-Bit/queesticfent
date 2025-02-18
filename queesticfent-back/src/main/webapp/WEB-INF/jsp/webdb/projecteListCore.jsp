  <c:if test="${empty projecteItems}">
     <%@include file="projecteListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty projecteItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="projecteListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="projecteListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="projecteListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="projecte" items="${projecteItems}">

        <tr id="projecte_rowid_${projecte.projecteID}">
          <%@include file="projecteListCoreMultipleSelect.jsp" %>

          <%@include file="projecteListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="projecteListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
