/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.Examen;
import java.util.Scanner;
import java.util.ArrayList;
import com.mycompany.dao.Clase;
import com.mycompany.dao.ClaseDao;
/**
 *
 * @author ERLIN
 */

public class Examen {

    private static Scanner keyInput;
    private static String  selectedOption = "M";
    private static ArrayList<Clase> clases;
    private static int claseId = 0;
  

    public static void main(String[] args) {
        init();
        PrintUtilities.printH1("Buena dia!!");
        while(!selectedOption.equalsIgnoreCase("N")) {
            PrintUtilities.printMenu();
            selectedOption = PrintUtilities.readInput(
                    keyInput,
                    "ESCRIBA UNA LETRA",
                    "Y"
            );
            switch (selectedOption.toUpperCase()) {
                case "C":
                    mostrarUsuarios();
                    crearUsuarios();
                    break;
                case "E":
                    mostrarUsuarios();
                    actualizarUsuarios();
                    break;
                case "D":
                    mostrarUsuarios();
                    eliminarUsuarios();
                case "M":
                    mostrarUsuarios();
                    break;
                case "N":
                    PrintUtilities.printH1("...........");
                    break;
            }
        }
        
    }

    //
    private static void mostrarUsuarios(){
        clases = ClaseDao.Obtener();
        for( int i = 0; i< clases.size(); i++) {
            Clase CCUsuario = clases.get(i);
            System.out.println(CCUsuario.printString());
        }
    }
    
    private static void crearUsuarios() {
        PrintUtilities.printH1("Crear Nuevo Usuario");
        String nombre = PrintUtilities.readInput(keyInput, "Nombre", "Nuevo Usuario");
        String estado = PrintUtilities.readInput(keyInput, "Estado (ACT, INA)", "ACT");
        String email = PrintUtilities.readInput(keyInput, "Email", "gmail");
        String password = PrintUtilities.readInput(keyInput, "Contraseña", "8 digitos");
        String avatar = PrintUtilities.readInput(keyInput, "Avatar", "{}");
        String fchIngreso = PrintUtilities.readInput(keyInput, "Fecha de Ingreso", "Forma:Cualquiera");
        
        Clase nuevaClass = new Clase();
        nuevaClass.setEstado(estado);
        nuevaClass.setNombre(nombre);
        nuevaClass.setEmail(email);
        nuevaClass.setPassword(password);
        nuevaClass.setAvatar(avatar);
        nuevaClass.setFchIngreso(fchIngreso);
       
        ClaseDao.Anuevo(nuevaClass);
        clases = ClaseDao.Obtener();
    }
    //
    private static void actualizarUsuarios() {
        int seleccionarClase = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "Código de la Categoría", "")
            );
        if (seleccionarClase == 0) {
            PrintUtilities.printH1("ERROR CODIGO NO VALIDO");
        } else {
            Clase usuarioUP = null;
            for (int i = 0; i < clases.size(); i++) {
                if (clases.get(i).getId()== seleccionarClase) {
                    usuarioUP = clases.get(i);
                    break;
                }
            }
            if (usuarioUP == null) {
                PrintUtilities.printH1("ERROR CODIGO NO VALIDO");
            } else {
                PrintUtilities.print("Modificacion De Usuario");
                PrintUtilities.print(usuarioUP.printString());
                PrintUtilities.print("-----------------------");
                usuarioUP.setNombre(PrintUtilities.readInput(keyInput, "Nombre", usuarioUP.getNombre()));
                usuarioUP.setEstado(PrintUtilities.readInput(keyInput, "Estado", usuarioUP.getEstado()));
                usuarioUP.setEmail(PrintUtilities.readInput(keyInput, "Email", usuarioUP.getEmail()));
                usuarioUP.setPassword(PrintUtilities.readInput(keyInput, "Password", usuarioUP.getPassword()));
                usuarioUP.setAvatar(PrintUtilities.readInput(keyInput, "Avatar", usuarioUP.getAvatar()));
                usuarioUP.setFchIngreso(PrintUtilities.readInput(keyInput, "Estado", usuarioUP.getFchIngreso()));
                PrintUtilities.print("-**-*-**-*-**--*-*-*-*-*-");
                
                ClaseDao.actualizar(usuarioUP);
                clases = ClaseDao.Obtener();
            }
        }
    }
    //
    private static void eliminarUsuarios() {
        int selecionarId = Integer.parseInt(
                PrintUtilities.readInput(keyInput, "ID de Usuario", "")
            );
        if (selecionarId == 0) {
            PrintUtilities.printH1("ERROR ID NO ENCONTRADA");
        } else {
            Clase usuarioDEL = null;
            int indexToRemove = -1;
            for (int i = 0; i < clases.size(); i++) {
                if (clases.get(i).getId()== selecionarId) {
                    usuarioDEL = clases.get(i);
                    indexToRemove = i;
                    break;
                }
            }
            if (usuarioDEL == null) {
                PrintUtilities.printH1("ERROR DE INGRESO DE CODIGO");
            } else {
                PrintUtilities.print("ELIMINACION DE USUARIO");
                PrintUtilities.print(usuarioDEL.printString());
                PrintUtilities.print("-----------------------");
                String eliminar = PrintUtilities.readInput(keyInput, "QUIERE ELIMINAR EL USARIO? (Y, N): ", "N");
                if ( eliminar.equalsIgnoreCase("Y") ) {
                    
                    ClaseDao.eliminarClase(usuarioDEL.getId());
                    clases = ClaseDao.Obtener();
                    PrintUtilities.print("Usuario Borrado");
                } else {
                    PrintUtilities.print("Detencion de Eliminacion");
                }
                
                PrintUtilities.print("---------------------");
            }
        }
    }
    
    private static void init(){
        keyInput = new Scanner(System.in);
        ClaseDao.setup();
        clases = new ArrayList<Clase>();
    }
}

