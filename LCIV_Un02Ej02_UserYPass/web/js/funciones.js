
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

function validarUP () {
    let user = document.getElementsByName("user")[0];
    let pass = document.getElementsByName("pass")[0];
    
    if (user.value.length == 0) {
        alert('Debe ingresar un Nombre de Usuario');
        user.focus();
        return false;
    }
    
    if (pass.value.length == 0) {
        alert('Debe ingresar un Password');
        pass.focus();
        return false;
    }
    
    if (user.value == "tecni" && pass.value == "laboratorio") {
        alert('Sesión iniciada con éxito!');        
    } else {
        alert('Usuario o Password incorrecto');
        user.focus();
        return false;
    }
    
    return true;
}