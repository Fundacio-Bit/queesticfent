<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="FestiuFields" className="org.fundaciobit.queesticfent.model.fields.FestiuFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiuFields.NOM)}">
        <tr id="festiu_nom_rowid">
          <td id="festiu_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiuFields.NOM])?'festiu.nom':__theForm.labels[FestiuFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[FestiuFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiuFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="festiu_nom_columnvalueid">
              <form:errors path="festiu.nom" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,FestiuFields.NOM)? 'true' : 'false'}" path="festiu.nom"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_nom" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_nom" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festiu.nom'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('festiu.nom'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festiu.nom'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiuFields.DATA)}">
        <tr id="festiu_data_rowid">
          <td id="festiu_data_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiuFields.DATA])?'festiu.data':__theForm.labels[FestiuFields.DATA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[FestiuFields.DATA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiuFields.DATA]}" ></i>
              </c:if>
            </td>
          <td id="festiu_data_columnvalueid">
    <form:errors path="festiu.data" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="festiu_data" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,FestiuFields.DATA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#festiu_data" path="festiu.data" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,FestiuFields.DATA)}" >
                    <div class="input-group-append"  data-target="#festiu_data"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#festiu_data').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,FestiuFields.DESCRIPCIO)}">
        <tr id="festiu_descripcio_rowid">
          <td id="festiu_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[FestiuFields.DESCRIPCIO])?'festiu.descripcio':__theForm.labels[FestiuFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[FestiuFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[FestiuFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="festiu_descripcio_columnvalueid">
              <form:errors path="festiu.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,FestiuFields.DESCRIPCIO)? 'true' : 'false'}" path="festiu.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festiu.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('festiu.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('festiu.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
