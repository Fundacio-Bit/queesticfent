<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AccioFields" className="org.fundaciobit.queesticfent.model.fields.AccioFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AccioFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,AccioFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AccioFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,AccioFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AccioFields.NOMLLEGENDA)}">
        <th>${qef:getSortIcons(__theFilterForm,AccioFields.NOMLLEGENDA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AccioFields.COLOR)}">
        <th>${qef:getSortIcons(__theFilterForm,AccioFields.COLOR)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,AccioFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,AccioFields.DESCRIPCIO)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

