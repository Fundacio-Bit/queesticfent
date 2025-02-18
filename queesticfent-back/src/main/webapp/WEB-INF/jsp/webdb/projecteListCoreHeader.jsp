<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjecteFields" className="org.fundaciobit.queesticfent.model.fields.ProjecteFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.DEPARTAMENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.DEPARTAMENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.DESCRIPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.ACTIU)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.ACTIU)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.FROMDATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.FROMDATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ProjecteFields.TODATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ProjecteFields.TODATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

