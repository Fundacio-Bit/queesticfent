<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjectesFields" className="org.fundaciobit.queesticfent.model.fields.ProjectesFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.DEPARTAMENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.DEPARTAMENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.DESCRIPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.ACTIU)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.ACTIU)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.FROMDATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.FROMDATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjectesFields.TODATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjectesFields.TODATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

