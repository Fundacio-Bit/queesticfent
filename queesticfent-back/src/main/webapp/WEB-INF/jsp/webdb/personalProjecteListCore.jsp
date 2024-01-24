  <c:if test="${empty personalProjecteItems}">
     <%@include file="personalProjecteListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty personalProjecteItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp table-genapp-list" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="personalProjecteListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="personalProjecteListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="personalProjecteListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="personalProjecte" items="${personalProjecteItems}">

        <tr id="personalProjecte_rowid_${personalProjecte.personalProjecteID}">
          <%@include file="personalProjecteListCoreMultipleSelect.jsp" %>

          <%@include file="personalProjecteListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="personalProjecteListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
