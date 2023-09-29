<%@page import="org.springframework.security.core.Authentication"
%><%@page import="org.springframework.context.i18n.LocaleContextHolder"
%><%@ page language="java" 
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp" 
%>
<div class="clear"></div>
<div class="spacer"></div>

<div>
<br/>
<center>
<img src="<c:url value="/img/app-logo.png"/>"  alt="queesticfent" title="queesticfent"/>

<br/>
<br/>

QueEsticFent és una Aplicació desenvolupada pel Departament de Govern Digital de la Fundació Bit <br/>
per gestionar ls tasques realitzades en els diferents projectes de desenvolupament<br/>
 i gestió que es duen a terme en aquest departament.

<br/>
<br/>
<table border="0" >
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign="top">
<a href="http://blog.fundaciobit.org/category/admindigital/" target="_blank">
<img src="<c:url value="/img/fundaciobit.png"/>"  alt="FundaciÃ³ Bit" title="FundaciÃ³ Bit"/>
</a>
</td>
</tr>
</table>
<br/>
</center>
 
</div>

<br/>


<c:if test="${qef:isDesenvolupament()}">
Only in Development Mode

LOGIN ANONIM <br/>
Locale = <%=LocaleContextHolder.getLocale() %> <br/>
lang = ${lang} <br/>
<br/>
</c:if>
