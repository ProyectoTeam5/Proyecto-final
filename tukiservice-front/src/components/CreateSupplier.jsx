import React, { useState } from 'react'
import { createNewSupplier } from '../services/SuppliersService'
import { useNavigate } from 'react-router-dom'


export default function CreateSupplier() {

    
    const[workStatus,setWorkStatus] = useState("DISPONIBLE");
    const[profession,setProf] = useState("PLOMERO");

    const profVal=({target})=>{

       const{value} = target;
       console.log(value);
       if(value == "PLOMERO"){
            setProf("PLOMERO")
       }if(value == "GASISTA"){
            setProf("GASISTA")
       }
       if(value == "ELECTRICISTA"){
            setProf("ELECTRICISTA")
       }
    }
    const profStatus=({target})=>{

       const{value} = target;
       console.log(value);
       if(value == "DISPONIBLE"){
        setWorkStatus("DISPONIBLE")
       }if(value == "OCUPADO"){
        setWorkStatus("OCUPADO")
       }
       if(value == "AUSENTE"){
        setWorkStatus("AUSENTE")
       }
    }

    const [info, setInfo] = useState({
        supplierName: '',
        email: '',
        password: '',
        password2: '',
        contactNumber: '',
        foto: '',
        resume: '',
        "roles": ["SUPPLIER"]    
    });
   

    const { supplierName, email, password, contactNumber, foto, resume, password2,roles } = info;



    const SaveData = ({ target }) => {
        const { id, value } = target;
        console.log(id,value)
        setInfo({
            ...info,
            [id]: value

        })
    }

    const navigate = useNavigate()

    async function saveSupplier(event) {
        event.preventDefault()

        const newSupplier = {
            supplierName,
            email,
            password,
            contactNumber,
            foto,
            resume,
            profession,
            workStatus,
            roles: ["SUPPLIER"]

        }
        try {

            
            if(password != password2){
                alert("Las contraseñas no coinciden.")
                return;
            }
            if(!email.includes("@") || !email.includes(".com")){
                alert("Correo electronico invalido.")
                return;
            }
            await createNewSupplier(newSupplier)
            console.log(newSupplier)
            navigate("/listaSuppliers")
        } catch (error) {

        }

    }

    return (
        <section className='hero3'>
            <div className="content2">
                <br /><br /><br />
                <div className="mb-3" >
                    <form onSubmit={saveSupplier}>
                        <label htmlFor="nombre">Nombre <span className='red'>* </span></label>
                        <input className="form-control" type="text" value={supplierName} id="supplierName"
                            onChange={SaveData} placeholder='nombre' />


                        <label htmlFor="email">Email <span className='red'>* </span></label>
                        <input className="form-control" type="email" value={email} id="email"
                            onChange={SaveData} placeholder='email' />


                        <label htmlFor="password">Contraseña <span className='red'>* </span></label>
                        <input className="form-control" type="password" value={password} id="password"
                            onChange={SaveData} placeholder='contraseña' minLength="8" required  />
                            


                        <label htmlFor="password2">Repetir Contraseña <span className='red'>* </span></label>
                        <input className="form-control" type="password" id="password2"
                            onChange={SaveData} placeholder='repetir contraseña' minLength="8" required value={password2}/>


                        <label htmlFor="telefono">Teléfono</label>
                        <input className="form-control" type="number" value={contactNumber} id="contactNumber"
                            onChange={SaveData} placeholder='Teléfono' />


                        <label htmlFor="foto">Imágen de Perfil</label>
                        <input className="form-control" type="foto" value={foto} id="foto"
                            onChange={SaveData} placeholder='xxxx' />


                        <label htmlFor="resume">Curriculum</label>
                        <input className="form-control" type="resume" value={resume} id="resume"
                            onChange={SaveData} placeholder='xxxx' />

                        <br />
                        {/* <br />
                        <div className="mb-3">
                            <label htmlFor="imagen" className="form-label" >Imagen de perfil</label>
                            <input className="form-control" type="file" id="formFile" value={foto}
                                onChange={(event) => setFoto(event.target.value)} placeholder='Imagen' />
                        </div> */}

                        {/* <div className="mb-3">
                            <label htmlFor="curriculum" className="form-label" >Cargar Currículum</label>
                            <input className="form-control" type="file" id="formFile1" value={resume}
                                onChange={(event) => setResume(event.target.value)} placeholder='Curriculum' />
                        </div> */}

                        <div className="dropdown">
                            {/* <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" 
                            ["PLOMERO"]}>
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
                         <select className="form-select"  aria-label="Floating label select example " onClick={(e)=>profStatus(e)} >
                    
                            <option id="DISPONIBLE" value="DISPONIBLE">Disponible</option>
                            <option id="OCUPADO" value="OCUPADO" >Ocupado</option>
                            <option  id="AUSENTE" value="AUSENTE">Ausente</option>
                        </select>
                         <label htmlFor="floatingSelectGrid">Status:</label>


                            </div>
                        </div>

                <div className="col-md">
                    <div className="form-floating">
                         <select className="form-select"  aria-label="Floating label select example " onClick={(e)=>profVal(e)} >
                    
                            <option id={"PLOMERO"} value={"PLOMERO"}>Plomero</option>
                            <option id={"GASISTA"} value={"GASISTA"} >Gasista</option>
                            <option  id={"ELECTRICISTA"} value={"ELECTRICISTA"}>Electricista</option>
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
                        {/* <div className="col-md">
                            <div className="form-floating">
                                <select className="form-select" id="floatingSelectGrid1" aria-label="Floating label select example">

                                    <option value="1">Disponible</option>
                                    <option value="2">Ocupado</option>
                                    <option value="3">En 48 hs.</option>
                                </select>
                                <label htmlFor="floatingSelectGrid1">Status:</label>
                            </div>
                        </div> */}

                        <br />
                        <button type="submit" className="btn btn-success">Registrar</button>
                    </form>
                </div>
            </div>

        </section>

    )
}
