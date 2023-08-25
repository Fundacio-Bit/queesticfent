<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuarisFields" className="org.fundaciobit.queesticfent.model.fields.UsuarisFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.LLINATGE1)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.LLINATGE1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.LLINATGE2)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.LLINATGE2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.CORREU)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.CORREU)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.DESCRIPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.EXTENSIO)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.EXTENSIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.NAIXEMENT)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.NAIXEMENT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.TELEFONCASA)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.TELEFONCASA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.TELEFONMOBIL)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.TELEFONMOBIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuarisFields.CONTRASENYA)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuarisFields.CONTRASENYA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

