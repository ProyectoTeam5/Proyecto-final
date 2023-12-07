import React, { useEffect, useState } from 'react'
import { deleteUser, getAllUsers } from '../services/UsersService'


export default function UsersList() {

    const [data, setData] = useState([]);
    const deleteUserSubmit = async (user) => {
        const confirmation = confirm("¿Está seguro que desea eliminar este usuario?");
        if(!confirmation){
            return;
        }else{

            await deleteUser(user.id);
            const newUser = data.filter(p => p.id != user.id);
            
            setData(newUser);
        }
    }
    useEffect(() => { getAllUsers().then(res => setData(res.getData)).catch() }, []);
    console.log(getAllUsers());

    return (


        <section className='hero4'>
            <div className="content2">

                <div className="container">

                    <table className='table table-bordered'>
                        <thead className="table-dark" >
                            <tr >
                                <th scope='col'>id</th>
                                <th scope='col'>Nombre</th>
                                <th scope='col'>Email</th>
                                <th scope='col'>Password</th>
                                <th scope='col'>Dirección</th>
                                {/* <th scope='col'>Direccion</th> */}
                                {/* <th scope='col'>supplier_id</th> */}
                                <th scope='col'>Eliminar</th>
                            </tr>
                        </thead>

                        <tbody>
                            {data.map((item) => {
                                return <tr key={item.id}>

                                    <td>{item.id}</td>
                                    <td>{item.name}</td>
                                    <td>{item.email}</td>
                                    <td>{item.password}</td>
                                    <td>{item.address}</td>
                                    {/* <td>{item.address}</td> */}
                                    {/* <td>{item.supplier_id}</td> */}


                                    {/* {item.adress.map((adressItem) => (
                                        <td key={adressItem.idservice}>
                                            {adressItem.adress}
                                        </td>
                                    ))} */}

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


