<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="ModificacioQueEsticFentFields" className="org.fundaciobit.queesticfent.model.fields.ModificacioQueEsticFentFields"/>
  
  <c:set var="__theForm" value="${modificacioQueEsticFentForm}"/>

  <div class="module_content">
    <div class="tab_container">
    
    <c:if test="${not __theForm.view}">    <c:forEach items="${__theForm.hiddenFields}" var="hiddenFieldF" >
      <c:set  var="hiddenField" value="${hiddenFieldF.javaName}" />
      <c:if test="${gen:hasProperty(__theForm.modificacioQueEsticFent,hiddenField)}">
        <form:errors path="modificacioQueEsticFent.${hiddenField}" cssClass="errorField alert alert-danger" />
        <form:hidden path="modificacioQueEsticFent.${hiddenField}"/>
      </c:if>
    </c:forEach>
    </c:if>

    <form:errors cssClass="errorField alert alert-danger" delimiter="&lt;p/&gt;" />
    <table id="modificacioQueEsticFent_tableid" class="tdformlabel table-sm table table-bordered table-striped marTop10 table-genapp table-genapp-form" > 
    <tbody>      

