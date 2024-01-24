<%@page import="org.fundaciobit.queesticfent.back.controller.user.LlistatEntradesUserController"%>
<%@page import="java.util.HashMap"
%><%@page import="org.fundaciobit.queesticfent.back.security.LoginInfo"
%><%@page import="org.fundaciobit.queesticfent.persistence.UsuarisJPA"
%><%@page import="org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA"
%><%@page import="org.fundaciobit.queesticfent.model.entity.Projectes"
%><%@page import="org.fundaciobit.queesticfent.model.entity.Departaments"
%><%@ page language="java" contentType="text/html;"
%><%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.fundaciobit.queesticfent.back.utils.Utils"%>
<%@page import="org.fundaciobit.queesticfent.back.controller.user.QueEsticFentItem"%>
<%@page import="org.fundaciobit.queesticfent.back.controller.user.ModificacioItem"%>
<%@page import="org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent"%>
<%@page import="org.fundaciobit.queesticfent.model.entity.Accions"%>
<%@page import="org.fundaciobit.queesticfent.model.fields.AccionsFields"%>
<%@page import="org.fundaciobit.queesticfent.model.entity.UsuarisDepartament"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<%! 

public SimpleDateFormat getSimpleDateFormat() {
    return new SimpleDateFormat("dd/MM/yyyy");
  }
  

  public SimpleDateFormat getSimpleDateTimeFormat() {
    return LlistatEntradesUserController.getSimpleDateTimeFormat();
  }

  public SimpleDateFormat getSimpleTimeFormat() {
     return new java.text.SimpleDateFormat("HH:mm");
  }

  public boolean getBoolean(HttpServletRequest request, String name) {
    String str = request.getParameter(name);
    return Boolean.parseBoolean(str);    
  }


%>
<%

List<Long> departaments = (List<Long>) request.getAttribute("departaments");
Boolean tePermisos = (Boolean) request.getAttribute("tePermisos");
List<Accions> actions = (List<Accions>) request.getAttribute("actions");
Boolean mostrarEntradesAmagades = (Boolean) request.getAttribute("mostrarEntradesAmagades");

List<Accions> allAccions = (List<Accions>) request.getAttribute("allAccions");
String redirectUrl = (String) request.getAttribute("redirectUrl");
Long projecteID = (Long) request.getAttribute("projecteID");
Calendar start = (Calendar) request.getAttribute("start");
Calendar yesterday = (Calendar) request.getAttribute("yesterday");
Calendar today = (Calendar) request.getAttribute("today");
String usuariID = (String) request.getAttribute("usuariID");
Map<Date, List<QueEsticFentItem>> itemsByDate = (Map<Date, List<QueEsticFentItem>>) request.getAttribute("itemsByDate");
int maxDay = (int) request.getAttribute("maxDay");
String redirectUrlParams = (String) request.getAttribute("redirectUrlParams");

int mesAnterior = (int) request.getAttribute("mesAnterior");
int anyAnterior = (int) request.getAttribute("anyAnterior");
int anySeguent = (int) request.getAttribute("anySeguent");
int mesSeguent = (int) request.getAttribute("mesSeguent");

int mes = (int) request.getAttribute("mes");
int any = (int) request.getAttribute("any");

Long departamentID = (Long)request.getAttribute("departamentID");
List<Projectes> projectesList = (List<Projectes>) request.getAttribute("projectesList");

List<Departaments> departamentsInfo = (List<Departaments>) request.getAttribute("departamentsInfo");

Map<String, String> noms = new HashMap<String, String>();
LoginInfo info = LoginInfo.getInstance();
noms.put(usuariID, info.getUserInfo().getFullName());

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Llista de Modificacions de QueEsticFent</title>
<script type="text/javascript">

</script>
</head>
<body  >

<table width="100%" height="100%" >
<tr><td valign="top" align="center">
<div id="itsthetable">
 <p class="caption">Entrades OTAE de QueEsticFent</p>

 
 
<table border="0" cellpadding="2" cellspacing="0"  style="font-family: 'Arial'">
<tr>
  <td>
  <FORM name="REB2010" method="post">
  <span id="toolTipBox" width="200"></span>
<input type="hidden" name="mes" value="<%=mes%>">
<input type="hidden" name="any" value="<%=any%>">
  <table border="0" cellpadding="0" cellspacing="0" >
    <tr>
      <td style="padding-right:10px;">
     Nom:<br>  
     
     
         
<% if (tePermisos) {%>
    <select name="usuariID"  onchange="document.REB2010.submit()" >
<% {

    List<UsuarisDepartament> personalCap = (List<UsuarisDepartament>) request.getAttribute("personalCap");  
  
  
  //java.util.List<KeyValue<String>> __users = __security.getAllUserNames();
    String __def;
    
          for(UsuarisDepartament po : personalCap) {
            __def = po.getUsuariID().equals(usuariID) ? "selected" : "";
            UsuarisJPA usu =((UsuarisDepartamentJPA) po).getUsuaris();
          %>
          
             <option value="<%=po.getUsuariID()%>" <%=__def%> ><%= (usu.getNom()+" "+usu.getLlinatge1()+" "+usu.getLlinatge2())%></option>
        <% } %>
 <% } %>
</select>

<% } else { %>
    <b><%= noms.get(usuariID)%></b>
 <% } %>
  </td> 
  
  <%-- /* DEPARTAMENTS   */  --%>
  <td align="left"  style="border-left: 1px solid; padding-right:10px; padding-left:10px;">
     <% if (departaments.size() == 1) { %>
         <input type="hidden" name="departamentID" value="<%=departamentID%>"> 
     Departament:<br>
     <b> <%=departamentsInfo.get(0).getNom()%></b>
      
     <%  } else { %>
     Departaments:<br>
     <select name="departamentID"  onchange="document.REB2010.submit()" >
          <% {
            
            
            
            //java.util.List<KeyValue<String>> __users = __security.getAllUserNames();
            String __def;
            for(Departaments dep : departamentsInfo) {
              __def = departamentID.equals(dep.getDepartamentID()) ? "selected" : "";
            %>
               <option value="<%=dep.getDepartamentID()%>" <%=__def%> ><%=dep.getNom() + " (getSecurity().getFullNameOfUser(dep.getCoordinadorID())"%></option>
          <% } %>
          <% } %>
          </select>
     <% } %>
      
  </td>
  
  <%-- /* PROJECTE */ --%>
  <td align="left" style="border-left: 1px solid; padding-right:10px; padding-left:10px;">
     <%  
     Map<Long, String> projectesMap = new HashMap<Long, String>();
     { %>
      Projectes:<br>
      <select name="projecteID"  onchange="document.REB2010.submit()" >
          <%  %>
            <option value="" <%=projecteID == null ? "selected":"" %> >Tots</option>
          <% {
            
            //java.util.List<KeyValue<String>> __users = __security.getAllUserNames();
            String __def;
            for(Projectes proj : projectesList) {
                
              __def = (projecteID != null && proj.getProjecteID() == projecteID) ? "selected" : "";
              projectesMap.put(proj.getProjecteID(), proj.getNom());
            %>
               <option value="<%=proj.getProjecteID()%>" <%=__def%> ><%=proj.getNom()%></option>
          <% } %>
          <% } %>
          </select>
     <% } %>
  </td>

  <td align="right" width="40px" style="border-left: 1px solid">
     &nbsp;&nbsp;<img onclick="document.REB2010.mes.value=<%=mesAnterior%>;document.REB2010.any.value=<%=anyAnterior%>;document.REB2010.submit()" src="<c:url value="/img"/>/previous.jpg">  
  </td>
<td align="center" >
  
  <span style="font-family: helvetica, impact, sans-serif;font-size: 12pt; font-weight: bold;">
   <%= Utils.mesos[mes] %> <%=any%>
  </span>
 
</td> 
<td align="left"  width="40px">
  <img onclick="document.REB2010.mes.value=<%=mesSeguent%>;document.REB2010.any.value=<%=anySeguent%>;document.REB2010.submit()" src="<c:url value="/img"/>/next.jpg">
</td>



<td align="center" style="border-left: 1px solid; padding-right:10px; padding-left:10px;">
   
   <a href="mostrarodt?<%=redirectUrlParams%>&usuariID=<%=usuariID%>" target="_blank" onmouseover="toolTip('ODT de Tasques de getSecurity().getFullNameOfUser(usuariID)', this)">
      <img border="0" src="<c:url value="/img"/>/odt.gif"></a>
   
 </td>
 <% if (tePermisos) {%><td>&nbsp;</td>

<td align="center" style="border-left: 1px solid; padding-right:10px; padding-left:10px;"> 
   <% String href;
      String target;
      href = "mostrarodt?" + redirectUrlParams +"&multiple=true";
      target = "target=\"_blank\"";
   %>
   <a href="<%=href%>" <%=target%>  onmouseover="toolTip('ODT de Tasques de tot el personal', this)" >
      <img border="0" src="<c:url value="/img"/>/odtmultiple.gif">
   </a>
 </td>
 <% } %>
 
 <%--
 
 <td style="border-left: 1px solid; padding-right:10px; padding-left:10px;">
 <table>
  <tr><td>
  <input type="checkbox" onclick="document.REB2010.submit()" name="mostrarEntradesAmagades" <%=mostrarEntradesAmagades?"checked": ""%>>
  </td>
  <td>
  Mostrar
  Entrades
  Amagades
  </td></tr></table>
</td>

<td align="center" style="border-left: 1px solid; padding-right:10px; padding-left:10px;">

<a  href="AfegirEntradaDeQueEsticFent.jsp?<%=redirectUrlParams%>&redirectUrl=<%=redirectUrl%>">
Afegir Entrada

 del QueEsticFent
   </a>
   
<td>
 
 
 <td>
   <a href="<c:url value="/user/entrades/testbasecamp"/>"> BASECAMP TEST</a>
 </td>
 --%>
</tr>
</table>
</FORM>
</td>
</tr>

<tr>
<td colspan=3>

<table border="1" cellpadding="1" cellspacing="0" >
<tbody class="tabledata">
<tr class="header">
<%--
<% if (getUserSecurityLevel(session) >= SecurityLevel.Edit.getLevel()) {%><td>&nbsp;</td>
<% } %>
<% if (getUserSecurityLevel(session) >= SecurityLevel.Delete.getLevel()) {%><td>&nbsp;</td>
<% } %>
 --%>
<td>Dia</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>Projecte</td>
<td>Comentari</td>
</tr>
<%

List<QueEsticFentItem> llista;
for(int d=1; d <= maxDay; d++) {

 start.set(Calendar.DATE, d);
 int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
 

 boolean isCapDeSetmana = (dayOfWeek == Calendar.SUNDAY) || (dayOfWeek == Calendar.SATURDAY);
 //llista = itemsByDate.get(d);
 llista = itemsByDate.get(start.getTime());
 String rowbgcolor = null;
 if (isCapDeSetmana) {
   rowbgcolor = "cccccc";
 } else {
   if ((llista == null || llista.size() ==0) && start.compareTo(yesterday) == -1) {
     rowbgcolor = "ff0000";
   }
 }
 
%>
<tr <%=(rowbgcolor == null)? "" : ("bgcolor=\"#" + rowbgcolor + "\"")%> >
<td><%=start.get(Calendar.DAY_OF_MONTH)%></td>
<td onmouseover="toolTip('<%=Utils.diesFull[dayOfWeek] %>', this)" ><%=Utils.dies[dayOfWeek] %></td>
<%
   String novaAccioURL ="new?usuariID=" + usuariID 
             + "&data=" 
             + URLEncoder.encode(getSimpleDateTimeFormat().format(start.getTime()))
             + ((projecteID == null)? "": ("&projecteID=" + projecteID))
             + "&redirectUrl=" + redirectUrl;
   


%>
<td align="center">
 <% if (!isCapDeSetmana) { 
 /*
   String msg = "Aquesta funcionalitat ha sigut deprecada. La finalitat de QueEsticFentOTAE"
        + " no �s la de substituir el cl�ssic QueEsticFent, per la qual cosa totes les" 
        + " entrades haurien d'apareixer dins el QueEsticFent. Si ens hem oblidat una entrada"
        + " al QueEsticFent les passes a seguir s�n les seg�ents:\\n "
        + "(a) Anar a QueEsticFent de l'ibit (ov3.ibit.org) i afegir una entrada  del tipus  [PROJECTE]: (DATA)  [COMENTARI], per exemple OTAE12: (21/02/2012) He fet aix� i all�.\\n"
        + "(b) Anar a QueEsticFentOTAE  (http://192.168.35.151/queesticfentotae/) i a l'entrada anterior li aplicarem un canvi de tipus [Canvi de Data].\\n"
        + "(c) En la pantalla que ens apareixer�, canviar la data per la data entre par�ntesis i polsar OK.\\n"
        + "(d) Per millorar la visualitzaci� de l'entrada el que farem ser� un canvi de text de la data entre par�ntesis per buit. Per aix� tornarem a l'entrada canviada de data i li triarem un canvi de tipus [Canvi de text].\\n"
        + "(e) En la pantalla que apareix, en Dada1 afegir la data entre par�ntesis i en Dada2 deixar-ho buit. Donar-li al OK.\\n";
   msg = msg.replace('\'', '`');
   */
 %>
 <%-- <%=novaAccioURL%>&accioID=<%=Utils.ACCIO_NOVA_ENTRADA%> --%>
 <%--  <a href="javascript:alert('<%=msg%>')"> --%>
        <a href="<%=novaAccioURL%>&accioID=<%=Utils.ACCIO_NOVA_ENTRADA%>"> 
        <img onmouseover="toolTip('Afegir Nova Entrada', this)" src="<c:url value="/img"/>/add.gif">
   </a>
 <% } %>
</td>
<td align="center">
 <% if (!isCapDeSetmana) { %>
   <a href="<%=novaAccioURL%>&accioID=<%=Utils.ACCIO_VACANCES%>">
        <img onmouseover="toolTip('Marcar de vacances', this)" src="<c:url value="/img/add2.gif"/>">
   </a>
 <% } %>
</td>


<%-- COLUMNA DE PROJECTE --%>
<td>
<% if (llista == null) { %>
   &nbsp;
<% } else { %> 
  <table border=0 width="100%" height="100%" cellpadding="0" cellspacing="0">
  <%
  String topBorder = "";
  String bgColor;
  String projectName="";

  for (QueEsticFentItem qefi : llista) {
    List<ModificacioItem> modificacions = qefi.getModificacions(); 
    if (modificacions.size() == 0) {
      bgColor = "";  
    } else {
      if(qefi.getModificacions().get(0).getAccio().getAccioID() != Utils.ACCIO_FESTIU && qefi.getModificacions().get(0).getAccio().getAccioID() != Utils.ACCIO_VACANCES){
          projectName = projectesMap.get(modificacions.get(0).getModificacio().getProjecteID());
      }else{
          projectName = "&nbsp";
      }
      if (modificacions.size() == 1) {
        ModificacioItem mi = modificacions.get(0);
        bgColor = "bgcolor=\"#" + mi.getAccio().getColor() +"\"";        
      } else {
        bgColor = "bgcolor=\"#ffff00\"";
      }
    }
    
%>
    <tr <%=bgColor %> >
       <td <%=topBorder%> width="100%" height="100%">
         <%= projectName %>
       </td>
    </tr>   
<% 
    if (topBorder.length() == 0) {
       topBorder = " style=\"border-top-style: solid; border-top-width: 1px;\""; 
    }
   } %>
  </table> 
<% } %>

</td>

<%-- FI DE LA COLUMNA DE PROJECTE --%>

<td>
<% if (llista == null) { %>
   &nbsp;
<% } else { %> 
  <table border=0 width="100%" height="100%" cellpadding="0" cellspacing="0">
  <%
  String topBorder = "";
  String bgColor;
  for (QueEsticFentItem qefi : llista) {
    List<ModificacioItem> modificacions = qefi.getModificacions(); 
    if (modificacions.size() != 0) {
      
    }
    if (modificacions.size() == 0) {
      bgColor = "";  
    } else {
      if (qefi.getModificacioItemByAccioType(Utils.ACCIO_AMAGAR_ENTRADA) != null && !mostrarEntradesAmagades) {
        continue;
      }
      if (modificacions.size() == 1) {
        ModificacioItem mi = modificacions.get(0);
        bgColor = "bgcolor=\"#" + mi.getAccio().getColor() +"\"";        
      } else {
        bgColor = "bgcolor=\"#ffff00\"";
      }
    }
    
    
%>
    <tr <%=bgColor %> >
       <td <%=topBorder%> width="100%" >
        <%= qefi.getDescripcio() %>
       </td>
       <td <%=topBorder%> align="right" valign="middle">
       
       
          <table border="0" cellspacing="0" cellpadding="0"><tr>
          
          <%--  Llista de canvis que puc borrar --%>
          <% if (modificacions.size() != 0) { 
               for(ModificacioItem mi : modificacions) {
                 ModificacionsQueEsticFent mod = mi.getModificacio();
                 if (mod != null) {
               %>
               <td style="padding-left:5px;">
<table cellpadding="0" cellspacing="0">
<tr><td>
             <a href="<%=mod.getModificacioID()%>/delete"  onmouseover="toolTip('Eliminar <%=mi.getAccio().getNomLlegenda().replace('\'','_')%>', this)" >
                 <img alt="Eliminar modificacio" src="<c:url value="/img"/>/delete_12x12.gif"/>
             </a>
</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>
              <a                      href="<%=mod.getModificacioID()%>/edit" onmouseover="toolTip('Editar <%=mi.getAccio().getNomLlegenda().replace('\'','_')%>', this)" >
                 <img alt="Editar modificacio" src="<c:url value="/img"/>/link.gif"/>
             </a>
</td></tr></table>
             </td>
              <% }
              }
            
           %>
         
         <td valign="middle">          
          <%--  Llista de canvis que puc aplicar --%>
          <%--
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <% { %>
            <select style="font-size:100%"  onchange="document.location='<%=novaAccioURL%>&accioID=' + this.options[this.selectedIndex].value" name="select<%=qefi.hashCode()%>">
               <option value="" >- Fer canvi -</option>
            <% 
              for (int i = 0; i < allAccions.size(); i++) { %><%
                
                long accioID = allAccions.get(i).getAccioId();
                if (qefi.getModificacioItemByAccioType((int) accioID) != null) {
                  // No el mostram
                  continue;
                }
                  
                Object _obj_;
                StringBuffer values_accioID = new StringBuffer();
                _obj_ = allAccions.get(i).getNom();
                if(_obj_ != null) {
                  values_accioID.append(_obj_);
                }
            %>
               <option value="<%=allAccions.get(i).getAccioId()%>"  ><%= values_accioID.length() < 51 ? values_accioID : (values_accioID.substring(0,50) + " ...") %></option>
           <% } %>
            </select>
           <% } %>   --%>
          </td></tr></table>
          <% } %>
       </td>
    </tr>   
<% 
    if (topBorder.length() == 0) {
       topBorder = " style=\"border-top-style: solid; border-top-width: 1px;\""; 
    }
   } %>
  </table> 
<% } %>

</td>
</tr>
<% } %>

</tbody>
</table>


</td>
</tr>
</table>

<%
  // ========== LLEGENDA COLOR ===========
    
  

  

  int counter =0;
  %>
    <table border="0">
   <tr>
  <% 
    
    counter = -1;
    for(Accions lleg : actions) {
      counter ++;
      
      if (counter > 0 && counter % 4 == 0) {
        %>
        </tr><tr>
        <%
      }      
     %>
       <td>
          <table border="0">
          <tr>
          <td width="17" height="17" style="border-style:solid; border-width:1px; background-color:#<%=lleg.getColor()%>"></td>
          <td style="font-size:11"><b><%=lleg.getNomLlegenda()%></b></td>
          </tr>
          </table>
       </td>
     <% } %>
   </tr>  
   </table>

</div>

</td></tr>
</table>


</body>
</html>
