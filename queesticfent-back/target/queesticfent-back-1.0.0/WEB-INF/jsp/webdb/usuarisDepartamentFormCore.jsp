<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuarisDepartamentFields" className="org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisDepartamentFields.USUARIID)}">
        <tr id="usuarisDepartament_usuariID_rowid">
          <td id="usuarisDepartament_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisDepartamentFields.USUARIID])?'usuarisDepartament.usuariID':__theForm.labels[UsuarisDepartamentFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisDepartamentFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisDepartamentFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="usuarisDepartament_usuariID_columnvalueid">
          <form:errors path="usuarisDepartament.usuariID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.USUARIID)}" >
          <form:hidden path="usuarisDepartament.usuariID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuarisDepartament.usuariID,__theForm.listOfUsuarisForUsuariID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.USUARIID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuarisDepartament_usuariID"  onchange="if(typeof onChangeUsuariID == 'function') {  onChangeUsuariID(this); };"  cssClass="form-control col-md-9-optional" path="usuarisDepartament.usuariID">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisDepartamentFields.DEPARTAMENTID)}">
        <tr id="usuarisDepartament_departamentID_rowid">
          <td id="usuarisDepartament_departamentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisDepartamentFields.DEPARTAMENTID])?'usuarisDepartament.departamentID':__theForm.labels[UsuarisDepartamentFields.DEPARTAMENTID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisDepartamentFields.DEPARTAMENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisDepartamentFields.DEPARTAMENTID]}" ></i>
              </c:if>
            </td>
          <td id="usuarisDepartament_departamentID_columnvalueid">
          <form:errors path="usuarisDepartament.departamentID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.DEPARTAMENTID)}" >
          <form:hidden path="usuarisDepartament.departamentID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuarisDepartament.departamentID,__theForm.listOfDepartamentsForDepartamentID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.DEPARTAMENTID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuarisDepartament_departamentID"  onchange="if(typeof onChangeDepartamentID == 'function') {  onChangeDepartamentID(this); };"  cssClass="form-control col-md-9-optional" path="usuarisDepartament.departamentID">
            <c:forEach items="${__theForm.listOfDepartamentsForDepartamentID}" var="tmp">
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
        
