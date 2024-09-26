package com.ufro.logias.usuarios;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getContraseña() {
        return contraseña;


    }


    @Override
    public String toString() {
        return nombreUsuario + "," + contraseña;
    }
}
