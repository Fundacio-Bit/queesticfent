<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="FestiusFields" className="org.fundaciobit.queesticfent.model.fields.FestiusFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiusFields.NOM)}">
        <tr id="festius_nom_rowid">
          <td id="festius_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiusFields.NOM])?'festius.nom':__theForm.labels[FestiusFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[FestiusFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiusFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="festius_nom_columnvalueid">
            <form:errors path="festius.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,FestiusFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,FestiusFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="300" path="festius.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiusFields.DATA)}">
        <tr id="festius_data_rowid">
          <td id="festius_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiusFields.DATA])?'festius.data':__theForm.labels[FestiusFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[FestiusFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiusFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="festius_data_columnvalueid">
    <form:errors path="festius.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="festius_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,FestiusFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#festius_data" path="festius.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,FestiusFields.DATA)}" >
                    <div class="input-group-append"  data-target="#festius_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#festius_data').datetimepicker({
                    format: '${gen:getJSDatePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiusFields.DESCRIPCIO)}">
        <tr id="festius_descripcio_rowid">
          <td id="festius_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiusFields.DESCRIPCIO])?'festius.descripcio':__theForm.labels[FestiusFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[FestiusFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiusFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="festius_descripcio_columnvalueid">
              <form:errors path="festius.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,FestiusFields.DESCRIPCIO)? 'true' : 'false'}" path="festius.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festius.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('festius.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festius.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
