<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="DepartamentFields" className="org.fundaciobit.queesticfent.model.fields.DepartamentFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentFields.DEPARTAMENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentFields.DEPARTAMENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentFields.COORDINADORID)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentFields.COORDINADORID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentFields.NOMLDAP)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentFields.NOMLDAP)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,DepartamentFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,DepartamentFields.DESCRIPCIO)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

