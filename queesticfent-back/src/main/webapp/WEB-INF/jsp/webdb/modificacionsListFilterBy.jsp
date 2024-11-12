<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacionsFields" className="org.fundaciobit.queesticfent.model.fields.ModificacionsFields"/>

  <%-- HIDDEN PARAMS: FILTER BY --%> 
  <form:hidden path="visibleFilterBy"/>

  <%-- FILTRAR PER - INICI --%>
  
  <c:set var="displayFilterDiv" value="${__theFilterForm.visibleFilterBy?'':'display:none;'}" />  
  
  <div id="FilterDiv" class="wellgroupfilter formbox" style="${displayFilterDiv} margin-bottom:3px; margin-left: 1px; padding:3px;">

      <div class="page-header">
        <fmt:message key="genapp.form.filterby"/>
        
        <div class="float-right">

           <a class="float-right" style="margin-left:10px" href="#"> <i title="<fmt:message key="genapp.form.hidefilter"/>" onclick="document.getElementById('FilterDiv').style.display='none'; document.getElementById('FilterButton').style.display='inline';" class="far fa-window-close"></i></a>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="button" onclick="clear_form_elements(this.form)" value="<fmt:message key="genapp.form.clean"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="reset" value="<fmt:message key="genapp.form.reset"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-primary float-right" type="submit" value="<fmt:message key="genapp.form.search"/>"/>

        </div>
      </div>
      <div class="form-inline">
      
      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key < 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.MODIFICACIOID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.modificacioid" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="modificacioidDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="modificacioidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.ENTRADAID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.entradaid" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="entradaidDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="entradaidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.ACCIOID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.accioid" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="accioidDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="accioidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDUSUARIID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.oldusuariID" var="oldusuariID" />
              <fmt:message key="genapp.form.searchby" var="cercaperoldusuariID" >                
                 <fmt:param value="${oldusuariID}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${oldusuariID}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperoldusuariID}" path="oldusuariID" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDPROJECTEID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.oldprojecteID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="oldprojecteIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="oldprojecteIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDQUEESTICFENTID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.oldqueesticfentid" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="oldqueesticfentidDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="oldqueesticfentidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDDADA1)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.olddada1" var="olddada1" />
              <fmt:message key="genapp.form.searchby" var="cercaperolddada1" >                
                 <fmt:param value="${olddada1}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${olddada1}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperolddada1}" path="olddada1" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDDADA2)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.olddada2" var="olddada2" />
              <fmt:message key="genapp.form.searchby" var="cercaperolddada2" >                
                 <fmt:param value="${olddada2}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${olddada2}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperolddada2}" path="olddada2" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.OLDDATA)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="modificacions.olddata" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="olddataDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#olddataDesde" path="olddataDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#olddataDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#olddataDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="olddataFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#olddataFins" path="olddataFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#olddataFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#olddataFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWUSUARIID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.newusuariID" var="newusuariID" />
              <fmt:message key="genapp.form.searchby" var="cercapernewusuariID" >                
                 <fmt:param value="${newusuariID}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${newusuariID}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernewusuariID}" path="newusuariID" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWPROJECTEID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.newprojecteID" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="newprojecteIDDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="newprojecteIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWQUEESTICFENTID)}">
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
            <%-- FILTRE NUMERO DESDE-FINS --%>
              <span class="add-on"><fmt:message key="modificacions.newqueesticfentid" />:</span>

              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="newqueesticfentidDesde" />


              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>

              <form:input cssClass="input-append input-small search-query" path="newqueesticfentidFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWDADA1)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.newdada1" var="newdada1" />
              <fmt:message key="genapp.form.searchby" var="cercapernewdada1" >                
                 <fmt:param value="${newdada1}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${newdada1}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernewdada1}" path="newdada1" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWDADA2)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="modificacions.newdada2" var="newdada2" />
              <fmt:message key="genapp.form.searchby" var="cercapernewdada2" >                
                 <fmt:param value="${newdada2}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${newdada2}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernewdada2}" path="newdada2" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,ModificacionsFields.NEWDATA)}">
<%-- FILTRE DATE-TIME --%>
            <div class="input-group" style="padding-right:4px;padding-bottom:4px;align-items:center;">
              <span class="add-on"><fmt:message key="modificacions.newdata" />:</span>
              <span class="add-on">&nbsp;<fmt:message key="genapp.from" /></span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="newdataDesde" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#newdataDesde" path="newdataDesde" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#newdataDesde"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#newdataDesde').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>              <span class="add-on">&nbsp;<fmt:message key="genapp.to" />&nbsp;</span>
            <div class="form-group"  style="margin-bottom: 0px;" >
                <div class="input-group date" id="newdataFins" data-target-input="nearest">
                      <form:input  cssClass="form-control datetimepicker-input"  data-target="#newdataFins" path="newdataFins" />
                    <c:if test="${!false}" >
                    <div class="input-group-append"  data-target="#newdataFins"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#newdataFins').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>            </div>

    
        </c:if>

      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key >= 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>
      </div>
    </div>



    <%-- FILTRAR PER - FINAL --%>
  
