/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alexa
 */
public class controlExistencia {
    
    
       //atributos
        int opcion;
    
    public void prueba2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Que deseas realizar ");
        System.out.println("1) registro de entradas de producos ");
        System.out.println("2) registro de salida de producto ");
        System.out.println("3) historial de stock ");
        opcion = scan.nextInt();
        
        
        if(opcion == 1){
            
            System.out.println("ingresa el codigo del producto ");
            
            
            
          
        }
        if(opcion == 2){
            System.out.println("ingresa el codigo del producto");
            
        }
        if(opcion == 3){
            
         try {
                        FileReader fr = new FileReader("C:\\Users\\alexa\\Desktop\\programaProyecto\\Programa \\Datos de producto.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(EscrituraDeArchivosSA.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(EscrituraDeArchivosSA.class.getName()).log(Level.SEVERE, null, ex);
                    }   
        }
}

    }
