  <c:if test="${empty departamentsItems}">
     <%@include file="departamentsListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty departamentsItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="departamentsListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="departamentsListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="departamentsListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="departaments" items="${departamentsItems}">

        <tr id="departaments_rowid_${departaments.departamentid}">
          <%@include file="departamentsListCoreMultipleSelect.jsp" %>

          <%@include file="departamentsListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="departamentsListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
