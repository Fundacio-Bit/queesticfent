<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacioQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacioQueEsticFentFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.MODIFICACIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.MODIFICACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.QUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.QUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.DADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.DADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.DADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.DADA2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacioQueEsticFentFields.DATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacioQueEsticFentFields.DATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

