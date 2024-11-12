<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.ENTRADAID)}">
        <tr id="modificacions_entradaid_rowid">
          <td id="modificacions_entradaid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.ENTRADAID])?'modificacions.entradaid':__theForm.labels[ModificacionsFields.ENTRADAID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.ENTRADAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.ENTRADAID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_entradaid_columnvalueid">
          <form:errors path="modificacions.entradaid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.ENTRADAID)}" >
          <form:hidden path="modificacions.entradaid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacions.entradaid,__theForm.listOfEntradesForEntradaid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.ENTRADAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacions_entradaid"  onchange="if(typeof onChangeEntradaid == 'function') {  onChangeEntradaid(this); };"  cssClass="form-control col-md-9-optional" path="modificacions.entradaid">
            <c:forEach items="${__theForm.listOfEntradesForEntradaid}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.ACCIOID)}">
        <tr id="modificacions_accioid_rowid">
          <td id="modificacions_accioid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.ACCIOID])?'modificacions.accioid':__theForm.labels[ModificacionsFields.ACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.ACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.ACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_accioid_columnvalueid">
          <form:errors path="modificacions.accioid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.ACCIOID)}" >
          <form:hidden path="modificacions.accioid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacions.accioid,__theForm.listOfAccionsForAccioid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.ACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacions_accioid"  onchange="if(typeof onChangeAccioid == 'function') {  onChangeAccioid(this); };"  cssClass="form-control col-md-9-optional" path="modificacions.accioid">
            <c:forEach items="${__theForm.listOfAccionsForAccioid}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDUSUARIID)}">
        <tr id="modificacions_oldusuariID_rowid">
          <td id="modificacions_oldusuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDUSUARIID])?'modificacions.oldusuariID':__theForm.labels[ModificacionsFields.OLDUSUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDUSUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDUSUARIID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_oldusuariID_columnvalueid">
            <form:errors path="modificacions.oldusuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDUSUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDUSUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="modificacions.oldusuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDPROJECTEID)}">
        <tr id="modificacions_oldprojecteID_rowid">
          <td id="modificacions_oldprojecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDPROJECTEID])?'modificacions.oldprojecteID':__theForm.labels[ModificacionsFields.OLDPROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDPROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDPROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_oldprojecteID_columnvalueid">
          <form:errors path="modificacions.oldprojecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDPROJECTEID)}" >
          <form:hidden path="modificacions.oldprojecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacions.oldprojecteID,__theForm.listOfProjectesForOldprojecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDPROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacions_oldprojecteID"  onchange="if(typeof onChangeOldprojecteID == 'function') {  onChangeOldprojecteID(this); };"  cssClass="form-control col-md-9-optional" path="modificacions.oldprojecteID">
            <c:forEach items="${__theForm.listOfProjectesForOldprojecteID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.modificacions.oldprojecteID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.modificacions.oldprojecteID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDQUEESTICFENTID)}">
        <tr id="modificacions_oldqueesticfentid_rowid">
          <td id="modificacions_oldqueesticfentid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDQUEESTICFENTID])?'modificacions.oldqueesticfentid':__theForm.labels[ModificacionsFields.OLDQUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDQUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDQUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_oldqueesticfentid_columnvalueid">
            <form:errors path="modificacions.oldqueesticfentid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDQUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDQUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="modificacions.oldqueesticfentid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDDADA1)}">
        <tr id="modificacions_olddada1_rowid">
          <td id="modificacions_olddada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDDADA1])?'modificacions.olddada1':__theForm.labels[ModificacionsFields.OLDDADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDDADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDDADA1]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_olddada1_columnvalueid">
              <form:errors path="modificacions.olddada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDDADA1)? 'true' : 'false'}" path="modificacions.olddada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_olddada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_olddada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada1'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_olddada1').on('click', function(){
					var valor = ($('#dropdownMenuContainer_olddada1').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_olddada1').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDDADA2)}">
        <tr id="modificacions_olddada2_rowid">
          <td id="modificacions_olddada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDDADA2])?'modificacions.olddada2':__theForm.labels[ModificacionsFields.OLDDADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDDADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDDADA2]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_olddada2_columnvalueid">
              <form:errors path="modificacions.olddada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDDADA2)? 'true' : 'false'}" path="modificacions.olddada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_olddada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_olddada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.olddada2'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_olddada2').on('click', function(){
					var valor = ($('#dropdownMenuContainer_olddada2').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_olddada2').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.OLDDATA)}">
        <tr id="modificacions_olddata_rowid">
          <td id="modificacions_olddata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.OLDDATA])?'modificacions.olddata':__theForm.labels[ModificacionsFields.OLDDATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.OLDDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.OLDDATA]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_olddata_columnvalueid">
    <form:errors path="modificacions.olddata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="modificacions_olddata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#modificacions_olddata" path="modificacions.olddata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.OLDDATA)}" >
                    <div class="input-group-append"  data-target="#modificacions_olddata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#modificacions_olddata').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWUSUARIID)}">
        <tr id="modificacions_newusuariID_rowid">
          <td id="modificacions_newusuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWUSUARIID])?'modificacions.newusuariID':__theForm.labels[ModificacionsFields.NEWUSUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWUSUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWUSUARIID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newusuariID_columnvalueid">
            <form:errors path="modificacions.newusuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWUSUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWUSUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="modificacions.newusuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWPROJECTEID)}">
        <tr id="modificacions_newprojecteID_rowid">
          <td id="modificacions_newprojecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWPROJECTEID])?'modificacions.newprojecteID':__theForm.labels[ModificacionsFields.NEWPROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWPROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWPROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newprojecteID_columnvalueid">
          <form:errors path="modificacions.newprojecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWPROJECTEID)}" >
          <form:hidden path="modificacions.newprojecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacions.newprojecteID,__theForm.listOfProjectesForNewprojecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWPROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacions_newprojecteID"  onchange="if(typeof onChangeNewprojecteID == 'function') {  onChangeNewprojecteID(this); };"  cssClass="form-control col-md-9-optional" path="modificacions.newprojecteID">
            <c:forEach items="${__theForm.listOfProjectesForNewprojecteID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.modificacions.newprojecteID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.modificacions.newprojecteID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWQUEESTICFENTID)}">
        <tr id="modificacions_newqueesticfentid_rowid">
          <td id="modificacions_newqueesticfentid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWQUEESTICFENTID])?'modificacions.newqueesticfentid':__theForm.labels[ModificacionsFields.NEWQUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWQUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWQUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newqueesticfentid_columnvalueid">
            <form:errors path="modificacions.newqueesticfentid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWQUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWQUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="modificacions.newqueesticfentid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWDADA1)}">
        <tr id="modificacions_newdada1_rowid">
          <td id="modificacions_newdada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWDADA1])?'modificacions.newdada1':__theForm.labels[ModificacionsFields.NEWDADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWDADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWDADA1]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newdada1_columnvalueid">
              <form:errors path="modificacions.newdada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWDADA1)? 'true' : 'false'}" path="modificacions.newdada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_newdada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_newdada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada1'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_newdada1').on('click', function(){
					var valor = ($('#dropdownMenuContainer_newdada1').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_newdada1').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWDADA2)}">
        <tr id="modificacions_newdada2_rowid">
          <td id="modificacions_newdada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWDADA2])?'modificacions.newdada2':__theForm.labels[ModificacionsFields.NEWDADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWDADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWDADA2]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newdada2_columnvalueid">
              <form:errors path="modificacions.newdada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWDADA2)? 'true' : 'false'}" path="modificacions.newdada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_newdada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_newdada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacions.newdada2'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_newdada2').on('click', function(){
					var valor = ($('#dropdownMenuContainer_newdada2').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_newdada2').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsFields.NEWDATA)}">
        <tr id="modificacions_newdata_rowid">
          <td id="modificacions_newdata_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsFields.NEWDATA])?'modificacions.newdata':__theForm.labels[ModificacionsFields.NEWDATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsFields.NEWDATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsFields.NEWDATA]}" ></i>
              </c:if>
            </td>
          <td id="modificacions_newdata_columnvalueid">
    <form:errors path="modificacions.newdata" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="modificacions_newdata" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWDATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#modificacions_newdata" path="modificacions.newdata" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsFields.NEWDATA)}" >
                    <div class="input-group-append"  data-target="#modificacions_newdata"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#modificacions_newdata').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
