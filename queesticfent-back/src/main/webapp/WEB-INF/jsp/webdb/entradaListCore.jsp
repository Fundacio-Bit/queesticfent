  <c:if test="${empty entradaItems}">
     <%@include file="entradaListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty entradaItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="entradaListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="entradaListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="entradaListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="entrada" items="${entradaItems}">

        <tr id="entrada_rowid_${entrada.entradaID}">
          <%@include file="entradaListCoreMultipleSelect.jsp" %>

          <%@include file="entradaListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="entradaListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
