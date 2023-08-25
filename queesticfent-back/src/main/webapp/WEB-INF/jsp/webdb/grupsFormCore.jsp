<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="GrupsFields" className="org.fundaciobit.queesticfent.model.fields.GrupsFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsFields.NOM)}">
        <tr id="grups_nom_rowid">
          <td id="grups_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsFields.NOM])?'grups.nom':__theForm.labels[GrupsFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[GrupsFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="grups_nom_columnvalueid">
            <form:errors path="grups.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,GrupsFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,GrupsFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="255" path="grups.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsFields.DESCRIPCIO)}">
        <tr id="grups_descripcio_rowid">
          <td id="grups_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsFields.DESCRIPCIO])?'grups.descripcio':__theForm.labels[GrupsFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[GrupsFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="grups_descripcio_columnvalueid">
              <form:errors path="grups.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,GrupsFields.DESCRIPCIO)? 'true' : 'false'}" path="grups.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('grups.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('grups.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('grups.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,GrupsFields.NIVELLSEGURETAT)}">
        <tr id="grups_nivellseguretat_rowid">
          <td id="grups_nivellseguretat_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[GrupsFields.NIVELLSEGURETAT])?'grups.nivellseguretat':__theForm.labels[GrupsFields.NIVELLSEGURETAT]}" />
             </label>
              <c:if test="${not empty __theForm.help[GrupsFields.NIVELLSEGURETAT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[GrupsFields.NIVELLSEGURETAT]}" ></i>
              </c:if>
            </td>
          <td id="grups_nivellseguretat_columnvalueid">
            <form:errors path="grups.nivellseguretat" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,GrupsFields.NIVELLSEGURETAT)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,GrupsFields.NIVELLSEGURETAT)? ' uneditable-input' : ''}"  style=""  path="grups.nivellseguretat"   />

           </td>
        </tr>
        </c:if>
        
