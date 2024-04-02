<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.ACCIOID)}">
        <tr id="modificacionsQueEsticFent_accioID_rowid">
          <td id="modificacionsQueEsticFent_accioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.ACCIOID])?'modificacionsQueEsticFent.accioID':__theForm.labels[ModificacionsQueEsticFentFields.ACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.ACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.ACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_accioID_columnvalueid">
          <form:errors path="modificacionsQueEsticFent.accioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.ACCIOID)}" >
          <form:hidden path="modificacionsQueEsticFent.accioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacionsQueEsticFent.accioID,__theForm.listOfAccionsForAccioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.ACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacionsQueEsticFent_accioID"  onchange="if(typeof onChangeAccioID == 'function') {  onChangeAccioID(this); };"  cssClass="form-control col-md-9-optional" path="modificacionsQueEsticFent.accioID">
            <c:forEach items="${__theForm.listOfAccionsForAccioID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.USUARIID)}">
        <tr id="modificacionsQueEsticFent_usuariID_rowid">
          <td id="modificacionsQueEsticFent_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.USUARIID])?'modificacionsQueEsticFent.usuariID':__theForm.labels[ModificacionsQueEsticFentFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_usuariID_columnvalueid">
            <form:errors path="modificacionsQueEsticFent.usuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.USUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="modificacionsQueEsticFent.usuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.PROJECTEID)}">
        <tr id="modificacionsQueEsticFent_projecteID_rowid">
          <td id="modificacionsQueEsticFent_projecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.PROJECTEID])?'modificacionsQueEsticFent.projecteID':__theForm.labels[ModificacionsQueEsticFentFields.PROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.PROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.PROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_projecteID_columnvalueid">
          <form:errors path="modificacionsQueEsticFent.projecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.PROJECTEID)}" >
          <form:hidden path="modificacionsQueEsticFent.projecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacionsQueEsticFent.projecteID,__theForm.listOfProjectesForProjecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.PROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacionsQueEsticFent_projecteID"  onchange="if(typeof onChangeProjecteID == 'function') {  onChangeProjecteID(this); };"  cssClass="form-control col-md-9-optional" path="modificacionsQueEsticFent.projecteID">
            <c:forEach items="${__theForm.listOfProjectesForProjecteID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.modificacionsQueEsticFent.projecteID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.modificacionsQueEsticFent.projecteID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.DATA)}">
        <tr id="modificacionsQueEsticFent_data_rowid">
          <td id="modificacionsQueEsticFent_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.DATA])?'modificacionsQueEsticFent.data':__theForm.labels[ModificacionsQueEsticFentFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_data_columnvalueid">
    <form:errors path="modificacionsQueEsticFent.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="modificacionsQueEsticFent_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#modificacionsQueEsticFent_data" path="modificacionsQueEsticFent.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.DATA)}" >
                    <div class="input-group-append"  data-target="#modificacionsQueEsticFent_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#modificacionsQueEsticFent_data').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.QUEESTICFENTID)}">
        <tr id="modificacionsQueEsticFent_queEsticFentID_rowid">
          <td id="modificacionsQueEsticFent_queEsticFentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.QUEESTICFENTID])?'modificacionsQueEsticFent.queEsticFentID':__theForm.labels[ModificacionsQueEsticFentFields.QUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.QUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.QUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_queEsticFentID_columnvalueid">
            <form:errors path="modificacionsQueEsticFent.queEsticFentID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.QUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.QUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="modificacionsQueEsticFent.queEsticFentID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.DADA1)}">
        <tr id="modificacionsQueEsticFent_dada1_rowid">
          <td id="modificacionsQueEsticFent_dada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.DADA1])?'modificacionsQueEsticFent.dada1':__theForm.labels[ModificacionsQueEsticFentFields.DADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.DADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.DADA1]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_dada1_columnvalueid">
              <form:errors path="modificacionsQueEsticFent.dada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.DADA1)? 'true' : 'false'}" path="modificacionsQueEsticFent.dada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada1'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_dada1').on('click', function(){
					var valor = ($('#dropdownMenuContainer_dada1').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_dada1').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacionsQueEsticFentFields.DADA2)}">
        <tr id="modificacionsQueEsticFent_dada2_rowid">
          <td id="modificacionsQueEsticFent_dada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacionsQueEsticFentFields.DADA2])?'modificacionsQueEsticFent.dada2':__theForm.labels[ModificacionsQueEsticFentFields.DADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacionsQueEsticFentFields.DADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacionsQueEsticFentFields.DADA2]}" ></i>
              </c:if>
            </td>
          <td id="modificacionsQueEsticFent_dada2_columnvalueid">
              <form:errors path="modificacionsQueEsticFent.dada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacionsQueEsticFentFields.DADA2)? 'true' : 'false'}" path="modificacionsQueEsticFent.dada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacionsQueEsticFent.dada2'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_dada2').on('click', function(){
					var valor = ($('#dropdownMenuContainer_dada2').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_dada2').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
