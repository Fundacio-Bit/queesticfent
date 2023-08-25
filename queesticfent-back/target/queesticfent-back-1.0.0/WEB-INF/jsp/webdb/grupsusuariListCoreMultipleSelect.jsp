      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${grupsusuari.grupsusuariid}"/>
       &nbsp;
      </td>
      </c:if>

