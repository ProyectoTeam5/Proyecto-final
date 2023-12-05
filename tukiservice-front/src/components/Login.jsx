import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { iniciarSesion } from '../services/IniciarSesion';

{/*Eduardo hizo este formulario */ }

function Login() {
    const [loginData, setLoginData] = useState({
        email: '',
        password: '',
    });

    const login=async()=>{
        const usuarioLogins=({
            email,
            password
        });

        try{
            iniciarSesion(usuarioLogins);
        }catch(error){
            console.error(error);
        }
    }

    const{email,password} = loginData;


   const [validationMessage, setValidationMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setLoginData({ ...loginData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Validar que ambos campos estén llenos
        if (!loginData.email || !loginData.password) {
            setValidationMessage('Completa todos los campos');
            return;
        }

        // Lógica para procesar el formulario de inicio de sesión
        console.log('Datos del formulario de inicio de sesión:', loginData);

        // Limpiar el formulario después del inicio de sesión
        setLoginData({ email: '', password: '' });
        setValidationMessage('');
    };

    return (
        <section className='hero5'>
            <div className="content2">


                {validationMessage && <p>{validationMessage}</p>}

                <form onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="email">Correo electrónico:</label>
                        <input className="form-control" type="email" id="email" name="email" value={email} onChange={handleChange} />
                    </div>
                    <div>
                        <label htmlFor="password">Contraseña:</label>
                        <input className="form-control" type="password" id="password" name="password" value={password} onChange={handleChange} />
                    </div>
                    <br />
                    <button onClick={login} type="submit" className="btn btn-success">Iniciar Sesión</button>
                </form>
            </div>
        </section>
    );
}

export default Login;
