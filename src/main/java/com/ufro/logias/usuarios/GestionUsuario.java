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

    private boolean existeUsuario(String nombreUsuario) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos[0].equals(nombreUsuario)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;



    }

    public void editarPerfil(String nombreUsuario, String nuevaContraseña) throws IOException {
        File archivoOriginal = new File(ARCHIVO_USUARIOS);
        File archivoTemp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp));

        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos[0].equals(nombreUsuario)) {
                bw.write(nombreUsuario + "," + nuevaContraseña);
            } else {
                bw.write(linea);
            }
            bw.newLine();
        }
        br.close();
        bw.close();

        archivoOriginal.delete();
        archivoTemp.renameTo(archivoOriginal);
    }




}
