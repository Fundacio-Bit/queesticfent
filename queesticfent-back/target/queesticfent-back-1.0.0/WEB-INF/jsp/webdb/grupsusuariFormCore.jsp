<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="GrupsusuariFields" className="org.fundaciobit.queesticfent.model.fields.GrupsusuariFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsusuariFields.USUARIID)}">
        <tr id="grupsusuari_usuariID_rowid">
          <td id="grupsusuari_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsusuariFields.USUARIID])?'grupsusuari.usuariID':__theForm.labels[GrupsusuariFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[GrupsusuariFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsusuariFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="grupsusuari_usuariID_columnvalueid">
          <form:errors path="grupsusuari.usuariID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.USUARIID)}" >
          <form:hidden path="grupsusuari.usuariID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.grupsusuari.usuariID,__theForm.listOfUsuarisForUsuariID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.USUARIID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="grupsusuari_usuariID"  onchange="if(typeof onChangeUsuariID == 'function') {  onChangeUsuariID(this); };"  cssClass="form-control col-md-9-optional" path="grupsusuari.usuariID">
            <c:forEach items="${__theForm.listOfUsuarisForUsuariID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsusuariFields.GRUPID)}">
        <tr id="grupsusuari_grupID_rowid">
          <td id="grupsusuari_grupID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsusuariFields.GRUPID])?'grupsusuari.grupID':__theForm.labels[GrupsusuariFields.GRUPID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[GrupsusuariFields.GRUPID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsusuariFields.GRUPID]}" ></i>
              </c:if>
            </td>
          <td id="grupsusuari_grupID_columnvalueid">
          <form:errors path="grupsusuari.grupID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.GRUPID)}" >
          <form:hidden path="grupsusuari.grupID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.grupsusuari.grupID,__theForm.listOfGrupsForGrupID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.GRUPID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="grupsusuari_grupID"  onchange="if(typeof onChangeGrupID == 'function') {  onChangeGrupID(this); };"  cssClass="form-control col-md-9-optional" path="grupsusuari.grupID">
            <c:forEach items="${__theForm.listOfGrupsForGrupID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
