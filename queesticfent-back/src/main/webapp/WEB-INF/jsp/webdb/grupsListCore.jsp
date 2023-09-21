  <c:if test="${empty grupsItems}">
     <%@include file="grupsListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty grupsItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="grupsListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="grupsListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="grupsListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="grups" items="${grupsItems}">

        <tr id="grups_rowid_${grups.grupID}">
          <%@include file="grupsListCoreMultipleSelect.jsp" %>

          <%@include file="grupsListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="grupsListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
