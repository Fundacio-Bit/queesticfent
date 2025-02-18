<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariFields" className="org.fundaciobit.queesticfent.model.fields.UsuariFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.USUARIID)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.USUARIID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.NOM)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.NOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.LLINATGE1)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.LLINATGE1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.LLINATGE2)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.LLINATGE2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.CORREU)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.CORREU)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.DESCRIPCIO)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.DESCRIPCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.EXTENSIO)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.EXTENSIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.NAIXEMENT)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.NAIXEMENT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.TELEFONCASA)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.TELEFONCASA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.TELEFONMOBIL)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.TELEFONMOBIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,UsuariFields.CONTRASENYA)}">
        <th>${qef:getSortIcons(__theFilterForm,UsuariFields.CONTRASENYA)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${qef:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

