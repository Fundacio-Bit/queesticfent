<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="FitxerFields" className="org.fundaciobit.queesticfent.model.fields.FitxerFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,FitxerFields.FITXERID)}">
        <th>${qef:getSortIcons(__theFilterForm,FitxerFields.FITXERID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,FitxerFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,FitxerFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,FitxerFields.MIME)}">
        <th>${qef:getSortIcons(__theFilterForm,FitxerFields.MIME)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,FitxerFields.TAMANY)}">
        <th>${qef:getSortIcons(__theFilterForm,FitxerFields.TAMANY)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,FitxerFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,FitxerFields.DESCRIPCIO)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

