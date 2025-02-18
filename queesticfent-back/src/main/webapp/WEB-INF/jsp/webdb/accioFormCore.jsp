<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AccioFields" className="org.fundaciobit.queesticfent.model.fields.AccioFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccioFields.NOM)}">
        <tr id="accio_nom_rowid">
          <td id="accio_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccioFields.NOM])?'accio.nom':__theForm.labels[AccioFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AccioFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccioFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="accio_nom_columnvalueid">
            <form:errors path="accio.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AccioFields.NOM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,AccioFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="45" path="accio.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccioFields.NOMLLEGENDA)}">
        <tr id="accio_nomllegenda_rowid">
          <td id="accio_nomllegenda_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccioFields.NOMLLEGENDA])?'accio.nomllegenda':__theForm.labels[AccioFields.NOMLLEGENDA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AccioFields.NOMLLEGENDA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccioFields.NOMLLEGENDA]}" ></i>
              </c:if>
            </td>
          <td id="accio_nomllegenda_columnvalueid">
            <form:errors path="accio.nomllegenda" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AccioFields.NOMLLEGENDA)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,AccioFields.NOMLLEGENDA)? ' uneditable-input' : ''}"  style="" maxlength="45" path="accio.nomllegenda"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccioFields.COLOR)}">
        <tr id="accio_color_rowid">
          <td id="accio_color_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccioFields.COLOR])?'accio.color':__theForm.labels[AccioFields.COLOR]}" />
             </label>
              <c:if test="${not empty __theForm.help[AccioFields.COLOR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccioFields.COLOR]}" ></i>
              </c:if>
            </td>
          <td id="accio_color_columnvalueid">
              <form:errors path="accio.color" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,AccioFields.COLOR)? 'true' : 'false'}" path="accio.color"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_color" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_color" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accio.color'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('accio.color'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accio.color'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_color').on('click', function(){
					var valor = ($('#dropdownMenuContainer_color').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_color').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccioFields.DESCRIPCIO)}">
        <tr id="accio_descripcio_rowid">
          <td id="accio_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccioFields.DESCRIPCIO])?'accio.descripcio':__theForm.labels[AccioFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[AccioFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccioFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="accio_descripcio_columnvalueid">
              <form:errors path="accio.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,AccioFields.DESCRIPCIO)? 'true' : 'false'}" path="accio.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accio.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('accio.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accio.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
