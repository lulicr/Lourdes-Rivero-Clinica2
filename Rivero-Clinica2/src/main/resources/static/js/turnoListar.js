window.addEventListener('load', function() {

    (function(){

        fetch("http://localhost:8080/turnos/", {
            method: "GET"

        })
        .then(response => response.json())
        .then(formData => {
            for(turno of formData){
                let table = document.getElementById("turno_table");
                let turnoRow = table.insertRow();
                let tr_id = 'tr_' + turno.id;
                turnoRow.id = tr_id;

                let deleteButton = '<button ' +
                                        'id=' + '\"' + 'btn_delete_' + turno.id + '\"'+
                                        'type="button" onclick="deleteBy('+ turno.id +')" class="btn btn-danger">' +
                                        '&times;' +
                                    '</button>';
                let updateButton = '<button ' +
                                        'id=' + '\"' + 'btn_id_' + turno.id + '\"'+
                                        'type="button" onclick="findBy('+ turno.id +')" class="btn btn-info btn-primary">' +
                                        turno.id +
                                    '</button>';
                turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                '<td class=\"td_fecha\">' + turno.fecha + '</td>' +

                '<td class=\"td_paciente_id\">' + turno.paciente.id + '</td>' +
                '<td class=\"td_nombre\">' + turno.paciente.nombre.toUpperCase() + '</td>' +
                '<td class=\"td_apellido\">' + turno.paciente.apellido.toUpperCase() + '</td>' +
                '<td class=\"td_dni\">' + turno.paciente.dni + '</td>' +
                '<td class=\"td_fechaIngreso\">' + turno.paciente.fechaIngreso + '</td>' +

                '<td class=\"td_domicilios_id\">' + turno.paciente.domicilios.id + '</td>' +
                '<td class=\"td_calle\">' + turno.paciente.domicilios.calle.toUpperCase() + '</td>' +
                '<td class=\"td_nro\">' + turno.paciente.domicilios.numero + '</td>' +
                '<td class=\"td_localidad\">' + turno.paciente.domicilios.localidad.toUpperCase() + '</td>' +
                '<td class=\"td_provincia\">' + turno.paciente.domicilios.provincia.toUpperCase() + '</td>' +

                '<td class=\"td_odontologo_id\">' + turno.odontologo.id + '</td>' +
                '<td class=\"td_nombre\">' + turno.odontologo.nombre.toUpperCase().toUpperCase() + '</td>' +
                '<td class=\"td_apellido\">' + turno.odontologo.apellido.toUpperCase() + '</td>' +
                '<td class=\"td_matricula\">' + turno.odontologo.numeroMatricula + '</td>' +
                
                '<td>' + deleteButton + '</td>';


            }

        });

    })();

});
