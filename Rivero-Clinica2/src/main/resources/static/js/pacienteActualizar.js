

window.addEventListener('load',function() {

    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function(event){

        const formData = {
                    id: document.querySelector('#paciente_id').value,
                    nombre: document.querySelector('#nombre').value,
                    apellido: document.querySelector('#apellido').value,
                    dni: document.querySelector('#dni').value,
                    fechaIngreso: document.querySelector('#fechaIngreso').value,
                                              domicilios:{
                                              calle: document.querySelector('#calle').value,
                                              numero: document.querySelector('#nro').value,
                                              localidad: document.querySelector('#localidad').value,
                                              provincia: document.querySelector('#provincia').value
                                              }
        };



        fetch("http://localhost:8080/pacientes/", {
                    method: "PUT",
                    headers: {"Content-Type": "application/json",},
                    body: JSON.stringify(formData),
                    })
            .then((response) => response.json())
            .catch((error) => {
                            console.error("Error:", error);
                        });
    })

})










function findBy(id) {
    fetch('http://localhost:8080/pacientes' + "/" + id, {
        method: "GET"
    })
    .then((response) => response.json())
    .then((data) => {
        let paciente = data;
        document.querySelector('#paciente_id').value = paciente.id;
        document.querySelector('#nombre').value = paciente.nombre;
        document.querySelector('#apellido').value = paciente.apellido;
        document.querySelector('#dni').value = paciente.dni;
        document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
        document.querySelector('#calle').value = paciente.domicilios.calle;
        document.querySelector('#nro').value = paciente.domicilios.numero;
        document.querySelector('#localidad').value = paciente.domicilios.localidad;
        document.querySelector('#provincia').value = paciente.domicilios.provincia;
        document.querySelector('#div_paciente_updating').style.display = "block";
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}



