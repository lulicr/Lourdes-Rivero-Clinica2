window.addEventListener('load', function() {

    const formulario = document.querySelector('#add_new_odontologo');

    formulario.addEventListener('submit',function(event){

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            numeroMatricula: document.querySelector('#matricula').value,

        };
        fetch("http://localhost:8080/odontologos/", {
                method: "POST",
                headers: {"Content-Type": "application/json",},
                body: JSON.stringify(formData),
            })
            .then((response) => response.json())
            .then((formData) => {
                console.log("Success:", formData);
            })
            .then((formData) => {
                console.log("Success:", formData);
                resetForm();
            })
            .catch((error) => {
                console.error("Error:", error);
            });

    
        (function(){
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologoLista.html"){
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }}
        )


    })})

