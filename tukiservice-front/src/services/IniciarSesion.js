export async function iniciarSesion(datos) {
    const response = await fetch('http://localhost:8080/api/login',{
        method: 'POST',
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })

    const result = await response.text();
    console.log(result);
    if(result == 'OK'){
        console.log(result);
        window.location.href = ("/")

    }else{
        alert("Las credenciales son incorrectas");
    }
}