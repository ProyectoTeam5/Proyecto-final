import React, { useState } from 'react'
import { createNewSupplier } from '../services/SuppliersService'
import { useNavigate } from 'react-router-dom'


export default function CreateSupplier() {

    const [supplierName, setSupplierName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [password2, setPassword2] = useState("")
    const [contactNumber, setContactNumber] = useState("")

    const [foto, setFoto] = useState("")
    const [resume, setResume] = useState("")


    const [electricista, setElectricista] = useState("")
    const [plomero, setPlomero] = useState("")
    const [gasista, setGasista] = useState("")

    const [status, setStatus] = useState("")

    // const[info,setInfo] = useState({
    //     name: '',
    //     lastname:'',
    //     email:'',
    //     age:''
    // });

    const navigate = useNavigate()

    async function saveSupplier(event) {
        event.preventDefault(event)

        const newSupplier = {
            supplierName,
            email,
            password,
            contactNumber


        }
        try {
            await createNewSupplier(newSupplier)
            navigate("/")
        } catch (error) {

        }

    }

    return (
        <div>
            Registrar Proveedor
            <hr />
            <div className="container">
                <div className="d-flex justify-content-start">
                    <div className="mb-3" >
                        <form onSubmit={(evento) => saveSupplier(evento)}>
                            <label htmlFor="nombre">Nombre</label>
                            <input className="form-control" type="text" value={supplierName}
                                onChange={(event) => setSupplierName(event.target.value)} placeholder='nombre' />
                            <label htmlFor="email">Email</label>
                            <input className="form-control" type="text" value={email}
                                onChange={(event) => setEmail(event.target.value)} placeholder='email' />
                            <label htmlFor="password">Contraseña</label>
                            <input className="form-control" type="password" value={password}
                                onChange={(event) => setPassword(event.target.value)} placeholder='contraseña' minLength="8" required />
                            <label htmlFor="password2">Repetir Contraseña</label>
                            <input className="form-control" type="password" value={password2}
                                onChange={(event) => setPassword2(event.target.value)} placeholder='repetir contraseña' minLength="8" required />
                            <label htmlFor="telefono">Teléfono</label>
                            <input className="form-control" type="number" value={contactNumber}
                                onChange={(event) => setContactNumber(event.target.value)} placeholder='Teléfono' />


                            <br />
                            <div className="mb-3">
                                <label htmlFor="imagen" className="form-label" >Imagen de perfil</label>
                                <input className="form-control" type="file" id="formFile" value={foto}
                                    onChange={(event) => setFoto(event.target.value)} placeholder='Imagen' />
                            </div>

                            <div className="mb-3">
                                <label htmlFor="curriculum" className="form-label" >Cargar Currículum</label>
                                <input className="form-control" type="file" id="formFile1" value={resume}
                                    onChange={(event) => setResume(event.target.value)} placeholder='Curriculum' />
                            </div>

                            <div className="dropdown">
                                {/* <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" >
                                    Profesión
                                </button>
                                <ul className="dropdown-menu">
                                    <li><a className="dropdown-item" value={electricista}
                                        onChange={(event) => setElectricista(event.target.value)} placeholder='Teléfono'>Electricista</a></li>
                                    <li><a className="dropdown-item" >Plomero</a></li>
                                    <li><a className="dropdown-item" >Gasista</a></li>
                                </ul> */}
                            </div>
                            <div className="col-md">
                                <div className="form-floating">
                                    <select className="form-select" id="floatingSelectGrid" aria-label="Floating label select example">

                                        <option value="1">Plomero</option>
                                        <option value="2">Gasista</option>
                                        <option value="3">Electricista</option>
                                    </select>
                                    <label htmlFor="floatingSelectGrid">Profesión:</label>


                                </div>
                            </div>
                            <br />
                            {/* <div className="dropdown">
                                <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Status
                                </button>
                                <ul className="dropdown-menu">
                                    <li><a className="dropdown-item" href="#">Ocupado</a></li>
                                    <li><a className="dropdown-item" href="#">Disponible</a></li>
                                    <li><a className="dropdown-item" href="#">Diponible en 48 hs.</a></li>
                                </ul>
                            </div> */}
                            <div className="col-md">
                                <div className="form-floating">
                                    <select className="form-select" id="floatingSelectGrid1" aria-label="Floating label select example">

                                        <option value="1">Disponible</option>
                                        <option value="2">Ocupado</option>
                                        <option value="3">En 48 hs.</option>
                                    </select>
                                    <label htmlFor="floatingSelectGrid1">Status:</label>
                                </div>
                            </div>

                            <br />
                            <button type="button" className="btn btn-success">Registrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}
