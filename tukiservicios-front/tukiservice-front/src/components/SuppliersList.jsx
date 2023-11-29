import React, { useEffect } from 'react'
import { getAllSuppliers } from '../services/SuppliersService'

export default function SuppliersList() {
    useEffect(() => {
        getAllSuppliers()
    }, [])

    return (
        <div>
            Listado de Proveedores
        </div>
    )
}
