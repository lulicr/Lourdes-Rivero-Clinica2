window.addEventListener('load', function() {

    (function(){

        fetch("http://localhost:8080/pacientes/", {
            method: "GET"

        })
        .then(response => response.json())
        .then(formData => {
            for(paciente of formData){
                let table = document.getElementById("paciente_table");
                let pacienteRow = table.insertRow();
                let tr_id = 'tr_' + paciente.id;
                pacienteRow.id = tr_id;

                let deleteButton = '<button ' +
                                        'id=' + '\"' + 'btn_delete_' + paciente.id + '\"'+
                                        'type="button" onclick="deleteBy('+ paciente.id +')" class="btn btn-danger">' +
                                        '&times;' +
                                    '</button>';
                let updateButton = '<button ' +
                                        'id=' + '\"' + 'btn_id_' + paciente.id + '\"'+
                                        'type="button" onclick="findBy('+ paciente.id +')" class="btn btn-info btn-primary">' +
                                        paciente.id +
                                    '</button>';
                pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso + '</td>' +
                '<td class=\"td_calle\">' + paciente.domicilios.calle + '</td>' +
                '<td class=\"td_nro\">' + paciente.domicilios.numero + '</td>' +
                '<td class=\"td_localidad\">' + paciente.domicilios.localidad + '</td>' +
                '<td class=\"td_provincia\">' + paciente.domicilios.provincia + '</td>' +
                '<td>' + deleteButton + '</td>';


            }

        });

    })();

});
