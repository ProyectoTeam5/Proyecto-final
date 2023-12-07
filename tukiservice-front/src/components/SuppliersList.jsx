import React, { useEffect, useState } from 'react'
import {deleteSupplier, getAllSuppliers } from '../services/SuppliersService'


export default function SuppliersList() {

    const [data, setData] = useState([]);
    const deleteSupplierSubmit = async (user) => {
        const confirmation = confirm("¿Está seguro que desea eliminar este proveedor?");
        if(!confirmation){
            return;
        }else{

            await deleteSupplier(user.id);
            const newUser = data.filter(p => p.id != user.id);
            
            setData(newUser);
        }
    }
    useEffect(() => { getAllSuppliers().then(res => setData(res.getData)).catch() }, []);
    console.log(getAllSuppliers());


    return (


        <section className='hero2'>
            <div className="content2">

                <div className="container">

                    <table className='table table-bordered'>
                        <thead className="table-dark" >
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
                                    <td>{item.profession}</td>
                                    <td><button className='btn btn-danger'
                                        onClick={() => deleteSupplierSubmit(item)}
                                    >Delete</button></td>

                                </tr>
                            })}
                        </tbody>

                    </table>
                </div>
            </div>
        </section>

    )
}


