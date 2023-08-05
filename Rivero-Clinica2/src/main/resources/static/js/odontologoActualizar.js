window.addEventListener('load',function() {

    const formulario = document.querySelector('#update_odontologo_form');
    formulario.addEventListener('submit', function(event){

        const formData = {
                    id: document.querySelector('#odontologo_id').value,
                    nombre: document.querySelector('#nombre').value,
                    apellido: document.querySelector('#apellido').value,
                    numeroMatricula: document.querySelector('#matricula').value,
        };



        fetch("http://localhost:8080/odontologos/", {
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
    fetch('http://localhost:8080/odontologos'+"/"+ id, {
        method: "GET"
    })
    .then((response) => response.json())
    .then((data) => {
        let odontologo = data;
        document.querySelector('#odontologo_id').value = odontologo.id;
        document.querySelector('#nombre').value = odontologo.nombre;
        document.querySelector('#apellido').value = odontologo.apellido;
        document.querySelector('#matricula').value = odontologo.numeroMatricula;

        document.querySelector('#div_odontologo_updating').style.display = "block";
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}




