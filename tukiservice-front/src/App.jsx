import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import CreateSupplier from './components/CreateSupplier'
import SuppliersList from './components/SuppliersList';
import Header from './components/Header';
import Index from './components/Index';
import CreateUser from './components/CreateUser';
import UsersList from './components/UserList';
import Login from './components/Login';

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path='/' element={<Index />}> </Route>
          <Route path='/crearSupplier' element={<CreateSupplier />}> </Route>
          <Route path='/listaSuppliers' element={<SuppliersList />}> </Route>
          <Route path='/crearUser' element={<CreateUser />}> </Route>
          <Route path='/listaUser' element={<UsersList />}> </Route>

          <Route path='/listaUser' element={<h3>Ver listado de USUARIOS</h3>}> </Route>
          <Route path='/login' element={<Login />}> </Route>

        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
