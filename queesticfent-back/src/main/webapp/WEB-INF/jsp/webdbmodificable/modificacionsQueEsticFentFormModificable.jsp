<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

<div id="botonsrapids" style="display: none;" class="row">
    <div class="row">
        <input id="preferit.boto.1" type="button" class="btn btn-warning" style="display: none" onclick="setCategoria(1)" value="Temporal" />&nbsp;&nbsp;
        <input id="preferit.boto.2" type="button" class="btn btn-warning" style="display: none" onclick="setCategoria(2)" value="Temporal" />&nbsp;&nbsp;
        <input id="preferit.boto.3" type="button" class="btn btn-warning" style="display: none" onclick="setCategoria(3)" value="Temporal" />&nbsp;&nbsp;
        <input id="preferit.boto.4" type="button" class="btn btn-warning" style="display: none" onclick="setCategoria(4)" value="Temporal" />&nbsp;&nbsp;
        <input id="preferit.boto.5" type="button" class="btn btn-warning" style="display: none" onclick="setCategoria(5)" value="Temporal" />&nbsp;&nbsp;
    </div>
</div>


<script type="text/javascript">
    $(document).ready(
            function() {

                document.getElementById('modificacionsQueEsticFent_projecteID_columnvalueid').innerHTML += document
                        .getElementById('botonsrapids').innerHTML;

                for (var i = 1; i < 6; i++) {
                    if (getCookie("preferit.cookie.value." + i) != null) {
                        var boto = document.getElementById("preferit.boto." + i);
                        boto.value = getCookie("preferit.cookie.label." + i);
                        boto.style.display = "block";

                        if (i == 1) {
                            setCategoria(1);
                        }

                    }
                }

            });

    function setCategoria(categoria) {

        var projecteID = getCookie("preferit.cookie.value." + categoria);

        // posar el valor projecteId al combobox comboProjecteID
        document.getElementById("modificacionsQueEsticFent_projecteID").value = projecteID;
    }

    function setCookie(name, value, days) {
        var expires = "";
        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + value + expires + "; path=/";
    }

    function getCookie(name) {
        var nameEQ = name + "=";
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i];
            while (cookie.charAt(0) === ' ') {
                cookie = cookie.substring(1, cookie.length);
            }
            if (cookie.indexOf(nameEQ) === 0) {
                return cookie.substring(nameEQ.length, cookie.length);
            }
        }
        return null;
    }

    $("#modificacionsQueEsticFentForm").on("submit", function(event) {

        for (var i = 5; i > 1; i--) {
            var h = i - 1;
            if (getCookie("preferit.cookie.label." + h) != null) {

                var id = getCookie("preferit.cookie.value." + h);
                var lab = getCookie("preferit.cookie.label." + h);

                setCookie("preferit.cookie.value." + i, id, 300);
                setCookie("preferit.cookie.label." + i, lab, 300);
            }
        }

        var combo = document.getElementById("modificacionsQueEsticFent_projecteID");
        var projecteID = combo.value;
        // get label of combobox modificacionsQueEsticFent_projecteID
        var projecteNom = combo.options[combo.selectedIndex].text;

        setCookie("preferit.cookie.value.1", projecteID, 300);
        setCookie("preferit.cookie.label.1", projecteNom, 300);

    });
</script>