<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuarisFields" className="org.fundaciobit.queesticfent.model.fields.UsuarisFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[usuaris.usuariID]}" />
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


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.USUARIID)}">
          <td>
          ${usuaris.usuariID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.LLINATGE1)}">
          <td>
          ${usuaris.llinatge1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.LLINATGE2)}">
          <td>
          ${usuaris.llinatge2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.NOM)}">
          <td>
          ${usuaris.nom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.CORREU)}">
          <td>
          ${usuaris.correu}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.DESCRIPCIO)}">
          <td>
          ${usuaris.descripcio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.EXTENSIO)}">
          <td>
          ${usuaris.extensio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.NAIXEMENT)}">
          <td> <fmt:formatDate pattern="${gen:getDatePattern()}" value="${usuaris.naixement}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.TELEFONCASA)}">
          <td>
          ${usuaris.telefoncasa}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.TELEFONMOBIL)}">
          <td>
          ${usuaris.telefonmobil}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.CONTRASENYA)}">
          <td>
          ${usuaris.contrasenya}
          </td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[usuaris.usuariID]}" />
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


