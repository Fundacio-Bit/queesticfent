      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${modificacionsQueEsticFent.modificacioID}"/>
       &nbsp;
      </td>
      </c:if>

