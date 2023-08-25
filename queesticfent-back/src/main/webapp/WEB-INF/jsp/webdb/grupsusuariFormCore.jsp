<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="GrupsusuariFields" className="org.fundaciobit.queesticfent.model.fields.GrupsusuariFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsusuariFields.USUARIID)}">
        <tr id="grupsusuari_usuariid_rowid">
          <td id="grupsusuari_usuariid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsusuariFields.USUARIID])?'grupsusuari.usuariid':__theForm.labels[GrupsusuariFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[GrupsusuariFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsusuariFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="grupsusuari_usuariid_columnvalueid">
          <form:errors path="grupsusuari.usuariid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.USUARIID)}" >
          <form:hidden path="grupsusuari.usuariid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.grupsusuari.usuariid,__theForm.listOfUsuarisForUsuariid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.USUARIID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="grupsusuari_usuariid"  onchange="if(typeof onChangeUsuariid == 'function') {  onChangeUsuariid(this); };"  cssClass="form-control col-md-9-optional" path="grupsusuari.usuariid">
            <c:forEach items="${__theForm.listOfUsuarisForUsuariid}" var="tmp">
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
        <tr id="grupsusuari_grupid_rowid">
          <td id="grupsusuari_grupid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsusuariFields.GRUPID])?'grupsusuari.grupid':__theForm.labels[GrupsusuariFields.GRUPID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[GrupsusuariFields.GRUPID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsusuariFields.GRUPID]}" ></i>
              </c:if>
            </td>
          <td id="grupsusuari_grupid_columnvalueid">
          <form:errors path="grupsusuari.grupid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.GRUPID)}" >
          <form:hidden path="grupsusuari.grupid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.grupsusuari.grupid,__theForm.listOfGrupsForGrupid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,GrupsusuariFields.GRUPID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="grupsusuari_grupid"  onchange="if(typeof onChangeGrupid == 'function') {  onChangeGrupid(this); };"  cssClass="form-control col-md-9-optional" path="grupsusuari.grupid">
            <c:forEach items="${__theForm.listOfGrupsForGrupid}" var="tmp">
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
        
