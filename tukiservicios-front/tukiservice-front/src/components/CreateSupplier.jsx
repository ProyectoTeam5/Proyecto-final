import React, { useState } from 'react'
import { createNewSupplier } from '../services/SuppliersService'

export default function CreateSupplier() {

    const [supplierName, setSupplierName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [contactNumber, setContactNumber] = useState(0)

    // const [perfil, setPerfil] = useState("")
    // const [curriculum, setCurriculum] = useState("")


    // const [electricista, setElectricista] = useState("")
    // const [plomero, setPlomero] = useState("")
    // const [gasista, setGasista] = useState("")

    // const [status, setStatus] = useState("")

    function saveSupplier(event) {
        event.preventDefault(event)

        const newSupplier = {
            supplierName,
            email,
            password,
            contactNumber


        }
        createNewSupplier(newSupplier)
    }

    return (
        <div>
            Registrar Proveedor
            <hr />
            <div className="container">
                <div className="d-flex justify-content-start">
                    <div className="mb-3" >
                        <form onSubmit={(evento) => saveSupplier(evento)}>
                            <input className="form-control" type="text" value={supplierName} onChange={(event) => setSupplierName(event.target.value)} placeholder='nombre' />
                            <input className="form-control" type="text" value={email} onChange={(event) => setEmail(event.target.value)} placeholder='email' />
                            <input className="form-control" type="password" value={password} onChange={(event) => setPassword(event.target.value)} placeholder='password' minLength="8" required />
                            <input className="form-control" type="number" value={contactNumber} onChange={(event) => setContactNumber(event.target.value)} placeholder='Teléfono' />


                            <br />
                            <div className="mb-3">
                                <label for="formFile" class="form-label" >Imagen de perfil</label>
                                <input className="form-control" type="file" id="formFile" />
                            </div>

                            <div className="mb-3">
                                <label for="formFile" class="form-label" >Cargar Currículum</label>
                                <input className="form-control" type="file" id="formFile" />
                            </div>

                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" >
                                    Profesión
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a className="dropdown-item" href="#">Electricista</a></li>
                                    <li><a className="dropdown-item" href="#">Plomero</a></li>
                                    <li><a className="dropdown-item" href="#">Gasista</a></li>
                                </ul>
                            </div>
                            <br />
                            <div class="dropdown">
                                <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Status
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a className="dropdown-item" href="#">Ocupado</a></li>
                                    <li><a className="dropdown-item" href="#">Disponible</a></li>
                                    <li><a className="dropdown-item" href="#">Diponible en 48 hs.</a></li>
                                </ul>
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
