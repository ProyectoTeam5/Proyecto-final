import React from "react";
import { Link } from "react-router-dom";

export default function LoginUser() {
  return (
    <div>
      Iniciar sesion proovedor
      <div className="main">
        <form className="form">
          <h1 className="form-title">Bienvenido !</h1>
          <p className="form-subtitle">Inicia sesion y contrata un servicio</p>
          <div className="form-group">
            <label for="txtEmail"> Email</label>
            <input type="email" id="txtEmail" required />
          </div>
          <div className="form-group">
            <label for="txtPassword"> Password</label>
            <input type="password" id="txtPassword" required />
          </div>
          <div className="form-group">
            <input type="submit" value="Enviar"/>
          </div>
          <div className="form-group">
            <p className="form-footer-text">¿eres proveedor? {" "}<Link to={"/loginSupplier"}>Inicia Sesion</Link></p>
          </div>
        </form>
      </div>
    </div>
  );
}
