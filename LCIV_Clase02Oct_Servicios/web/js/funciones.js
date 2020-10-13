
function saludo() {
    let fecha = new Date();
    let hora = fecha.getHours();
    let texto = "";

    if (hora >= 5 && hora <= 12) {
        texto = "Buenos días";
    } else if (hora > 12 && hora < 20) {
        texto = "Buenas tardes";
    } else {
        texto = "Buenas noches";
    }
    document.getElementById("saludo").innerHTML = texto;
}

function validar() {
    let usr = document.getElementById("user").value;
    let pass = document.getElementById("pass").value;
    document.getElementsByTagName("form")[0].addEventListener("click", function(event) {
       event.preventDefault() 
    });
    
    if (usr == "") {
        alert('Usuario');
        e.preventDefault();
    }
    if (pass == "") {    
        alert('Password');
        e.preventDefault();
        
    }
}