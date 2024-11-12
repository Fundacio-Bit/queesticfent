<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EntradesFields" className="org.fundaciobit.queesticfent.model.fields.EntradesFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.ENTRADAID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.ENTRADAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.PROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.PROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.QUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.QUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.DADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.DADA2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,EntradesFields.DATA)}">
        <th>${qef:getSortIcons(__theFilterForm,EntradesFields.DATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

