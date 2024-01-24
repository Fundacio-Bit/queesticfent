  <c:if test="${empty twitterItems}">
     <%@include file="twitterListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty twitterItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="twitterListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="twitterListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="twitterListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="twitter" items="${twitterItems}">

        <tr id="twitter_rowid_${twitter.id}">
          <%@include file="twitterListCoreMultipleSelect.jsp" %>

          <%@include file="twitterListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="twitterListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
