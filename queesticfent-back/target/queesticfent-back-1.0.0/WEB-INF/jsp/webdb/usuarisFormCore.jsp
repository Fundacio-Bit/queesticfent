<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuarisFields" className="org.fundaciobit.queesticfent.model.fields.UsuarisFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.USUARIID)}">
        <tr id="usuaris_usuariid_rowid">
          <td id="usuaris_usuariid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.USUARIID])?'usuaris.usuariid':__theForm.labels[UsuarisFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_usuariid_columnvalueid">
            <form:errors path="usuaris.usuariid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.USUARIID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.usuariid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.LLINATGE1)}">
        <tr id="usuaris_llinatge1_rowid">
          <td id="usuaris_llinatge1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.LLINATGE1])?'usuaris.llinatge1':__theForm.labels[UsuarisFields.LLINATGE1]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.LLINATGE1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.LLINATGE1]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_llinatge1_columnvalueid">
            <form:errors path="usuaris.llinatge1" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.LLINATGE1)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.LLINATGE1)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.llinatge1"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.LLINATGE2)}">
        <tr id="usuaris_llinatge2_rowid">
          <td id="usuaris_llinatge2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.LLINATGE2])?'usuaris.llinatge2':__theForm.labels[UsuarisFields.LLINATGE2]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.LLINATGE2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.LLINATGE2]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_llinatge2_columnvalueid">
            <form:errors path="usuaris.llinatge2" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.LLINATGE2)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.LLINATGE2)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.llinatge2"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.NOM)}">
        <tr id="usuaris_nom_rowid">
          <td id="usuaris_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.NOM])?'usuaris.nom':__theForm.labels[UsuarisFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_nom_columnvalueid">
            <form:errors path="usuaris.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.CORREU)}">
        <tr id="usuaris_correu_rowid">
          <td id="usuaris_correu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.CORREU])?'usuaris.correu':__theForm.labels[UsuarisFields.CORREU]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.CORREU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.CORREU]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_correu_columnvalueid">
            <form:errors path="usuaris.correu" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.CORREU)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.CORREU)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.correu"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.DESCRIPCIO)}">
        <tr id="usuaris_descripcio_rowid">
          <td id="usuaris_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.DESCRIPCIO])?'usuaris.descripcio':__theForm.labels[UsuarisFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_descripcio_columnvalueid">
              <form:errors path="usuaris.descripcio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.DESCRIPCIO)? 'true' : 'false'}" path="usuaris.descripcio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_descripcio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_descripcio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('usuaris.descripcio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('usuaris.descripcio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('usuaris.descripcio'); ta.wrap='hard';">Hard Wrap</a>
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.EXTENSIO)}">
        <tr id="usuaris_extensio_rowid">
          <td id="usuaris_extensio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.EXTENSIO])?'usuaris.extensio':__theForm.labels[UsuarisFields.EXTENSIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.EXTENSIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.EXTENSIO]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_extensio_columnvalueid">
            <form:errors path="usuaris.extensio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.EXTENSIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.EXTENSIO)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.extensio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.NAIXEMENT)}">
        <tr id="usuaris_naixement_rowid">
          <td id="usuaris_naixement_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.NAIXEMENT])?'usuaris.naixement':__theForm.labels[UsuarisFields.NAIXEMENT]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.NAIXEMENT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.NAIXEMENT]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_naixement_columnvalueid">
    <form:errors path="usuaris.naixement" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="usuaris_naixement" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.NAIXEMENT)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#usuaris_naixement" path="usuaris.naixement" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuarisFields.NAIXEMENT)}" >
                    <div class="input-group-append"  data-target="#usuaris_naixement"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#usuaris_naixement').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.TELEFONCASA)}">
        <tr id="usuaris_telefoncasa_rowid">
          <td id="usuaris_telefoncasa_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.TELEFONCASA])?'usuaris.telefoncasa':__theForm.labels[UsuarisFields.TELEFONCASA]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.TELEFONCASA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.TELEFONCASA]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_telefoncasa_columnvalueid">
            <form:errors path="usuaris.telefoncasa" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.TELEFONCASA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.TELEFONCASA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.telefoncasa"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.TELEFONMOBIL)}">
        <tr id="usuaris_telefonmobil_rowid">
          <td id="usuaris_telefonmobil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.TELEFONMOBIL])?'usuaris.telefonmobil':__theForm.labels[UsuarisFields.TELEFONMOBIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.TELEFONMOBIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.TELEFONMOBIL]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_telefonmobil_columnvalueid">
            <form:errors path="usuaris.telefonmobil" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.TELEFONMOBIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.TELEFONMOBIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.telefonmobil"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuarisFields.CONTRASENYA)}">
        <tr id="usuaris_contrasenya_rowid">
          <td id="usuaris_contrasenya_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuarisFields.CONTRASENYA])?'usuaris.contrasenya':__theForm.labels[UsuarisFields.CONTRASENYA]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuarisFields.CONTRASENYA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuarisFields.CONTRASENYA]}" ></i>
              </c:if>
            </td>
          <td id="usuaris_contrasenya_columnvalueid">
            <form:errors path="usuaris.contrasenya" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuarisFields.CONTRASENYA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuarisFields.CONTRASENYA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuaris.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
