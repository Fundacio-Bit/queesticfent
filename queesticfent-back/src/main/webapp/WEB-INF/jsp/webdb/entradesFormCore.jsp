<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EntradesFields" className="org.fundaciobit.queesticfent.model.fields.EntradesFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.ACCIOID)}">
        <tr id="entrades_accioid_rowid">
          <td id="entrades_accioid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.ACCIOID])?'entrades.accioid':__theForm.labels[EntradesFields.ACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.ACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.ACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="entrades_accioid_columnvalueid">
          <form:errors path="entrades.accioid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EntradesFields.ACCIOID)}" >
          <form:hidden path="entrades.accioid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.entrades.accioid,__theForm.listOfAccionsForAccioid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradesFields.ACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="entrades_accioid"  onchange="if(typeof onChangeAccioid == 'function') {  onChangeAccioid(this); };"  cssClass="form-control col-md-9-optional" path="entrades.accioid">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.USUARIID)}">
        <tr id="entrades_usuariid_rowid">
          <td id="entrades_usuariid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.USUARIID])?'entrades.usuariid':__theForm.labels[EntradesFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="entrades_usuariid_columnvalueid">
            <form:errors path="entrades.usuariid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradesFields.USUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,EntradesFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="entrades.usuariid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.PROJECTEID)}">
        <tr id="entrades_projecteid_rowid">
          <td id="entrades_projecteid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.PROJECTEID])?'entrades.projecteid':__theForm.labels[EntradesFields.PROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.PROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.PROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="entrades_projecteid_columnvalueid">
          <form:errors path="entrades.projecteid" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EntradesFields.PROJECTEID)}" >
          <form:hidden path="entrades.projecteid"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.entrades.projecteid,__theForm.listOfProjectesForProjecteid)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradesFields.PROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="entrades_projecteid"  onchange="if(typeof onChangeProjecteid == 'function') {  onChangeProjecteid(this); };"  cssClass="form-control col-md-9-optional" path="entrades.projecteid">
            <c:forEach items="${__theForm.listOfProjectesForProjecteid}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.entrades.projecteid }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.entrades.projecteid }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.QUEESTICFENTID)}">
        <tr id="entrades_queesticfentid_rowid">
          <td id="entrades_queesticfentid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.QUEESTICFENTID])?'entrades.queesticfentid':__theForm.labels[EntradesFields.QUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.QUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.QUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="entrades_queesticfentid_columnvalueid">
            <form:errors path="entrades.queesticfentid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradesFields.QUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EntradesFields.QUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="entrades.queesticfentid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.DADA1)}">
        <tr id="entrades_dada1_rowid">
          <td id="entrades_dada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.DADA1])?'entrades.dada1':__theForm.labels[EntradesFields.DADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.DADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.DADA1]}" ></i>
              </c:if>
            </td>
          <td id="entrades_dada1_columnvalueid">
              <form:errors path="entrades.dada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EntradesFields.DADA1)? 'true' : 'false'}" path="entrades.dada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrades.dada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('entrades.dada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrades.dada1'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.DADA2)}">
        <tr id="entrades_dada2_rowid">
          <td id="entrades_dada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.DADA2])?'entrades.dada2':__theForm.labels[EntradesFields.DADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.DADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.DADA2]}" ></i>
              </c:if>
            </td>
          <td id="entrades_dada2_columnvalueid">
              <form:errors path="entrades.dada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EntradesFields.DADA2)? 'true' : 'false'}" path="entrades.dada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrades.dada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('entrades.dada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrades.dada2'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradesFields.DATA)}">
        <tr id="entrades_data_rowid">
          <td id="entrades_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradesFields.DATA])?'entrades.data':__theForm.labels[EntradesFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EntradesFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradesFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="entrades_data_columnvalueid">
    <form:errors path="entrades.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="entrades_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradesFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#entrades_data" path="entrades.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradesFields.DATA)}" >
                    <div class="input-group-append"  data-target="#entrades_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="far fa-clock"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#entrades_data').datetimepicker({
                    format: '${gen:getJSTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
