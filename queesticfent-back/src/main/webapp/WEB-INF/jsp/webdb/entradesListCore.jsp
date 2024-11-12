  <c:if test="${empty entradesItems}">
     <%@include file="entradesListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty entradesItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="entradesListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="entradesListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="entradesListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="entrades" items="${entradesItems}">

        <tr id="entrades_rowid_${entrades.entradaID}">
          <%@include file="entradesListCoreMultipleSelect.jsp" %>

          <%@include file="entradesListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="entradesListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
