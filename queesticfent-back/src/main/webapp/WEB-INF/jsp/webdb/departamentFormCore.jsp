<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="DepartamentFields" className="org.fundaciobit.queesticfent.model.fields.DepartamentFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentFields.NOM)}">
        <tr id="departament_nom_rowid">
          <td id="departament_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentFields.NOM])?'departament.nom':__theForm.labels[DepartamentFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="departament_nom_columnvalueid">
              <form:errors path="departament.nom" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentFields.NOM)? 'true' : 'false'}" path="departament.nom"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_nom" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_nom" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departament.nom'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('departament.nom'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departament.nom'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_nom').on('click', function(){
					var valor = ($('#dropdownMenuContainer_nom').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_nom').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentFields.COORDINADORID)}">
        <tr id="departament_coordinadorid_rowid">
          <td id="departament_coordinadorid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentFields.COORDINADORID])?'departament.coordinadorid':__theForm.labels[DepartamentFields.COORDINADORID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentFields.COORDINADORID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentFields.COORDINADORID]}" ></i>
              </c:if>
            </td>
          <td id="departament_coordinadorid_columnvalueid">
            <form:errors path="departament.coordinadorid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentFields.COORDINADORID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,DepartamentFields.COORDINADORID)? ' uneditable-input' : ''}"  style="" maxlength="200" path="departament.coordinadorid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentFields.NOMLDAP)}">
        <tr id="departament_nomldap_rowid">
          <td id="departament_nomldap_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentFields.NOMLDAP])?'departament.nomldap':__theForm.labels[DepartamentFields.NOMLDAP]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentFields.NOMLDAP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentFields.NOMLDAP]}" ></i>
              </c:if>
            </td>
          <td id="departament_nomldap_columnvalueid">
            <form:errors path="departament.nomldap" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentFields.NOMLDAP)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,DepartamentFields.NOMLDAP)? ' uneditable-input' : ''}"  style="" maxlength="200" path="departament.nomldap"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentFields.DESCRIPCIO)}">
        <tr id="departament_descripcio_rowid">
          <td id="departament_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentFields.DESCRIPCIO])?'departament.descripcio':__theForm.labels[DepartamentFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[DepartamentFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="departament_descripcio_columnvalueid">
              <form:errors path="departament.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentFields.DESCRIPCIO)? 'true' : 'false'}" path="departament.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departament.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('departament.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departament.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
