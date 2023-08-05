window.addEventListener('load', function() {

    (function(){

        fetch("http://localhost:8080/odontologos/", {
            method: "GET"

        })
        .then(response => response.json())
        .then(formData => {
            for(odontologo of formData){
                let table = document.getElementById("odontologo_table");
                let odontologoRow = table.insertRow();
                let tr_id = 'tr_' + odontologo.id;
                odontologoRow.id = tr_id;

                let deleteButton = '<button ' +
                                        'id=' + '\"' + 'btn_delete_' + odontologo.id + '\"'+
                                        'type="button" onclick="deleteBy('+ odontologo.id +')" class="btn btn-danger">' +
                                        '&times;' +
                                    '</button>';
                let updateButton = '<button ' +
                                        'id=' + '\"' + 'btn_id_' + odontologo.id + '\"'+
                                        'type="button" onclick="findBy('+ odontologo.id +')" class="btn btn-info btn-primary">' +
                                        odontologo.id +
                                    '</button>';
                odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                '<td class=\"td_matricula\">' + odontologo.numeroMatricula + '</td>' +
                '<td>' + deleteButton + '</td>';


            }

        });

    })();

});
