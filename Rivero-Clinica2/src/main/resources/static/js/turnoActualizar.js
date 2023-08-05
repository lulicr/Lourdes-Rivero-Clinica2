window.addEventListener('load',function() {

    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function(event){

        const formData = {
            id: document.querySelector('#turno_id').value,
            fecha: document.querySelector('#fecha').value,
            paciente: {
                id: document.querySelector('#paciente_id').value,
                nombre: document.querySelector('#paciente_nombre').value,
                apellido: document.querySelector('#paciente_apellido').value,
                dni: document.querySelector('#dni').value,
                fechaIngreso: document.querySelector('#fechaIngreso').value,
                domicilios: {
                    id: document.querySelector('#domicilio_id').value,
                    calle: document.querySelector('#calle').value,
                    numero: document.querySelector('#nro').value,
                    localidad: document.querySelector('#localidad').value,
                    provincia: document.querySelector('#provincia').value,
                }
            },
            odontologo: {
                id: document.querySelector('#odontologo_id').value,
                nombre: document.querySelector('#odontologo_nombre').value,
                apellido: document.querySelector('#odontologo_apellido').value,
                numeroMatricula: document.querySelector('#matricula').value,
                }
            };



        fetch("http://localhost:8080/turnos/", {
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
    fetch('http://localhost:8080/turnos'+"/"+ id, {
        method: "GET"
    })
    .then((response) => response.json())
    .then((data) => {
        let turno = data;
        document.querySelector('#turno_id').value= turno.id;
        document.querySelector('#fecha').value = turno.fecha;

        document.querySelector('#paciente_id').value = turno.paciente.id;
        document.querySelector('#paciente_nombre').value = turno.paciente.nombre;
        document.querySelector('#paciente_apellido').value = turno.paciente.apellido;
        document.querySelector('#fechaIngreso').value = turno.paciente.fechaIngreso;
        document.querySelector('#dni').value = turno.paciente.dni;

        document.querySelector('#domicilio_id').value = turno.paciente.domicilios.id;
        document.querySelector('#calle').value = turno.paciente.domicilios.calle;
        document.querySelector('#nro').value = turno.paciente.domicilios.numero;
        document.querySelector('#localidad').value = turno.paciente.domicilios.localidad;
        document.querySelector('#provincia').value = turno.paciente.domicilios.provincia;
        
        document.querySelector('#odontologo_id').value = turno.odontologo.id;
        document.querySelector('#odontologo_nombre').value = turno.odontologo.nombre;
        document.querySelector('#odontologo_apellido').value = turno.odontologo.apellido;
        document.querySelector('#matricula').value = turno.odontologo.numeroMatricula;

        document.querySelector('#div_turno_updating').style.display = "block";
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}



