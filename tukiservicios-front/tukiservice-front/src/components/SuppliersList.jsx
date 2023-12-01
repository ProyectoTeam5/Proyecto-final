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
                                    {item.profession.map((professionItem) => (
                                        <td key={professionItem.idservice}>
                                            {professionItem.profession}
                                        </td>
                                    ))}
                                    <td><button className='btn btn-danger'
                                        onClick={() => deleteUserSubmit(item)}
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

// useEffect(()=>{getAllSuppliers().then(res=> setData(res.getInfo)).catch()}, []);
