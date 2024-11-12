<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.MODIFICACIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.MODIFICACIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.ENTRADAID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.ENTRADAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.ACCIOID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.ACCIOID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDUSUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDUSUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDPROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDPROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDQUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDQUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDDADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDDADA2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.OLDDATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.OLDDATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWUSUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWUSUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWPROJECTEID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWPROJECTEID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWQUEESTICFENTID)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWQUEESTICFENTID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDADA1)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWDADA1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDADA2)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWDADA2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,ModificacionsFields.NEWDATA)}">
        <th>${qef:getSortIcons(__theFilterForm,ModificacionsFields.NEWDATA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

