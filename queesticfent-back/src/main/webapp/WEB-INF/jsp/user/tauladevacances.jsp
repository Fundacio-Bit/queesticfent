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

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.10.4/dist/css/tempus-dominus.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">




<!-- Bootstrap 5 JS (amb Popper inclòs) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.10.4/dist/js/tempus-dominus.min.js"></script>

<script>
  const dateOnlyOptions = {
    display: {
      components: {
        calendar: true,
        date: true,
        month: true,
        year: true,
        decades: true,
        clock: false,
        hours: false,
        minutes: false,
        seconds: false
      }
    },
    defaultDate: null
  };



  let picker1, picker2;

  // Quan el modal s’obre
  const modal = document.getElementById('modalVacances');
  modal.addEventListener('shown.bs.modal', function () {
    // Inicialitza només si encara no existeixen
    if (!picker1) {
      picker1 = new tempusDominus.TempusDominus(document.getElementById('datetimepicker1'), options);
    }
    if (!picker2) {
      picker2 = new tempusDominus.TempusDominus(document.getElementById('datetimepicker2'), options);
    }
  });
  
</script>


<div class="d-flex justify-content-between align-items-center mb-3">
  <h1 class="mb-0">Calendari de Vacances</h1>
  <a
  class="btn btn-sm btn-success"
  href="#"
  data-bs-toggle="modal"
  data-bs-target="#modalVacances"
>
  Afegir vacances
</a>
</div>

<!-- Modal per introduir vacances -->
<div class="modal fade" id="modalVacances" tabindex="-1" aria-labelledby="modalVacancesLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form method="get" action="/queesticfent/user/vacances/afegirrangvacances/?">
        <div class="modal-header">
          <h5 class="modal-title" id="modalVacancesLabel">Afegir vacances</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Tanca"></button>
        </div>

        <div class="modal-body">
          <div class="mb-3">
            <label for="dataInici" class="form-label">Data d'inici</label>
            <input type="date" class="form-control" id="dataInici" name="dataInici" required>
          </div>

          <div class="mb-3">
            <label for="dataFi" class="form-label">Data de fi</label>
            <input type="date" class="form-control" id="dataFi" name="dataFi" required>
          </div>
        </div>
        
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Tanca</button>
          <button type="submit" class="btn btn-success">Desa</button>
        </div>
      </form>
    </div>
  </div>
</div>



<script type="text/javascript">
    new tempusDominus.TempusDominus(document.getElementById('datetimepicker1'));
    new tempusDominus.TempusDominus(document.getElementById('datetimepicker2'));
</script>

<c:forEach items="${vacancesmesos}" var="vacancesmes">

    

    <table class="table-bordered">
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

