<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ProjectesFields" className="org.fundaciobit.queesticfent.model.fields.ProjectesFields"/>
  
  <c:set var="__theForm" value="${projectesForm}"/>

  <div class="module_content">
    <div class="tab_container">
    
    <c:if test="${not __theForm.view}">    <c:forEach items="${__theForm.hiddenFields}" var="hiddenFieldF" >
      <c:set  var="hiddenField" value="${hiddenFieldF.javaName}" />
      <c:if test="${gen:hasProperty(__theForm.projectes,hiddenField)}">
        <form:errors path="projectes.${hiddenField}" cssClass="errorField alert alert-danger" />
        <form:hidden path="projectes.${hiddenField}"/>
      </c:if>
    </c:forEach>
    </c:if>

    <form:errors cssClass="errorField alert alert-danger" delimiter="&lt;p/&gt;" />
    <table id="projectes_tableid" class="tdformlabel table-sm table table-bordered table-striped marTop10 table-genapp table-genapp-form" > 
    <tbody>      

