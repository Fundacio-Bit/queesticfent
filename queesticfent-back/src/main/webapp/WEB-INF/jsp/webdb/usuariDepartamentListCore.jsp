  <c:if test="${empty usuariDepartamentItems}">
     <%@include file="usuariDepartamentListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty usuariDepartamentItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="usuariDepartamentListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="usuariDepartamentListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="usuariDepartamentListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="usuariDepartament" items="${usuariDepartamentItems}">

        <tr id="usuariDepartament_rowid_${usuariDepartament.usuaridepartamentID}">
          <%@include file="usuariDepartamentListCoreMultipleSelect.jsp" %>

          <%@include file="usuariDepartamentListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="usuariDepartamentListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
