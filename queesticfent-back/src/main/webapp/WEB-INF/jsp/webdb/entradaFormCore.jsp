<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="EntradaFields" className="org.fundaciobit.queesticfent.model.fields.EntradaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.ACCIOID)}">
        <tr id="entrada_accioID_rowid">
          <td id="entrada_accioID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.ACCIOID])?'entrada.accioID':__theForm.labels[EntradaFields.ACCIOID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.ACCIOID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.ACCIOID]}" ></i>
              </c:if>
            </td>
          <td id="entrada_accioID_columnvalueid">
          <form:errors path="entrada.accioID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EntradaFields.ACCIOID)}" >
          <form:hidden path="entrada.accioID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.entrada.accioID,__theForm.listOfAccioForAccioID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradaFields.ACCIOID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="entrada_accioID"  onchange="if(typeof onChangeAccioID == 'function') {  onChangeAccioID(this); };"  cssClass="form-control col-md-9-optional" path="entrada.accioID">
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.USUARIID)}">
        <tr id="entrada_usuariID_rowid">
          <td id="entrada_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.USUARIID])?'entrada.usuariID':__theForm.labels[EntradaFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="entrada_usuariID_columnvalueid">
            <form:errors path="entrada.usuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradaFields.USUARIID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,EntradaFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="45" path="entrada.usuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.PROJECTEID)}">
        <tr id="entrada_projecteID_rowid">
          <td id="entrada_projecteID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.PROJECTEID])?'entrada.projecteID':__theForm.labels[EntradaFields.PROJECTEID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.PROJECTEID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.PROJECTEID]}" ></i>
              </c:if>
            </td>
          <td id="entrada_projecteID_columnvalueid">
          <form:errors path="entrada.projecteID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,EntradaFields.PROJECTEID)}" >
          <form:hidden path="entrada.projecteID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.entrada.projecteID,__theForm.listOfProjecteForProjecteID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradaFields.PROJECTEID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="entrada_projecteID"  onchange="if(typeof onChangeProjecteID == 'function') {  onChangeProjecteID(this); };"  cssClass="form-control col-md-9-optional" path="entrada.projecteID">
            <c:forEach items="${__theForm.listOfProjecteForProjecteID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
            <%-- El camp pot ser null, per la qual cosa afegim una entrada buida si no s'ha definit abans --%>
            <c:if test="${not containEmptyValue}">
              <c:if test="${empty __theForm.entrada.projecteID }">
                  <form:option value="" selected="true" ></form:option>
              </c:if>
              <c:if test="${not empty __theForm.entrada.projecteID }">
                  <form:option value="" ></form:option>
              </c:if>
            </c:if>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.DADA1)}">
        <tr id="entrada_dada1_rowid">
          <td id="entrada_dada1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.DADA1])?'entrada.dada1':__theForm.labels[EntradaFields.DADA1]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.DADA1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.DADA1]}" ></i>
              </c:if>
            </td>
          <td id="entrada_dada1_columnvalueid">
              <form:errors path="entrada.dada1" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EntradaFields.DADA1)? 'true' : 'false'}" path="entrada.dada1"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada1" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada1" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrada.dada1'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('entrada.dada1'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrada.dada1'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.QUEESTICFENTID)}">
        <tr id="entrada_queEsticFentID_rowid">
          <td id="entrada_queEsticFentID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.QUEESTICFENTID])?'entrada.queEsticFentID':__theForm.labels[EntradaFields.QUEESTICFENTID]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.QUEESTICFENTID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.QUEESTICFENTID]}" ></i>
              </c:if>
            </td>
          <td id="entrada_queEsticFentID_columnvalueid">
            <form:errors path="entrada.queEsticFentID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradaFields.QUEESTICFENTID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,EntradaFields.QUEESTICFENTID)? ' uneditable-input' : ''}"  style=""  path="entrada.queEsticFentID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.DADA2)}">
        <tr id="entrada_dada2_rowid">
          <td id="entrada_dada2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.DADA2])?'entrada.dada2':__theForm.labels[EntradaFields.DADA2]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.DADA2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.DADA2]}" ></i>
              </c:if>
            </td>
          <td id="entrada_dada2_columnvalueid">
              <form:errors path="entrada.dada2" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,EntradaFields.DADA2)? 'true' : 'false'}" path="entrada.dada2"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_dada2" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_dada2" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrada.dada2'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('entrada.dada2'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('entrada.dada2'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,EntradaFields.DATA)}">
        <tr id="entrada_data_rowid">
          <td id="entrada_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[EntradaFields.DATA])?'entrada.data':__theForm.labels[EntradaFields.DATA]}" />
             </label>
              <c:if test="${not empty __theForm.help[EntradaFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[EntradaFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="entrada_data_columnvalueid">
    <form:errors path="entrada.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="entrada_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,EntradaFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#entrada_data" path="entrada.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,EntradaFields.DATA)}" >
                    <div class="input-group-append"  data-target="#entrada_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#entrada_data').datetimepicker({
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
        
