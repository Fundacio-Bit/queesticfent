<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariDepartamentFields" className="org.fundaciobit.queesticfent.model.fields.UsuariDepartamentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariDepartamentFields.USUARIID)}">
        <tr id="usuariDepartament_usuariID_rowid">
          <td id="usuariDepartament_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariDepartamentFields.USUARIID])?'usuariDepartament.usuariID':__theForm.labels[UsuariDepartamentFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariDepartamentFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariDepartamentFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="usuariDepartament_usuariID_columnvalueid">
          <form:errors path="usuariDepartament.usuariID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariDepartamentFields.USUARIID)}" >
          <form:hidden path="usuariDepartament.usuariID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuariDepartament.usuariID,__theForm.listOfUsuariForUsuariID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariDepartamentFields.USUARIID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuariDepartament_usuariID"  onchange="if(typeof onChangeUsuariID == 'function') {  onChangeUsuariID(this); };"  cssClass="form-control col-md-9-optional" path="usuariDepartament.usuariID">
            <c:forEach items="${__theForm.listOfUsuariForUsuariID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariDepartamentFields.DEPARTAMENTID)}">
        <tr id="usuariDepartament_departamentID_rowid">
          <td id="usuariDepartament_departamentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariDepartamentFields.DEPARTAMENTID])?'usuariDepartament.departamentID':__theForm.labels[UsuariDepartamentFields.DEPARTAMENTID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariDepartamentFields.DEPARTAMENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariDepartamentFields.DEPARTAMENTID]}" ></i>
              </c:if>
            </td>
          <td id="usuariDepartament_departamentID_columnvalueid">
          <form:errors path="usuariDepartament.departamentID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuariDepartamentFields.DEPARTAMENTID)}" >
          <form:hidden path="usuariDepartament.departamentID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuariDepartament.departamentID,__theForm.listOfDepartamentForDepartamentID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariDepartamentFields.DEPARTAMENTID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuariDepartament_departamentID"  onchange="if(typeof onChangeDepartamentID == 'function') {  onChangeDepartamentID(this); };"  cssClass="form-control col-md-9-optional" path="usuariDepartament.departamentID">
            <c:forEach items="${__theForm.listOfDepartamentForDepartamentID}" var="tmp">
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
        
