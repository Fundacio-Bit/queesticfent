<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.MODIFICACIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.MODIFICACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.DATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.QUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.QUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.DADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsQueEsticFentFields.DADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsQueEsticFentFields.DADA2)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

