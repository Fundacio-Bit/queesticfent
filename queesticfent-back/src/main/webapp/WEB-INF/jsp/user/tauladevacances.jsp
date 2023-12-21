<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<style>
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    overflow: auto;
}

th, td {
    border: 1px solid #ddd;
    padding: 3px;
    text-align: center;
    white-space: nowrap;
}

th {
    background-color: #f2f2f2;
    position: -webkit-sticky;
    position: sticky;
    top: 0;
    z-index: 2;
}

td:first-child, th:first-child {
    position: -webkit-sticky;
    position: sticky;
    left: 0;
    background-color: #f2f2f2;
    z-index: 1;
}
</style>


<h1>Calendari de Vacances</h1>

<c:forEach items="${vacancesmesos}" var="vacancesmes">

    

    <table>
        <thead>
            <tr >
                <th colspan="${vacancesmes.numberofdays + 1}"><center><h4>${vacancesmes.anyo}- ${vacancesmes.mesnom}</h4></center></th>
            </tr>
            
            <tr>
                <th>Nom</th>
                <c:forEach begin="1" end="${vacancesmes.numberofdays}" var="day">
                    <th>${day}</th>
                </c:forEach>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${persones}" var="persona">
                <tr>
                    <c:set var="personainfo" value="${vacancesmes.personesMap[persona.username]}" />
                    <td>${persona.nom}</td>
                    
                    <c:forEach begin="1" end="${vacancesmes.numberofdays}" var="day">
                    <c:choose>
                      <c:when test="${ vacancesmes.festius.get(day)}">
                              <td width="3%" style="background-image:url(<c:url value="/img/festiu.jpg"/>);background-repeat:repeat;">   
                               
                      </c:when>
                      <c:when test="${ vacancesmes.capdesetmanes.get(day)}">
                               <td width="3%" bgcolor="#F1F1F1">  &nbsp;                  
                               </td>
                      </c:when>
                      <c:when test="${empty personainfo}"><td width="3%">&nbsp;</td></c:when>
                      <c:when test="${personainfo.vacances.get(day)}">
                      
                         <td width="3%" bgcolor="${persona.color}">&nbsp;</td>
                      
                      </c:when>
                      
                      <c:otherwise><td width="3%"></td></c:otherwise>
                    
                    </c:choose>
                    </c:forEach>
                    <%--
                    <c:if test="${ not empty personainfo}">
                       
                           <c:if test="${ vacancesmes.festius.get(day)}">
                                                      
                               <td style="background-image:url(<c:url value="/img/festiu.jpg"/>);background-repeat:no-repeat;">                         
                               </td>
                           </c:if>
                        
                           <c:if test="${not vacancesmes.festius.get(day)}">
                        
                                <td bgcolor="${personainfo.vacances.get(day)?persona.color:'white'}">&nbsp;</td>
                            </c:if>
                       </c:forEach>
                    </c:if>
                    <c:if test="${ empty personainfo}">
                        <c:forEach begin="1" end="${vacancesmes.numberofdays}" var="day">
                            <c:if test="${ vacancesmes.festius.get(day)}">
                                                      
                               <td style="background-image:url(<c:url value="/img/festiu.jpg"/>);background-repeat:no-repeat;">                         
                               </td>
                           </c:if>
                        
                           <c:if test="${not vacancesmes.festius.get(day)}">
                            <td>&nbsp;</td>
                            </c:if>
                        </c:forEach>
                    </c:if>
                     --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br/>

</c:forEach>

