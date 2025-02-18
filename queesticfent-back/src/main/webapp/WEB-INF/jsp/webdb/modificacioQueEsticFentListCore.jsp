  <c:if test="${empty modificacioQueEsticFentItems}">
     <%@include file="modificacioQueEsticFentListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty modificacioQueEsticFentItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="modificacioQueEsticFentListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="modificacioQueEsticFentListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="modificacioQueEsticFentListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="modificacioQueEsticFent" items="${modificacioQueEsticFentItems}">

        <tr id="modificacioQueEsticFent_rowid_${modificacioQueEsticFent.modificacioID}">
          <%@include file="modificacioQueEsticFentListCoreMultipleSelect.jsp" %>

          <%@include file="modificacioQueEsticFentListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="modificacioQueEsticFentListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
