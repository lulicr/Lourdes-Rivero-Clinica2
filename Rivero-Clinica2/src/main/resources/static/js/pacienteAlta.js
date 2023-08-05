window.addEventListener('load', function() {

    const formulario = document.querySelector('#add_new_paciente');

    const date = new Date();
    const [month, day, year] = [date.getMonth(), date.getDate(), date.getFullYear()];


    formulario.addEventListener('submit',function(event){

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: date,
                domicilios:{
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#nro').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value
            }


        };
        fetch("http://localhost:8080/pacientes/", {
                method: "POST",
                headers: {"Content-Type": "application/json",},
                body: JSON.stringify(formData),
            })
            .then((response) => response.json())
            .then((formData) => {
                console.log("Success:", formData);
            })
            .catch((error) => {
                console.error("Error:", error);
            });

    function resetUploadForm() {
        document.querySelector('#nombre').value ="";
        document.querySelector('#apellido').value="";
        document.querySelector('#dni').value;

    }
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacienteLista.html"){
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
        }
    )


}
)
})
