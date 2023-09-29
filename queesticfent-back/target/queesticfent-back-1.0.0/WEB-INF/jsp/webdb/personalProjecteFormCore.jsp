<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PersonalProjecteFields" className="org.fundaciobit.queesticfent.model.fields.PersonalProjecteFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,PersonalProjecteFields.USUARIID)}">
        <tr id="personalProjecte_usuariID_rowid">
          <td id="personalProjecte_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PersonalProjecteFields.USUARIID])?'personalProjecte.usuariID':__theForm.labels[PersonalProjecteFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PersonalProjecteFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PersonalProjecteFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="personalProjecte_usuariID_columnvalueid">
            <form:errors path="personalProjecte.usuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.USUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="50" path="personalProjecte.usuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PersonalProjecteFields.PROJECTEID)}">
        <tr id="personalProjecte_projecteID_rowid">
          <td id="personalProjecte_projecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PersonalProjecteFields.PROJECTEID])?'personalProjecte.projecteID':__theForm.labels[PersonalProjecteFields.PROJECTEID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PersonalProjecteFields.PROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PersonalProjecteFields.PROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="personalProjecte_projecteID_columnvalueid">
          <form:errors path="personalProjecte.projecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.PROJECTEID)}" >
          <form:hidden path="personalProjecte.projecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.personalProjecte.projecteID,__theForm.listOfProjectesForProjecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.PROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="personalProjecte_projecteID"  onchange="if(typeof onChangeProjecteID == 'function') {  onChangeProjecteID(this); };"  cssClass="form-control col-md-9-optional" path="personalProjecte.projecteID">
            <c:forEach items="${__theForm.listOfProjectesForProjecteID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PersonalProjecteFields.ORDRE)}">
        <tr id="personalProjecte_ordre_rowid">
          <td id="personalProjecte_ordre_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PersonalProjecteFields.ORDRE])?'personalProjecte.ordre':__theForm.labels[PersonalProjecteFields.ORDRE]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[PersonalProjecteFields.ORDRE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PersonalProjecteFields.ORDRE]}" ></i>
              </c:if>
            </td>
          <td id="personalProjecte_ordre_columnvalueid">
            <form:errors path="personalProjecte.ordre" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.ORDRE)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.ORDRE)? ' uneditable-input' : ''}"  style=""  path="personalProjecte.ordre"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,PersonalProjecteFields.PERCENT)}">
        <tr id="personalProjecte_percent_rowid">
          <td id="personalProjecte_percent_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[PersonalProjecteFields.PERCENT])?'personalProjecte.percent':__theForm.labels[PersonalProjecteFields.PERCENT]}" />
             </label>
              <c:if test="${not empty __theForm.help[PersonalProjecteFields.PERCENT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[PersonalProjecteFields.PERCENT]}" ></i>
              </c:if>
            </td>
          <td id="personalProjecte_percent_columnvalueid">
            <form:errors path="personalProjecte.percent" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.PERCENT)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,PersonalProjecteFields.PERCENT)? ' uneditable-input' : ''}"  style=""  path="personalProjecte.percent"   />

           </td>
        </tr>
        </c:if>
        
