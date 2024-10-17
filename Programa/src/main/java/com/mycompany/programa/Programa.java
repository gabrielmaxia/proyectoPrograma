/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class Programa {

    
    public static void main(String[] args) throws IOException {
        
        EscrituraDeArchivosSA fh = new EscrituraDeArchivosSA (); 
        
        int ges;
        
        int Tipo;
        String descripcion;
        String caracteristicas;
        float precio;
        int sInicial;
        File archivo = new File("productos.txt");
        String codigo;
        int contador = 1;
        String limite ="Y";
        String codigoeliminar;
        File archivocat = new File("categorias.txt");
    
        
        Scanner GESTION = new Scanner (System.in);
        
        System.out.println("Ingresa la opcion que deseas realizar ");
        System.out.println("1) Gestion de productos "); 
        System.out.println("2) Control de existencias  ");
        System.out.println("3) Informes y estadisticas ");
        System.out.println("4) ver categorias ");
        
        
        int gest = GESTION.nextInt(); 
        
        if (gest == 1) {
            
            
          Scanner gestion = new Scanner (System.in);
        
        System.out.println("GESTION DE PRODUCTOS");
        System.out.println("1) ALTA DE PRODUCTOS ");
        System.out.println("2) BAJA DE PRODUCTOS ");
        System.out.println("3) MODIFICACION DE PRODUCTOS ");
        ges = gestion.nextInt();
        
        if(ges == 1){
                      
     while (limite.equalsIgnoreCase("Y")) {
        //alta de productos 

        Scanner nombrep = new Scanner(System.in);
        String nombre;
        System.out.println("Ingresa el nombre del producto");
        nombre = nombrep.nextLine().trim();
        while (nombre.isEmpty()){
            System.out.println("el nombre no puede estar vacio");
            nombre = nombrep.nextLine().trim();
        }
        
         System.out.println("categorias");
         
        try{
            
            FileReader fr = new FileReader(archivocat);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                    
            Scanner scannn = new Scanner (System.in);
            System.out.println("deseas agregar una categoria nueva 'Y/N' ");
            String catn = scannn.next();
            
               if(catn.equalsIgnoreCase("Y")) {
                   
            try{ 
                
         
            
           FileWriter cat = new FileWriter(archivocat, true);
           BufferedWriter bw = new BufferedWriter(cat);
                Scanner categ = new Scanner(System.in);
                System.out.println("ingresa la nueva categoria");
                String catego = categ.next();
                
                
                
           bw.write(catego + "\r"); 
           bw.flush();
           bw.close();
           System.out.println("el producto se agreco correctamente");
            }
        
       catch(IOException exception){ 
           exception.printStackTrace(System.out);
       }  
       }
                
        
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

       codigo = String.format("%06d", contador);
       contador++;
     
         
          try{ 
           FileWriter escribir = new FileWriter(archivo, true);
           BufferedWriter bw = new BufferedWriter(escribir);
           
           bw.write(codigo +"|" + nombre + "|" + descripcion +"|" + caracteristicas +"|" + precio +"|" + sInicial +"\r"); //error en las variables
           bw.flush();
           bw.close();
           System.out.println("el producto se agreco correctamente");
       }
       catch(IOException exception){ 
           exception.printStackTrace(System.out);
           
       }
          Scanner scan = new Scanner(System.in);
        System.out.println("¿Deseas agregar otro producto? (Y/N): ");
                    limite = scan.next();        
          
        }
        }
        if(ges == 2){
            try{
            FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            
            try {
               
                Scanner scan = new Scanner(System.in);
                System.out.println("ingresa el codigo de producto a eliminar");
                codigoeliminar = scan.next();
                
                Scanner scann = new Scanner(System.in);
                System.out.println("estas seguro de eliminar este producto 'Y/N'");
                String caso = scann.next();
                
                if (caso.equalsIgnoreCase("Y")) {
                    
                
                        FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("archivo_texto_copia.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        String linea = "";
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (!datos[0].equals(codigoeliminar)) {
                                bw.write(linea+"\r");
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), archivo.toPath(), REPLACE_EXISTING);
                }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(EscrituraDeArchivosSA.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(EscrituraDeArchivosSA.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            System.out.println("el producto se a eliminado con exito");
        
        }
        
        
       if(ges == 3){
           
           try{
            FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
           
            String [][] datos = new String[50][7];
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            int contador12 = 0;
            while ((linea = br.readLine()) != null) {
                String [] campos = linea.split("\\|");
                datos[contador12][0] = campos[0];
                datos[contador12][1] = campos[1];
                datos[contador12][2] = campos[2];
                datos[contador12][3] = campos[3];
                datos[contador12][4] = campos[4];
                datos[contador12][5] = campos[5];
                contador12++;
            }
            
            br.close();
            fr.close();
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Ingrese el código a buscar:");
            codigo = scan.nextLine();
            contador12 = 0;
            
            int indiceModificado = 0;
            
            while (datos.length > contador12) {
                if (datos[contador12][0] != null && datos[contador12][0].compareTo(codigo) == 0) {
                    for (int i = 0; 
                             i<datos[contador12].length; 
                             i++) {
                        System.out.print(datos[contador12][i] + " ");
                    }
                    
                    String nombre12;
                    System.out.println("Ingrese el nuevo nombre:");
                    nombre12 = scan.nextLine();
                    
                    datos[contador12][1] = nombre12;
                    
                    System.out.println("Ingrese el nuevo tipo de articulo");
                    String nombre13 = scan.nextLine();
                    datos[contador12][2] = nombre13;
                    System.out.println("Ingrese la nueva caracteristica");
                    String nombre14 = scan.nextLine();
                    datos[contador12][3] = nombre14;
                    System.out.println("Ingrese la nueva descripcion");
                    String nombre15 = scan.nextLine();
                    datos[contador12][4] = nombre15;
                    System.out.println("Ingrese el nuevo precio");
                    String nombre16 = scan.nextLine();
                    datos[contador12][5] = nombre16;
                    System.out.println("Ingrese el ingreso inicial");
                    String nombre17 = scan.nextLine();
                    datos[contador12][6] = nombre17;
                    
                    
                    indiceModificado = contador12;
                }
                contador12++;
            }
          
            
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            contador12 = 0;
            while (datos[contador12][0] != null) {
                bw.write(datos[contador12][0] + "|" + 
                        datos[contador12][1] + "|" +
                        datos[contador12][2] + "|" +
                        datos[contador12][3] + "|" +
                        datos[contador12][4] + "|" +
                        datos[contador12][5] + "\n");
                contador12++;
            }
            
            bw.close();
            fw.close();
            
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           System.out.println("Los cambios se an guardado exitosamente ");
        
    }
        }
        
        
        //*************************************************************
        //**********************************************************
        
        
        if(gest == 2) {
            // coloca la clase control de existencias
            Scanner f = new Scanner(System.in);
            System.out.println("elije la opcion a realizar");
             System.out.println("1) creacion de pedidos de compra");
        System.out.println("2) pedidos de compra ");
        System.out.println("3) historial de venta ");
        System.out.println("4) historial de compra ");
        
        
        int fd = f.nextInt();
        
        if (fd == 2){
            
            try {
            FileReader fr = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                     
            }
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
            String [][] datos = new String[50][6];
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            int contador12 = 0;
            while ((linea = br.readLine()) != null) {
                String [] campos = linea.split("\\|");
                datos[contador12][0] = campos[0];
                datos[contador12][1] = campos[1];
                datos[contador12][2] = campos[2];
                datos[contador12][3] = campos[3];
                datos[contador12][4] = campos[4];
                datos[contador12][5] = campos[5];
                contador12++;
            }
            
            br.close();
            fr.close();
            
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Ingrese el código a buscar:");
            codigo = scan.nextLine();
            contador12 = 0;
            
            int indiceModificado = 0;
            
            while (datos.length > contador12) {
                if (datos[contador12][0] != null && datos[contador12][0].compareTo(codigo) == 0) {
                    for (int i = 0; 
                             i<datos[contador12].length; 
                             i++) {
                        System.out.print(datos[contador12][i] + " ");
                    }
                    
                    System.out.println("nuevo ingreso");
                    int nombre17 = scan.nextInt();
                    
                    int cantidadActual = Integer.parseInt(datos[contador12][5]);
                    int nuevaCantidad = cantidadActual + nombre17;
                    datos[contador12][5] = String.valueOf(nuevaCantidad);
                    indiceModificado = contador12;
                }
                contador12++;
            }
          
            
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            contador12 = 0;
            while (datos[contador12][0] != null) {
                bw.write(datos[contador12][0] + "|" + 
                        datos[contador12][1] + "|" +
                        datos[contador12][2] + "|" +
                        datos[contador12][3] + "|" +
                        datos[contador12][4] + "|" +
                        datos[contador12][5] + "\n");
                contador12++;
            }
            
            bw.close();
            fw.close();
            
            
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        System.out.println("Los cambios se an guardado exitosamente ");
        

        
      
      
      
      
        if (fd == 1){
            
          fh.pedidos();
            
        }
        
        if (fd == 3){
            
           fh.historial();
            
        }
        
        if (fd == 4){
            
            fh.hcompras();
            
        }
           
           
        } 
      
        
        if(gest == 3){
            
            System.out.println("generar informes");
        Scanner gs = new Scanner(System.in);
        System.out.println("1) informes de movimiento de stock");
        System.out.println("2) generar informes de compras");
        System.out.println("3) generar graficas");
        int op = gs.nextInt();
        
        if (op == 1){
            
        //***************************************************
       
       fh.gestcsv();
            
        }
        
        if (op == 2){
            
            fh.gventa();
            
        }
            
            

        }
        
        
        if(gest == 4){
            try{
            FileReader fr = new FileReader(archivocat);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
 
        
            
            
    }
        
    }
}


