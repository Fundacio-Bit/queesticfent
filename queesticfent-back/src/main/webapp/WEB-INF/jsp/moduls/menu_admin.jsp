<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>Menú ROLE_ADMIN</h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">


    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/gestiofestius/list"/>">
        <span style="${(fn:contains(url, 'gestiofestius'))? "font-weight: bold;" : ""}">Gestió de Festius</span>
      </a>
    </li>
    
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/gestiousuarisdepartament/list"/>">
        <span style="${(fn:contains(url, 'gestiousuarisdepartament'))? "font-weight: bold;" : ""}">Gestió d'Usuaris Departament</span>
      </a>
    </li>
    
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/gestiousuarisprojecte/list"/>">
        <span style="${(fn:contains(url, 'gestiousuarisprojecte'))? "font-weight: bold;" : ""}">Gestió d'Usuaris Projecte</span>
      </a>
    </li>
    
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/gestiousuaris/list"/>">
        <span style="${(fn:contains(url, 'gestiousuaris'))? "font-weight: bold;" : ""}">Gestió d'Usuaris</span>
      </a>
    </li>

   <%-- Example with security: virtual roles  --%>
   <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/admin/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
    --%>
   
  </ul>
</div>

