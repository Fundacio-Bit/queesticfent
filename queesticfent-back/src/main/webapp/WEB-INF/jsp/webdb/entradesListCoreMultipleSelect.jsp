      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${entrades.entradaID}"/>
       &nbsp;
      </td>
      </c:if>

