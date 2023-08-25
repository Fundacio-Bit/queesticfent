<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="DepartamentsFields" className="org.fundaciobit.queesticfent.model.fields.DepartamentsFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentsFields.NOM)}">
        <tr id="departaments_nom_rowid">
          <td id="departaments_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentsFields.NOM])?'departaments.nom':__theForm.labels[DepartamentsFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentsFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentsFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="departaments_nom_columnvalueid">
            <form:errors path="departaments.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentsFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,DepartamentsFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="300" path="departaments.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentsFields.COORDINADORID)}">
        <tr id="departaments_coordinadorid_rowid">
          <td id="departaments_coordinadorid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentsFields.COORDINADORID])?'departaments.coordinadorid':__theForm.labels[DepartamentsFields.COORDINADORID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentsFields.COORDINADORID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentsFields.COORDINADORID]}" ></i>
              </c:if>
            </td>
          <td id="departaments_coordinadorid_columnvalueid">
            <form:errors path="departaments.coordinadorid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentsFields.COORDINADORID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,DepartamentsFields.COORDINADORID)? ' uneditable-input' : ''}"  style="" maxlength="200" path="departaments.coordinadorid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentsFields.NOMLDAP)}">
        <tr id="departaments_nomldap_rowid">
          <td id="departaments_nomldap_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentsFields.NOMLDAP])?'departaments.nomldap':__theForm.labels[DepartamentsFields.NOMLDAP]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentsFields.NOMLDAP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentsFields.NOMLDAP]}" ></i>
              </c:if>
            </td>
          <td id="departaments_nomldap_columnvalueid">
            <form:errors path="departaments.nomldap" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentsFields.NOMLDAP)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,DepartamentsFields.NOMLDAP)? ' uneditable-input' : ''}"  style="" maxlength="200" path="departaments.nomldap"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,DepartamentsFields.DESCRIPCIO)}">
        <tr id="departaments_descripcio_rowid">
          <td id="departaments_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[DepartamentsFields.DESCRIPCIO])?'departaments.descripcio':__theForm.labels[DepartamentsFields.DESCRIPCIO]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[DepartamentsFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[DepartamentsFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="departaments_descripcio_columnvalueid">
              <form:errors path="departaments.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,DepartamentsFields.DESCRIPCIO)? 'true' : 'false'}" path="departaments.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departaments.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('departaments.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('departaments.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
