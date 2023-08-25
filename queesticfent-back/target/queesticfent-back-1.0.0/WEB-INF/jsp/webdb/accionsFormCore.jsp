<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="AccionsFields" className="org.fundaciobit.queesticfent.model.fields.AccionsFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccionsFields.NOM)}">
        <tr id="accions_nom_rowid">
          <td id="accions_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccionsFields.NOM])?'accions.nom':__theForm.labels[AccionsFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AccionsFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccionsFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="accions_nom_columnvalueid">
            <form:errors path="accions.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AccionsFields.NOM)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,AccionsFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="45" path="accions.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccionsFields.NOMLLEGENDA)}">
        <tr id="accions_nomllegenda_rowid">
          <td id="accions_nomllegenda_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccionsFields.NOMLLEGENDA])?'accions.nomllegenda':__theForm.labels[AccionsFields.NOMLLEGENDA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[AccionsFields.NOMLLEGENDA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccionsFields.NOMLLEGENDA]}" ></i>
              </c:if>
            </td>
          <td id="accions_nomllegenda_columnvalueid">
            <form:errors path="accions.nomllegenda" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AccionsFields.NOMLLEGENDA)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,AccionsFields.NOMLLEGENDA)? ' uneditable-input' : ''}"  style="" maxlength="45" path="accions.nomllegenda"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccionsFields.COLOR)}">
        <tr id="accions_color_rowid">
          <td id="accions_color_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccionsFields.COLOR])?'accions.color':__theForm.labels[AccionsFields.COLOR]}" />
             </label>
              <c:if test="${not empty __theForm.help[AccionsFields.COLOR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccionsFields.COLOR]}" ></i>
              </c:if>
            </td>
          <td id="accions_color_columnvalueid">
            <form:errors path="accions.color" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,AccionsFields.COLOR)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,AccionsFields.COLOR)? ' uneditable-input' : ''}"  style="" maxlength="2147483647" path="accions.color"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,AccionsFields.DESCRIPCIO)}">
        <tr id="accions_descripcio_rowid">
          <td id="accions_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[AccionsFields.DESCRIPCIO])?'accions.descripcio':__theForm.labels[AccionsFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[AccionsFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[AccionsFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="accions_descripcio_columnvalueid">
              <form:errors path="accions.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,AccionsFields.DESCRIPCIO)? 'true' : 'false'}" path="accions.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accions.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('accions.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('accions.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
