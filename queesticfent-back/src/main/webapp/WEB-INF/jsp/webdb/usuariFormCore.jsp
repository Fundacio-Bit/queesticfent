<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="UsuariFields" className="org.fundaciobit.queesticfent.model.fields.UsuariFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.USUARIID)}">
        <tr id="usuari_usuariID_rowid">
          <td id="usuari_usuariID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.USUARIID])?'usuari.usuariID':__theForm.labels[UsuariFields.USUARIID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.USUARIID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.USUARIID]}" ></i>
              </c:if>
            </td>
          <td id="usuari_usuariID_columnvalueid">
            <form:errors path="usuari.usuariID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.USUARIID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.USUARIID)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.usuariID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.NOM)}">
        <tr id="usuari_nom_rowid">
          <td id="usuari_nom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.NOM])?'usuari.nom':__theForm.labels[UsuariFields.NOM]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.NOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.NOM]}" ></i>
              </c:if>
            </td>
          <td id="usuari_nom_columnvalueid">
            <form:errors path="usuari.nom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.NOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.NOM)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.nom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.LLINATGE1)}">
        <tr id="usuari_llinatge1_rowid">
          <td id="usuari_llinatge1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.LLINATGE1])?'usuari.llinatge1':__theForm.labels[UsuariFields.LLINATGE1]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.LLINATGE1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.LLINATGE1]}" ></i>
              </c:if>
            </td>
          <td id="usuari_llinatge1_columnvalueid">
            <form:errors path="usuari.llinatge1" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.LLINATGE1)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.LLINATGE1)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.llinatge1"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.LLINATGE2)}">
        <tr id="usuari_llinatge2_rowid">
          <td id="usuari_llinatge2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.LLINATGE2])?'usuari.llinatge2':__theForm.labels[UsuariFields.LLINATGE2]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.LLINATGE2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.LLINATGE2]}" ></i>
              </c:if>
            </td>
          <td id="usuari_llinatge2_columnvalueid">
            <form:errors path="usuari.llinatge2" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.LLINATGE2)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.LLINATGE2)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.llinatge2"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.CORREU)}">
        <tr id="usuari_correu_rowid">
          <td id="usuari_correu_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.CORREU])?'usuari.correu':__theForm.labels[UsuariFields.CORREU]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.CORREU]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.CORREU]}" ></i>
              </c:if>
            </td>
          <td id="usuari_correu_columnvalueid">
            <form:errors path="usuari.correu" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.CORREU)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.CORREU)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.correu"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.DESCRIPCIO)}">
        <tr id="usuari_descripcio_rowid">
          <td id="usuari_descripcio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.DESCRIPCIO])?'usuari.descripcio':__theForm.labels[UsuariFields.DESCRIPCIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.DESCRIPCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.DESCRIPCIO]}" ></i>
              </c:if>
            </td>
          <td id="usuari_descripcio_columnvalueid">
            <form:errors path="usuari.descripcio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.DESCRIPCIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.DESCRIPCIO)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.descripcio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.EXTENSIO)}">
        <tr id="usuari_extensio_rowid">
          <td id="usuari_extensio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.EXTENSIO])?'usuari.extensio':__theForm.labels[UsuariFields.EXTENSIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.EXTENSIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.EXTENSIO]}" ></i>
              </c:if>
            </td>
          <td id="usuari_extensio_columnvalueid">
            <form:errors path="usuari.extensio" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.EXTENSIO)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.EXTENSIO)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.extensio"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.NAIXEMENT)}">
        <tr id="usuari_naixement_rowid">
          <td id="usuari_naixement_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.NAIXEMENT])?'usuari.naixement':__theForm.labels[UsuariFields.NAIXEMENT]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.NAIXEMENT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.NAIXEMENT]}" ></i>
              </c:if>
            </td>
          <td id="usuari_naixement_columnvalueid">
    <form:errors path="usuari.naixement" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="usuari_naixement" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.NAIXEMENT)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#usuari_naixement" path="usuari.naixement" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,UsuariFields.NAIXEMENT)}" >
                    <div class="input-group-append"  data-target="#usuari_naixement"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#usuari_naixement').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.TELEFONCASA)}">
        <tr id="usuari_telefoncasa_rowid">
          <td id="usuari_telefoncasa_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.TELEFONCASA])?'usuari.telefoncasa':__theForm.labels[UsuariFields.TELEFONCASA]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.TELEFONCASA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.TELEFONCASA]}" ></i>
              </c:if>
            </td>
          <td id="usuari_telefoncasa_columnvalueid">
            <form:errors path="usuari.telefoncasa" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.TELEFONCASA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.TELEFONCASA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.telefoncasa"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.TELEFONMOBIL)}">
        <tr id="usuari_telefonmobil_rowid">
          <td id="usuari_telefonmobil_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.TELEFONMOBIL])?'usuari.telefonmobil':__theForm.labels[UsuariFields.TELEFONMOBIL]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.TELEFONMOBIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.TELEFONMOBIL]}" ></i>
              </c:if>
            </td>
          <td id="usuari_telefonmobil_columnvalueid">
            <form:errors path="usuari.telefonmobil" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.TELEFONMOBIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.TELEFONMOBIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.telefonmobil"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,UsuariFields.CONTRASENYA)}">
        <tr id="usuari_contrasenya_rowid">
          <td id="usuari_contrasenya_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[UsuariFields.CONTRASENYA])?'usuari.contrasenya':__theForm.labels[UsuariFields.CONTRASENYA]}" />
             </label>
              <c:if test="${not empty __theForm.help[UsuariFields.CONTRASENYA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[UsuariFields.CONTRASENYA]}" ></i>
              </c:if>
            </td>
          <td id="usuari_contrasenya_columnvalueid">
            <form:errors path="usuari.contrasenya" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,UsuariFields.CONTRASENYA)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,UsuariFields.CONTRASENYA)? ' uneditable-input' : ''}"  style="" maxlength="100" path="usuari.contrasenya"   />

           </td>
        </tr>
        </c:if>
        
