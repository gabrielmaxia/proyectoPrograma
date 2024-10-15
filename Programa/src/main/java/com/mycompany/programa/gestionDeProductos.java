/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class gestionDeProductos {
    //atributos
        File archivo;
        int ges;
        int Tipo;
        String descripcion;
        String nombre;
        String caracteristicas;
        float precio;
        int sInicial;
        int contador = 0000000;
                
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
        System.out.println("Ingresa el nombre del producto");
        nombre = nombrep.nextLine().trim();
        while (nombre.isEmpty()){
            System.out.println("el nombre no puede estar vacio");
            nombre = nombrep.nextLine().trim();
        }
        
        Scanner tipoA = new Scanner(System.in);
        System.out.println("ingresa a que categoria pertenece el producto ");
        System.out.println("1) ropa ");
        System.out.println("2) electrodomesticos ");
        System.out.println("3) muebles  ");
        System.out.println("4) limpieza ");
        System.out.println("5) herramientas ");
        System.out.println("6) otro ");
        Tipo = tipoA.nextInt();
        
        Scanner desc = new Scanner(System.in);
        
        System.out.println("Ingresa una breve descripcion");
        descripcion = desc.nextLine();
        
        Scanner car = new Scanner(System.in);
        
        System.out.println("Ingresa caracterisitcas del producto");
        caracteristicas = car.nextLine();
        
        Scanner pre = new Scanner(System.in);
        
        System.out.println("Ingresa el precio del producto");
        precio = pre.nextInt();
        
        while (precio <= 0){
            System.out.println("el numero debe ser mayor a cero");
            precio = pre.nextInt();
        }
        
        Scanner inicio = new Scanner(System.in);
        
        System.out.println("Ingresa la cantidad inicial del producto ");
        sInicial = inicio.nextInt();
        
        while (sInicial <=0){
            System.out.println("el numero debe de ser diferente de cero");
            sInicial = inicio.nextInt();
        }
        }       
        
        if(ges == 2){
        System.out.println("cinta de opciones");
        }
        if(ges == 3){
        System.out.println("cinta de opciones");
        }
    }
    
   public void creararchivo(){ 

        
        archivo = new File ("Datos de prouctos");
        
        try{
            if (archivo.createNewFile()){
                
                System.out.println("archivo creado con exito");
            }
                else {
                System.out.println("error al crear el archivo");
                  }
            
        }
        catch(IOException exeption){
            exeption.printStackTrace(System.out);    
        }     
   }
   
   
   
   public void escribirArchivo(){
       try{ FileWriter escribir = new FileWriter(archivo, true);
           escribir.write(contador + "|" + nombre + "|"+ Tipo + "|" + descripcion +"|" + caracteristicas +"|" + precio +"|" + sInicial +"\r");
           escribir.close();
           System.out.println("el producto se a añadido correctamente");
       }
       catch(IOException exception){ 
           exception.printStackTrace(System.out);
           
       }
   }
   
   
   public void codigo(){
       while (contador == 0){
           contador = contador + 1;
       }
           
   }
    
} 

