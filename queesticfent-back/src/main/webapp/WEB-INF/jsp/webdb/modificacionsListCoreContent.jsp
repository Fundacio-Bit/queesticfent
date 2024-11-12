<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[modificacions.modificacioid]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.MODIFICACIOID)}">
          <td>
          ${modificacions.modificacioid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.ENTRADAID)}">
          <td>
          <c:set var="tmp">${modificacions.entradaid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfEntradesForEntradaid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.ACCIOID)}">
          <td>
          <c:set var="tmp">${modificacions.accioid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfAccionsForAccioid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDUSUARIID)}">
          <td>
          ${modificacions.oldusuariID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDPROJECTEID)}">
          <td>
          <c:set var="tmp">${modificacions.oldprojecteID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfProjectesForOldprojecteID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDQUEESTICFENTID)}">
          <td>
          ${modificacions.oldqueesticfentid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDADA1)}">
          <td>
          ${modificacions.olddada1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDADA2)}">
          <td>
          ${modificacions.olddada2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDATA)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${modificacions.olddata}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWUSUARIID)}">
          <td>
          ${modificacions.newusuariID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWPROJECTEID)}">
          <td>
          <c:set var="tmp">${modificacions.newprojecteID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfProjectesForNewprojecteID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWQUEESTICFENTID)}">
          <td>
          ${modificacions.newqueesticfentid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDADA1)}">
          <td>
          ${modificacions.newdada1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDADA2)}">
          <td>
          ${modificacions.newdada2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDATA)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${modificacions.newdata}" /></td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[modificacions.modificacioid]}" />
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


