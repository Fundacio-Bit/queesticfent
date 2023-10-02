  <c:if test="${empty usuarisDepartamentItems}">
     <%@include file="usuarisDepartamentListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty usuarisDepartamentItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="usuarisDepartamentListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="usuarisDepartamentListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="usuarisDepartamentListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="usuarisDepartament" items="${usuarisDepartamentItems}">

        <tr id="usuarisDepartament_rowid_${usuarisDepartament.usuariDepartamentID}">
          <%@include file="usuarisDepartamentListCoreMultipleSelect.jsp" %>

          <%@include file="usuarisDepartamentListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="usuarisDepartamentListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
