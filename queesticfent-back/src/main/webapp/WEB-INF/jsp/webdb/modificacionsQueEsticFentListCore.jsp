  <c:if test="${empty modificacionsQueEsticFentItems}">
     <%@include file="modificacionsQueEsticFentListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty modificacionsQueEsticFentItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="modificacionsQueEsticFentListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="modificacionsQueEsticFentListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="modificacionsQueEsticFentListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="modificacionsQueEsticFent" items="${modificacionsQueEsticFentItems}">

        <tr id="modificacionsQueEsticFent_rowid_${modificacionsQueEsticFent.modificacioid}">
          <%@include file="modificacionsQueEsticFentListCoreMultipleSelect.jsp" %>

          <%@include file="modificacionsQueEsticFentListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="modificacionsQueEsticFentListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
