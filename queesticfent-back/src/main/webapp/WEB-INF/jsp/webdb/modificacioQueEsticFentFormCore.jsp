<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacioQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacioQueEsticFentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.ACCIOID)}">
        <tr id="modificacioQueEsticFent_accioID_rowid">
          <td id="modificacioQueEsticFent_accioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.ACCIOID])?'modificacioQueEsticFent.accioID':__theForm.labels[ModificacioQueEsticFentFields.ACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.ACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.ACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_accioID_columnvalueid">
          <form:errors path="modificacioQueEsticFent.accioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.ACCIOID)}" >
          <form:hidden path="modificacioQueEsticFent.accioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacioQueEsticFent.accioID,__theForm.listOfAccioForAccioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.ACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacioQueEsticFent_accioID"  onchange="if(typeof onChangeAccioID == 'function') {  onChangeAccioID(this); };"  cssClass="form-control col-md-9-optional" path="modificacioQueEsticFent.accioID">
            <c:forEach items="${__theForm.listOfAccioForAccioID}" var="tmp">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.USUARIID)}">
        <tr id="modificacioQueEsticFent_usuariID_rowid">
          <td id="modificacioQueEsticFent_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.USUARIID])?'modificacioQueEsticFent.usuariID':__theForm.labels[ModificacioQueEsticFentFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_usuariID_columnvalueid">
            <form:errors path="modificacioQueEsticFent.usuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.USUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="modificacioQueEsticFent.usuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.PROJECTEID)}">
        <tr id="modificacioQueEsticFent_projecteID_rowid">
          <td id="modificacioQueEsticFent_projecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.PROJECTEID])?'modificacioQueEsticFent.projecteID':__theForm.labels[ModificacioQueEsticFentFields.PROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.PROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.PROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_projecteID_columnvalueid">
          <form:errors path="modificacioQueEsticFent.projecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.PROJECTEID)}" >
          <form:hidden path="modificacioQueEsticFent.projecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.modificacioQueEsticFent.projecteID,__theForm.listOfProjecteForProjecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.PROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="modificacioQueEsticFent_projecteID"  onchange="if(typeof onChangeProjecteID == 'function') {  onChangeProjecteID(this); };"  cssClass="form-control col-md-9-optional" path="modificacioQueEsticFent.projecteID">
            <c:forEach items="${__theForm.listOfProjecteForProjecteID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.modificacioQueEsticFent.projecteID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.modificacioQueEsticFent.projecteID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.QUEESTICFENTID)}">
        <tr id="modificacioQueEsticFent_queEsticFentID_rowid">
          <td id="modificacioQueEsticFent_queEsticFentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.QUEESTICFENTID])?'modificacioQueEsticFent.queEsticFentID':__theForm.labels[ModificacioQueEsticFentFields.QUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.QUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.QUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_queEsticFentID_columnvalueid">
            <form:errors path="modificacioQueEsticFent.queEsticFentID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.QUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.QUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="modificacioQueEsticFent.queEsticFentID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.DADA1)}">
        <tr id="modificacioQueEsticFent_dada1_rowid">
          <td id="modificacioQueEsticFent_dada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.DADA1])?'modificacioQueEsticFent.dada1':__theForm.labels[ModificacioQueEsticFentFields.DADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.DADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.DADA1]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_dada1_columnvalueid">
              <form:errors path="modificacioQueEsticFent.dada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.DADA1)? 'true' : 'false'}" path="modificacioQueEsticFent.dada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada1'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.DADA2)}">
        <tr id="modificacioQueEsticFent_dada2_rowid">
          <td id="modificacioQueEsticFent_dada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.DADA2])?'modificacioQueEsticFent.dada2':__theForm.labels[ModificacioQueEsticFentFields.DADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.DADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.DADA2]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_dada2_columnvalueid">
              <form:errors path="modificacioQueEsticFent.dada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.DADA2)? 'true' : 'false'}" path="modificacioQueEsticFent.dada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('modificacioQueEsticFent.dada2'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,ModificacioQueEsticFentFields.DATA)}">
        <tr id="modificacioQueEsticFent_data_rowid">
          <td id="modificacioQueEsticFent_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[ModificacioQueEsticFentFields.DATA])?'modificacioQueEsticFent.data':__theForm.labels[ModificacioQueEsticFentFields.DATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[ModificacioQueEsticFentFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[ModificacioQueEsticFentFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="modificacioQueEsticFent_data_columnvalueid">
    <form:errors path="modificacioQueEsticFent.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="modificacioQueEsticFent_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#modificacioQueEsticFent_data" path="modificacioQueEsticFent.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,ModificacioQueEsticFentFields.DATA)}" >
                    <div class="input-group-append"  data-target="#modificacioQueEsticFent_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#modificacioQueEsticFent_data').datetimepicker({
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
        
