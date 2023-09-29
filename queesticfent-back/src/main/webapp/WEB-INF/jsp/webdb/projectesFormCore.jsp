<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjectesFields" className="org.fundaciobit.queesticfent.model.fields.ProjectesFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.NOM)}">
        <tr id="projectes_nom_rowid">
          <td id="projectes_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.NOM])?'projectes.nom':__theForm.labels[ProjectesFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="projectes_nom_columnvalueid">
            <form:errors path="projectes.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjectesFields.NOM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ProjectesFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="45" path="projectes.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.DEPARTAMENTID)}">
        <tr id="projectes_departamentID_rowid">
          <td id="projectes_departamentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.DEPARTAMENTID])?'projectes.departamentID':__theForm.labels[ProjectesFields.DEPARTAMENTID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.DEPARTAMENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.DEPARTAMENTID]}" ></i>
              </c:if>
            </td>
          <td id="projectes_departamentID_columnvalueid">
          <form:errors path="projectes.departamentID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ProjectesFields.DEPARTAMENTID)}" >
          <form:hidden path="projectes.departamentID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.projectes.departamentID,__theForm.listOfDepartamentsForDepartamentID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjectesFields.DEPARTAMENTID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="projectes_departamentID"  onchange="if(typeof onChangeDepartamentID == 'function') {  onChangeDepartamentID(this); };"  cssClass="form-control col-md-9-optional" path="projectes.departamentID">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.DESCRIPCIO)}">
        <tr id="projectes_descripcio_rowid">
          <td id="projectes_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.DESCRIPCIO])?'projectes.descripcio':__theForm.labels[ProjectesFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="projectes_descripcio_columnvalueid">
              <form:errors path="projectes.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ProjectesFields.DESCRIPCIO)? 'true' : 'false'}" path="projectes.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('projectes.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('projectes.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('projectes.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.ACTIU)}">
        <tr id="projectes_actiu_rowid">
          <td id="projectes_actiu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.ACTIU])?'projectes.actiu':__theForm.labels[ProjectesFields.ACTIU]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.ACTIU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.ACTIU]}" ></i>
              </c:if>
            </td>
          <td id="projectes_actiu_columnvalueid">
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjectesFields.ACTIU)}" >
              <form:errors path="projectes.actiu" cssClass="errorField alert alert-danger" />
              <form:checkbox cssClass="" onclick="javascript:return ${ gen:contains(__theForm.readOnlyFields ,ProjectesFields.ACTIU)? 'false' : 'true'}" path="projectes.actiu" />
          </c:if>
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ProjectesFields.ACTIU)}" >
                <fmt:message key="genapp.checkbox.${__theForm.projectes.actiu}" />
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.FROMDATA)}">
        <tr id="projectes_fromdata_rowid">
          <td id="projectes_fromdata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.FROMDATA])?'projectes.fromdata':__theForm.labels[ProjectesFields.FROMDATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.FROMDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.FROMDATA]}" ></i>
              </c:if>
            </td>
          <td id="projectes_fromdata_columnvalueid">
    <form:errors path="projectes.fromdata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="projectes_fromdata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjectesFields.FROMDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#projectes_fromdata" path="projectes.fromdata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjectesFields.FROMDATA)}" >
                    <div class="input-group-append"  data-target="#projectes_fromdata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#projectes_fromdata').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ProjectesFields.TODATA)}">
        <tr id="projectes_todata_rowid">
          <td id="projectes_todata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ProjectesFields.TODATA])?'projectes.todata':__theForm.labels[ProjectesFields.TODATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[ProjectesFields.TODATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ProjectesFields.TODATA]}" ></i>
              </c:if>
            </td>
          <td id="projectes_todata_columnvalueid">
    <form:errors path="projectes.todata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="projectes_todata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ProjectesFields.TODATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#projectes_todata" path="projectes.todata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ProjectesFields.TODATA)}" >
                    <div class="input-group-append"  data-target="#projectes_todata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#projectes_todata').datetimepicker({
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
        
