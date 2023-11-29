import { useState } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (

    <BrowserRouter>
      <Routes>
        <Route path='/' element={<h1>Index</h1>}> </Route>
        <Route path='/crearSupplier' element={<h1>Registrarse como PROVEEDOR</h1>}> </Route>
        <Route path='/listaSupplier' element={<h1>Ver listado de PROVEEDORES</h1>}> </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
