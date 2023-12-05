import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { createNewUser } from '../services/UsersService';
import { useNavigate } from 'react-router-dom'

function CreateUser() {

    const [address, setAddress] = useState(["CHACRASDECORIAO_ESTE"]);
    const navigate = useNavigate();
    const direcVal = ({ target }) => {

        const { value } = target;
        console.log(value);
        if (value == "CHACRASDECORIAO_ESTE") {
            setAddress(["CHACRASDECORIAO_ESTE"])
        } if (value == "CHACRASDECORIA_NORTE") {
            setAddress(["CHACRASDECORIA_NORTE"])
        }
        if (value == "CHACRASDECORIA_SUR") {
            setAddress(["CHACRASDECORIA_SUR"])
        }
    }


    const [registroData, setRegistroData] = useState({
        name: '',
        email: '',
        password: '',
        repeatPassword: '',

        "roles": ["USER"]
    });

    const { name, email, password, repeatPassword } = registroData

    const [registroExitoso, setRegistroExitoso] = useState(false);
    const [errorRegistro, setErrorRegistro] = useState(null);
    const [validationMessage, setValidationMessage] = useState('');
    const [showPassword, setShowPassword] = useState(false);

    const handleChange = ({ target }) => {
        const { id, value } = target;
        console.log(id, value)

        setRegistroData({ ...registroData, [id]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const NewUser = { name, email, password, address, roles: ["USER"] }
        navigate("/listaUser")
        try {
            // Validaciones del formulario...
            await createNewUser(NewUser)


            if (
                !name ||
                !email ||
                !password ||
                !repeatPassword
            ) {
                throw new Error('Completa todos los campos.');
            }

            if (registroData.password !== registroData.repeatPassword) {
                throw new Error('Las contraseñas no coinciden.');
            }

            // Simulación de éxito
            setRegistroExitoso(true);
            setErrorRegistro(null);
            setValidationMessage('');

            // Limpiar el formulario después del registro exitoso
            setRegistroData({
                name: '',
                email: '',
                password: '',
                repeatPassword: '',
                address: '',
                roles: ["USER"]
            });
        } catch (error) {
            // Manejar errores de registro
            setRegistroExitoso(false);
            setErrorRegistro(error.message);
            setValidationMessage('');
        }
    };

    const toggleShowPassword = () => {
        setShowPassword(!showPassword);
    };

    return (
        <section className='hero3'>
            <div className="content2">
                <div className="mb-3" >

                    {registroExitoso ? (
                        <p>¡Registro exitoso! Redirigiendo a la página de inicio de sesión...</p>
                    ) : (
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label htmlFor="nombre">Nombre:</label>
                                <input className="form-control" type="text" id="name" name="name" value={name} onChange={handleChange} />
                            </div>

                            <div>
                                <label htmlFor="email">Email:</label>
                                <input className="form-control" type="email" id="email" name="email" value={email} onChange={handleChange} />
                            </div>

                                <label htmlFor="password">Contraseña:</label>
                            <div className='d-flex'>
                                <input className="form-control" type={showPassword ? 'text' : 'password'} id="password" name="password"
                                    value={password} onChange={handleChange}/> <button type="button" onClick={toggleShowPassword}>
                                    <i className="fas fa-eye p-1 ojo" ></i>
                               </button>
                                     
                            </div>

                            <div>
                                <label htmlFor="repeatPassword">Repetir Contraseña:</label>
                                <input className="form-control" type="password" id="repeatPassword" name="repeatPassword"
                                    value={repeatPassword} onChange={handleChange} />
                            </div>
                            <br />
                            <div className="col-md">
                                <div className="form-floating">
                                    <select className="form-select" aria-label="Floating label select example " onClick={(e) => direcVal(e)} >

                                        <option id={["CHACRASDECORIAO_ESTE"]} value={["CHACRASDECORIAO_ESTE"]}>Chacras de Coria ESTE</option>
                                        <option id={["CHACRASDECORIA_NORTE"]} value={["CHACRASDECORIA_NORTE"]} >Chacras de Coria NORTE</option>
                                        <option id={["CHACRASDECORIA_SUR"]} value={["CHACRASDECORIA_SUR"]}>Chacras de Coria SUR</option>
                                    </select>
                                    <label htmlFor="floatingSelectGrid">Dirección:</label>


                                </div>
                            </div>

                            <br />
                            <button type="submit" className="btn btn-success">Crear cuenta</button>
                        </form>
                    )}

                    {errorRegistro && <p>Error al registrar: {errorRegistro}</p>}
                    {validationMessage && <p>{validationMessage}</p>}

                    {registroExitoso && <Link to="/login" replace />}
                </div>
            </div>
        </section>
    );
}

export default CreateUser;
