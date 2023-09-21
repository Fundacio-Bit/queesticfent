<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuarisDepartamentFields" className="org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisDepartamentFields.USUARIID)}">
        <tr id="usuarisDepartament_usuariId_rowid">
          <td id="usuarisDepartament_usuariId_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisDepartamentFields.USUARIID])?'usuarisDepartament.usuariId':__theForm.labels[UsuarisDepartamentFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisDepartamentFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisDepartamentFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="usuarisDepartament_usuariId_columnvalueid">
          <form:errors path="usuarisDepartament.usuariId" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.USUARIID)}" >
          <form:hidden path="usuarisDepartament.usuariId"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuarisDepartament.usuariId,__theForm.listOfUsuarisForUsuariId)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.USUARIID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuarisDepartament_usuariId"  onchange="if(typeof onChangeUsuariId == 'function') {  onChangeUsuariId(this); };"  cssClass="form-control col-md-9-optional" path="usuarisDepartament.usuariId">
            <c:forEach items="${__theForm.listOfUsuarisForUsuariId}" var="tmp">
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
        <tr id="usuarisDepartament_departamentid_rowid">
          <td id="usuarisDepartament_departamentid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisDepartamentFields.DEPARTAMENTID])?'usuarisDepartament.departamentid':__theForm.labels[UsuarisDepartamentFields.DEPARTAMENTID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisDepartamentFields.DEPARTAMENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisDepartamentFields.DEPARTAMENTID]}" ></i>
              </c:if>
            </td>
          <td id="usuarisDepartament_departamentid_columnvalueid">
          <form:errors path="usuarisDepartament.departamentid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.DEPARTAMENTID)}" >
          <form:hidden path="usuarisDepartament.departamentid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.usuarisDepartament.departamentid,__theForm.listOfDepartamentsForDepartamentid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuarisDepartamentFields.DEPARTAMENTID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="usuarisDepartament_departamentid"  onchange="if(typeof onChangeDepartamentid == 'function') {  onChangeDepartamentid(this); };"  cssClass="form-control col-md-9-optional" path="usuarisDepartament.departamentid">
            <c:forEach items="${__theForm.listOfDepartamentsForDepartamentid}" var="tmp">
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
        
