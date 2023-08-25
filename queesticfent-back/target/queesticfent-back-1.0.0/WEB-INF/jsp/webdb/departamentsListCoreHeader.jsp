<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="DepartamentsFields" className="org.fundaciobit.queesticfent.model.fields.DepartamentsFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentsFields.DEPARTAMENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentsFields.DEPARTAMENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentsFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentsFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentsFields.COORDINADORID)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentsFields.COORDINADORID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentsFields.NOMLDAP)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentsFields.NOMLDAP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentsFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentsFields.DESCRIPCIO)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

