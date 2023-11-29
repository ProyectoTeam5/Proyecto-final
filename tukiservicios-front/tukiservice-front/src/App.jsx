import { useState } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Header from './components/Header'
import CreateSupplier from './components/createSupplier'
import SuppliersList from './components/suppliersList'



function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path='/' element={<h3>Index</h3>}> </Route>
          <Route path='/crearSupplier' element={<CreateSupplier />}> </Route>
          <Route path='/listaSupplier' element={<SuppliersList />}> </Route>
          <Route path='/crearUser' element={<h3>Registrarse como USUARIO</h3>}> </Route>
          <Route path='/listaUser' element={<h3>Ver listado de USUARIOS</h3>}> </Route>
          <Route path='/login' element={<h3>LOGIN</h3>}> </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
