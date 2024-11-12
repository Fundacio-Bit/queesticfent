<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EntradesFields" className="org.fundaciobit.queesticfent.model.fields.EntradesFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[entrades.entradaID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.ENTRADAID)}">
          <td>
          ${entrades.entradaID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.ACCIOID)}">
          <td>
          <c:set var="tmp">${entrades.accioid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfAccionsForAccioid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.USUARIID)}">
          <td>
          ${entrades.usuariid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.PROJECTEID)}">
          <td>
          <c:set var="tmp">${entrades.projecteid}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfProjectesForProjecteid[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.QUEESTICFENTID)}">
          <td>
          ${entrades.queesticfentid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DADA1)}">
          <td>
          ${entrades.dada1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DADA2)}">
          <td>
          ${entrades.dada2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DATA)}">
          <td> <fmt:formatDate pattern="${gen:getTimePattern()}" value="${entrades.data}" /></td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[entrades.entradaID]}" />
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


