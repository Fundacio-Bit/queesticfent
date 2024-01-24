<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[modificacionsQueEsticFent.modificacioID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.MODIFICACIOID)}">
          <td>
          ${modificacionsQueEsticFent.modificacioID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.ACCIOID)}">
          <td>
          <c:set var="tmp">${modificacionsQueEsticFent.accioID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfAccionsForAccioID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.USUARIID)}">
          <td>
          ${modificacionsQueEsticFent.usuariID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.PROJECTEID)}">
          <td>
          <c:set var="tmp">${modificacionsQueEsticFent.projecteID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfProjectesForProjecteID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DATA)}">
          <td> <fmt:formatDate pattern="${gen:getDatePattern()}" value="${modificacionsQueEsticFent.data}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.QUEESTICFENTID)}">
          <td>
          ${modificacionsQueEsticFent.queEsticFentID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DADA1)}">
          <td>
          ${modificacionsQueEsticFent.dada1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DADA2)}">
          <td>
          ${modificacionsQueEsticFent.dada2}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[modificacionsQueEsticFent.modificacioID]}" />
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


