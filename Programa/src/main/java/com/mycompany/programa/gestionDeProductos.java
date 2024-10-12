/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa;

import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class gestionDeProductos {
    //atributos
    
    int ges;
    
    public void mostraropcionesdegestion(){
        
        Scanner gestion = new Scanner (System.in);
        
        System.out.println("GESTION DE PRODUCTOS");
        System.out.println("1) ALTA DE PRODUCTOS ");
        System.out.println("2) BAJA DE PRODUCTOS ");
        System.out.println("3) MODIFICACION DE PRODUCTOS ");
        int ges;
        ges = gestion.nextInt();
    
    
        if(ges == 1){
        
        //alta de productos 
        Scanner nombrep = new Scanner(System.in);
        String nombre;
        System.out.println("Ingresa el nombre del producto");
        
        nombre = nombrep.nextLine();
        
        Scanner tipoA = new Scanner(System.in);
        System.out.println("ingresa a que categoria pertenece el producto ");
        System.out.println("1) ropa ");
        System.out.println("2) electrodomesticos ");
        System.out.println("3) muebles  ");
        System.out.println("4) limpieza ");
        System.out.println("5) herramientas ");
        System.out.println("6) otro ");
        int Tipo = tipoA.nextInt();
        }       
        
        
        
        if(ges == 2){
        System.out.println("cinta de opciones");
        }
        if(ges == 3){
        System.out.println("cinta de opciones");
        }
    }
} 

