<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="TwitterFields" className="org.fundaciobit.queesticfent.model.fields.TwitterFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,TwitterFields.USERNAME)}">
        <tr id="twitter_username_rowid">
          <td id="twitter_username_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TwitterFields.USERNAME])?'twitter.username':__theForm.labels[TwitterFields.USERNAME]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[TwitterFields.USERNAME]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TwitterFields.USERNAME]}" ></i>
              </c:if>
            </td>
          <td id="twitter_username_columnvalueid">
            <form:errors path="twitter.username" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TwitterFields.USERNAME)? 'true' : 'false'}" cssClass="w-50 form-control  ${gen:contains(__theForm.readOnlyFields ,TwitterFields.USERNAME)? ' uneditable-input' : ''}"  style="" maxlength="25" path="twitter.username"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TwitterFields.COMENTARIO)}">
        <tr id="twitter_comentario_rowid">
          <td id="twitter_comentario_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TwitterFields.COMENTARIO])?'twitter.comentario':__theForm.labels[TwitterFields.COMENTARIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[TwitterFields.COMENTARIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TwitterFields.COMENTARIO]}" ></i>
              </c:if>
            </td>
          <td id="twitter_comentario_columnvalueid">
              <form:errors path="twitter.comentario" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,TwitterFields.COMENTARIO)? 'true' : 'false'}" path="twitter.comentario"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_comentario" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_comentario" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('twitter.comentario'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('twitter.comentario'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('twitter.comentario'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_comentario').on('click', function(){
					var valor = ($('#dropdownMenuContainer_comentario').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_comentario').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TwitterFields.FECHA)}">
        <tr id="twitter_fecha_rowid">
          <td id="twitter_fecha_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TwitterFields.FECHA])?'twitter.fecha':__theForm.labels[TwitterFields.FECHA]}" />
             </label>
              <c:if test="${not empty __theForm.help[TwitterFields.FECHA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TwitterFields.FECHA]}" ></i>
              </c:if>
            </td>
          <td id="twitter_fecha_columnvalueid">
    <form:errors path="twitter.fecha" cssClass="errorField alert alert-danger" />
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="twitter_fecha" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TwitterFields.FECHA)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#twitter_fecha" path="twitter.fecha" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,TwitterFields.FECHA)}" >
                    <div class="input-group-append"  data-target="#twitter_fecha"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#twitter_fecha').datetimepicker({
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
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TwitterFields.USER_ID)}">
        <tr id="twitter_user_id_rowid">
          <td id="twitter_user_id_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TwitterFields.USER_ID])?'twitter.user_id':__theForm.labels[TwitterFields.USER_ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[TwitterFields.USER_ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TwitterFields.USER_ID]}" ></i>
              </c:if>
            </td>
          <td id="twitter_user_id_columnvalueid">
            <form:errors path="twitter.user_id" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TwitterFields.USER_ID)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,TwitterFields.USER_ID)? ' uneditable-input' : ''}"  style=""  path="twitter.user_id"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,TwitterFields.IP)}">
        <tr id="twitter_ip_rowid">
          <td id="twitter_ip_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[TwitterFields.IP])?'twitter.ip':__theForm.labels[TwitterFields.IP]}" />
             </label>
              <c:if test="${not empty __theForm.help[TwitterFields.IP]}">
              <i class="fas fa-info-circle" title="${__theForm.help[TwitterFields.IP]}" ></i>
              </c:if>
            </td>
          <td id="twitter_ip_columnvalueid">
            <form:errors path="twitter.ip" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,TwitterFields.IP)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,TwitterFields.IP)? ' uneditable-input' : ''}"  style="" maxlength="50" path="twitter.ip"   />

           </td>
        </tr>
        </c:if>
        
