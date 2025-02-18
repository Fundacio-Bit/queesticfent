<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EntradaFields" className="org.fundaciobit.queesticfent.model.fields.EntradaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.ENTRADAID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.ENTRADAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.DADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.DADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.QUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.QUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.DADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.DADA2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradaFields.DATA)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradaFields.DATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

