package com.ufro.logias.usuarios;
import java.io.*;
import java.util.*;

public class GestionUsuario {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public void registrarUsuario(String nombreUsuario, String contraseña) throws IOException {
        if (!existeUsuario(nombreUsuario)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true));
            bw.write(new Usuario(nombreUsuario,contraseña).toString());
            bw.newLine();
            bw.close();
            System.out.println("Usuario registrado exitosamente");


        } else {
            System.out.println("El usuario ya existe");
        }
    }

    public boolean loginUsuario(String nombreUsuario, String contraseña) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos[0].equals(nombreUsuario) && datos[1].equals(contraseña)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    private boolean existeUsuario




}
