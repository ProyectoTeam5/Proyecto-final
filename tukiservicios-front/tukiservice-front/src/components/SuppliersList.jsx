import React, { useEffect, useState } from 'react'
import { getAllSuppliers } from '../services/SuppliersService'


export default function SuppliersList() {

    const [data, setData] = useState([]);
    const deleteUserSubmit = async (user) => {
        await deleteUser(user.id);
        const newUser = data.filter(p => p.id != user.id);

        setData(newUser);
    }
    useEffect(() => { getAllSuppliers().then(res => setData(res.getData)).catch() }, []);
    console.log(getAllSuppliers());


    return (
        <div>
            Listado de Proveedores
            {/* {data.map((item) => { return <li key={item.id}>{item.supplierName}</li> })} */}

            <table className='table'>
                <thead >
                    <tr >
                        <th scope='col'>id</th>
                        <th scope='col'>Nombre</th>

                        <th scope='col'>Email</th>
                        <th scope='col'>Curriculum</th>
                        <th scope='col'>Teléfono</th>
                        <th scope='col'>Status</th>
                        <th scope='col'>Profesión</th>
                        <th scope='col'>Acción</th>
                    </tr>
                </thead>

                <tbody>
                    {data.map((item) => {
                        return <tr key={item.id}>

                            <td>{item.id}</td>
                            <td>{item.supplierName}</td>

                            <td>{item.email}</td>
                            <td>{item.resume}</td>
                            <td>{item.contactNumber}</td>
                            <td>{item.workStatus}</td>
                            {item.profession.map((professionItem) => (
                                <span key={professionItem.idservice}>
                                    {professionItem.profession}
                                </span>
                            ))};
                            <td><button className='btn btn-danger'
                                onClick={() => deleteUserSubmit(item)}
                            >Delete</button></td>

                        </tr>
                    })}
                </tbody>

            </table>
        </div>

    )
}

// useEffect(()=>{getAllSuppliers().then(res=> setData(res.getInfo)).catch()}, []);
