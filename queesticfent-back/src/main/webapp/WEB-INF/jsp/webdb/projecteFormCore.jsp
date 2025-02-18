<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjecteFields" className="org.fundaciobit.queesticfent.model.fields.ProjecteFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.NOM)}">
        <tr id="projecte_nom_rowid">
          <td id="projecte_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.NOM])?'projecte.nom':__theForm.labels[ProjecteFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="projecte_nom_columnvalueid">
            <form:errors path="projecte.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjecteFields.NOM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ProjecteFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="45" path="projecte.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.DEPARTAMENTID)}">
        <tr id="projecte_departamentID_rowid">
          <td id="projecte_departamentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.DEPARTAMENTID])?'projecte.departamentID':__theForm.labels[ProjecteFields.DEPARTAMENTID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.DEPARTAMENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.DEPARTAMENTID]}" ></i>
              </c:if>
            </td>
          <td id="projecte_departamentID_columnvalueid">
          <form:errors path="projecte.departamentID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ProjecteFields.DEPARTAMENTID)}" >
          <form:hidden path="projecte.departamentID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.projecte.departamentID,__theForm.listOfDepartamentForDepartamentID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjecteFields.DEPARTAMENTID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="projecte_departamentID"  onchange="if(typeof onChangeDepartamentID == 'function') {  onChangeDepartamentID(this); };"  cssClass="form-control col-md-9-optional" path="projecte.departamentID">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.DESCRIPCIO)}">
        <tr id="projecte_descripcio_rowid">
          <td id="projecte_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.DESCRIPCIO])?'projecte.descripcio':__theForm.labels[ProjecteFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="projecte_descripcio_columnvalueid">
              <form:errors path="projecte.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ProjecteFields.DESCRIPCIO)? 'true' : 'false'}" path="projecte.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('projecte.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('projecte.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('projecte.descripcio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_descripcio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_descripcio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_descripcio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.ACTIU)}">
        <tr id="projecte_actiu_rowid">
          <td id="projecte_actiu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.ACTIU])?'projecte.actiu':__theForm.labels[ProjecteFields.ACTIU]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.ACTIU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.ACTIU]}" ></i>
              </c:if>
            </td>
          <td id="projecte_actiu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjecteFields.ACTIU)}" >
              <form:errors path="projecte.actiu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,ProjecteFields.ACTIU)? 'false' : 'true'}" path="projecte.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ProjecteFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.projecte.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.FROMDATA)}">
        <tr id="projecte_fromdata_rowid">
          <td id="projecte_fromdata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.FROMDATA])?'projecte.fromdata':__theForm.labels[ProjecteFields.FROMDATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.FROMDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.FROMDATA]}" ></i>
              </c:if>
            </td>
          <td id="projecte_fromdata_columnvalueid">
    <form:errors path="projecte.fromdata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="projecte_fromdata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjecteFields.FROMDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#projecte_fromdata" path="projecte.fromdata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjecteFields.FROMDATA)}" >
                    <div class="input-group-append"  data-target="#projecte_fromdata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#projecte_fromdata').datetimepicker({
                    format: '${gen:getJSDatePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjecteFields.TODATA)}">
        <tr id="projecte_todata_rowid">
          <td id="projecte_todata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjecteFields.TODATA])?'projecte.todata':__theForm.labels[ProjecteFields.TODATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjecteFields.TODATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjecteFields.TODATA]}" ></i>
              </c:if>
            </td>
          <td id="projecte_todata_columnvalueid">
    <form:errors path="projecte.todata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="projecte_todata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjecteFields.TODATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#projecte_todata" path="projecte.todata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjecteFields.TODATA)}" >
                    <div class="input-group-append"  data-target="#projecte_todata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#projecte_todata').datetimepicker({
                    format: '${gen:getJSDatePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
