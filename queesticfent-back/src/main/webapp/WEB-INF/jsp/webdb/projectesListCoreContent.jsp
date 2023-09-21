<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjectesFields" className="org.fundaciobit.queesticfent.model.fields.ProjectesFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[projectes.projecteId]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.PROJECTEID)}">
          <td>
          ${projectes.projecteId}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.NOM)}">
          <td>
          ${projectes.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.DEPARTAMENTID)}">
          <td>
          <c:set var="tmp">${projectes.departamentid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfDepartamentsForDepartamentid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.DESCRIPCIO)}">
          <td>
          ${projectes.descripcio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.ACTIU)}">
          <td>
            <img height="18" width="18" src="<c:url value="/img/icn_alert_${projectes.actiu?'success':'error'}.png"/>">
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.FROMDATA)}">
          <td> <fmt:formatDate pattern="${gen:getDatePattern()}" value="${projectes.fromdata}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.TODATA)}">
          <td> <fmt:formatDate pattern="${gen:getDatePattern()}" value="${projectes.todata}" /></td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[projectes.projecteId]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


