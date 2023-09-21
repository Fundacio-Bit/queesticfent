  <c:if test="${empty grupsusuariItems}">
     <%@include file="grupsusuariListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty grupsusuariItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="grupsusuariListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="grupsusuariListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="grupsusuariListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="grupsusuari" items="${grupsusuariItems}">

        <tr id="grupsusuari_rowid_${grupsusuari.grupsUsuariID}">
          <%@include file="grupsusuariListCoreMultipleSelect.jsp" %>

          <%@include file="grupsusuariListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="grupsusuariListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
