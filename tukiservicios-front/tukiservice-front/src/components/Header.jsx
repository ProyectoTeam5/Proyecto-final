import React from 'react'

export default function Header() {
    return (
        <nav>
            <Link to={"/"}>Index</Link>
            <Link to={"/crearSupplier"}>Registrarse como PROVEEDOR</Link>
            <Link to={"/listaSupplier"}>listado de PROVEEDORES</Link>

        </nav>
    )
}
