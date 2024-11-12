      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${modificacions.modificacioid}"/>
       &nbsp;
      </td>
      </c:if>

