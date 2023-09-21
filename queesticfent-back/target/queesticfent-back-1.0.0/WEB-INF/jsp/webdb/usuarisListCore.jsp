  <c:if test="${empty usuarisItems}">
     <%@include file="usuarisListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty usuarisItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="usuarisListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="usuarisListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="usuarisListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="usuaris" items="${usuarisItems}">

        <tr id="usuaris_rowid_${usuaris.usuariId}">
          <%@include file="usuarisListCoreMultipleSelect.jsp" %>

          <%@include file="usuarisListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="usuarisListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
