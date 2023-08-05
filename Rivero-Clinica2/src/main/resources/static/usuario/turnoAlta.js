let odontologoSelect;
let pacienteSelect;

window.addEventListener('load', function() {
    pacienteSelect = document.getElementById('paciente_id');
    odontologoSelect = document.getElementById('odontologo_select');

    fetch('http://localhost:8080/pacientes/',{
        method: "GET"
    })
    .then(response => response.json())
    .catch(error => console.error(error));

    fetch('http://localhost:8080/odontologos/',{
        method: "GET"
    })
    .then(response => response.json())
    .then(data => {
        for (const odontologo of data) {
            const option = document.createElement('option');
            option.value = odontologo.id;
            option.textContent = odontologo.nombre + ' ' + odontologo.apellido;
            document.getElementById('odontologo_select').appendChild(option);
        }
    })
    .catch(error => console.error(error));
});

window.addEventListener('load', function() {
    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function(event){
        event.preventDefault(); // Evitar que el formulario se envíe automáticamente

        const formData = {
            fecha: document.querySelector('#fecha').value,
            paciente: {
                id: document.querySelector('#paciente_id').value,
            },
            odontologo: {
                id: odontologoSelect.value,
            }
        };
        
        console.log(formData);

        fetch("http://localhost:8080/turnos/", {
            method: "POST",
            headers: {"Content-Type": "application/json",},
            body: JSON.stringify(formData),
        })
        .then((response) => {
            if (response.ok) {
                console.log("Turno creado exitosamente.");
                resetUploadForm();
            } else {
                console.error("Error en la creación del turno:", response.status);
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
    });

    function resetUploadForm() {
        document.querySelector('#paciente_id').value = "";
    }

    (function(){
        let pathname = location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").classList.add("active");
        } else if (pathname == "/pacienteLista.html"){
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();
});
