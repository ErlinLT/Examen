/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Examen;
import java.util.Scanner;
/**
 *
 * @author obetancourth
 */
public class PrintUtilities {
    public static void printH1( String headerText ) {
        // esfelizcuandolosgatosnoestanylosratonesfiestahacen = true;
        // esFelizCuandoLosGatosNoEstanYLosRatonesFiestaHacen = true;
        System.out.println("===================================================");
        System.out.println(headerText);
        System.out.println("===================================================");
    }
    public static String readInput( Scanner keyInput, String label, String defaultValue) {
        System.out.println("");
        System.out.println(label + " < " + defaultValue + " > :");
        String inputValue = keyInput.nextLine();
        //  || or   && and
        if (inputValue.isEmpty() || inputValue.isBlank()) {
            inputValue = defaultValue;
        }
        return inputValue;
    }
    public static void printMenu(){
        System.out.println("===================================================");
        System.out.println("Opciones");
        System.out.println("===================================================");
        
        System.out.println("M \t Mostrar Usuarios");
        System.out.println("C \t Agregar Usuario");
        System.out.println("E \t Modificar Usurio");
        System.out.println("D \t Eliminar Usuario");
        
        
        System.out.println("N \t Salir");
    }
    public static void print(String text){
        System.out.println(text);
    }
}
