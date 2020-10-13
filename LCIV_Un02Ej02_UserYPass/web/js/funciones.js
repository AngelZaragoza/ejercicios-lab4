
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
    let formulario = document.getElementById("formulario");
    formulario.addEventListener("submit",validaPrevent);

}

//Esta función muestra alertas con textos de validación
function validarUP () {
    let user = document.getElementsByName("user")[0];
    let pass = document.getElementsByName("pass")[0];
    
    if (user.value.length == 0) {
        alert('Debe ingresar un Nombre de Usuario');
        if (document.getElementsByTagName())
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

//Esta función llama a otra en caso de que las validaciones fallen
function validarForm () {
    let user = document.getElementsByName("user")[0];
    let pass = document.getElementsByName("pass")[0];
    let valida = 1;
    
    document.getElementById("lista").innerHTML = "";
    
    if (user.value.length == 0) {
        textoValidacion("Debe ingresar un Nombre de Usuario");        
        valida -= 1;
    }
    
    if (pass.value.length == 0) {
        textoValidacion("Debe ingresar un Password");        
        valida -= 2;
    }
    
    //Si cualquiera de los dos if anteriores da true, el sgte. if retorna false
    
    if (valida == -1) {
        pass.focus();
        return false;
    } else if (valida <= 0) {
        user.focus();
        return false;
    }

    if (user.value == "tecni" && pass.value == "laboratorio") {
        alert('Sesión iniciada con éxito!');        
    } else {
        textoValidacion("Usuario o Password incorrecto");
        user.focus();
        return false;
    }
    
    return true;
}

//Esta función inserta elementos en una lista con textos de validación
function textoValidacion(texto) {
    let elemento = document.createElement("li");
    let nodo = document.createTextNode(texto);
    let padre = document.getElementById("lista");
    
    elemento.appendChild(nodo);
    padre.appendChild(elemento);
}

function validaPrevent(e) {
    let formulario = document.getElementById("formulario");
    let user = document.getElementById("user");
    let pass = document.getElementById("pass");

    document.getElementById("lista").innerHTML = "";

    let validarUser = function(e) {
        if (user.value == "") {            
            textoValidacion("Debe ingresar un Nombre de Usuario");
            e.preventDefault();
        }
    };

    let validarPass = function(e) {
        if (pass.value == "") {
            textoValidacion("Debe ingresar un Password");
            e.preventDefault();
        }
    };
    
    validarUser(e);
    validarPass(e);    
    
    // formulario.addEventListener("submit",chequear);
}