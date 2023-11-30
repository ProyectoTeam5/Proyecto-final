import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
    return (
        <>
            <nav>
                <Link to={"/"}>Index</Link>
                <Link to={"/crearSupplier"}>Registrarse como PROVEEDOR</Link>
                <Link to={"/listaSuppliers"}>listado de PROVEEDORES</Link>
                <Link to={"/crearUser"}>Registrarse como USUARIO</Link>
                <Link to={"/listaUser"}>listado de USUARIOS</Link>
                <Link to={"/login"}>LOGIN</Link>


            </nav>
        </>
    )
}
