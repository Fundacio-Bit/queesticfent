      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${personalProjecte.personalProjecteID}"/>
       &nbsp;
      </td>
      </c:if>

