/*
Proposito: Aplicacion que permite gestionar libros de una biblioteca
Autor 1: Juan Esteban Lozano B. - 2363228-2724
Autor 2: Juan David Arias Martinez - 2363132-2724
Autor 3: Andres Felipe Leon Tabares - 2363-2724
Fecha: 31-08-2024
Version: 0.8
*/
package bibliotecaapp_lab1;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

public class BibliotecaApp_Lab1 {
    
    ArrayList<Libro> Libros = new ArrayList<Libro>();
    
    public void nuevoLibro(){
        Libro obj = new Libro();
        obj.setIsbn();
        obj.setTitulo();
        obj.setAutor();
        obj.setEditorial();
        obj.setPreciosHistoricos();
        obj.setPromedioPrecios();
        Libros.add(obj);
        JOptionPane.showMessageDialog(null, "Se Adiciono el nuevo Libro CORRECTAMENTE!!!");
    }
    
    public void consultarLibro(){
        String Entrada = JOptionPane.showInputDialog("Ingrese el ISBN del Libro:");
        Boolean p = true;
        try{
            Integer isbn = Integer.parseInt(Entrada);
            for(Libro libro : Libros){
                if(Objects.equals(isbn, libro.getIsbn())){
                    System.out.print("Los datos del Libro son:");
                    libro.getLibro();
                    p = false;
                }
            }
            if(p == true){
                JOptionPane.showMessageDialog(null, "EL Libro buscado no se ha encontrado");
            }
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "El valor ingresado no es un numero");
    }
}
    
    public void modificarLibro(){
        String Entrada = JOptionPane.showInputDialog("Ingrese el ISBN del Libro:");
        Boolean p = true;
        Integer i = 0;
        try{
            Integer isbn = Integer.parseInt(Entrada);
            for(Libro libro : Libros){
                if(Objects.equals(isbn, libro.getIsbn())){
                    libro.setIsbn(isbn);
                    libro.setAutor();
                    libro.setEditorial();
                    libro.setPreciosHistoricos();
                    Libros.set(i, libro);
                    JOptionPane.showMessageDialog(null, "Se Modifico el Libro CORRECTAMENTE!!!");
                    p = false;
                }
                i += 1;
            }
            if(p == true){
                JOptionPane.showMessageDialog(null, "EL Libro buscado no se ha encontrado");
            }
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "El valor ingresado no es un numero");
        }
    }
    
        public void eliminarLibro(){
        String Entrada = JOptionPane.showInputDialog("Ingrese el ISBN del Libro:");
        Boolean p = true;
        Integer i = 0;
        try{
            Integer isbn = Integer.parseInt(Entrada);
            for(Libro libro : Libros){
                if(Objects.equals(isbn, libro.getIsbn())){
                    Libros.remove(i);
                    JOptionPane.showMessageDialog(null, "Se Elimino el Libro CORRECTAMENTE!!!");
                    p = false;
                }
                i += 1;
            }
            if(p == true){
                JOptionPane.showMessageDialog(null, "EL Libro buscado no se ha encontrado");
            }
        }catch(NumberFormatException error){
            JOptionPane.showMessageDialog(null, "El valor ingresado no es un numero");
        }
    }
    
    public void gestionLibros(){
        int opcion;
        do {
            String Entrada = JOptionPane.showInputDialog(
                "Gestion De Libros:\n" +
                "1. Nuevo Libro\n" +
                "2. Consultar Libro\n" +
                "3. Modificar Libro\n" +
                "4. Eliminar\n" +
                "0. Salir\n");
            opcion = Integer.parseInt(Entrada);
            switch(opcion){
                case 1: nuevoLibro(); break;
                case 2: consultarLibro(); break;
                case 3: modificarLibro(); break;
                case 4: eliminarLibro(); break;
                case 0: break;
                default: JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
            }
        } while (opcion!=0);
    }
    
    public void listadoGeneral(){
        Integer i = 0;
        Boolean p = true;
        System.out.println("Listado General: \n");
        for(Libro libro : Libros){
            System.out.println("Libro N"+(i+1));
            libro.getLibro();
            i += 1;
            p = false;
        }
        if(p == true){
            JOptionPane.showMessageDialog(null, "Aun NO se han registrado libros");
        }
    }
    
    public void listadoProm(){
        Integer i = 0;
        Boolean p = true;
        System.out.println("Listado de Promedios: \n");
        for(Libro libro : Libros){
            if(libro.getPromedioPrecios() >= 3000.0){
                System.out.println("Libro N"+(i+1));
                libro.getLibro();
                i += 1;
                p = false;
            }
        }
        if(p == true){
            JOptionPane.showMessageDialog(null, "Aun NO se han registrado libros\n" +
                                                "con promedio mayores a 300");
        }
    }
    
    public void listados(){
        int opcion;
        do {
            String Entrada = JOptionPane.showInputDialog(
                "Listados:\n" +
                "1. Listado General\n" +
                "2. Listado de libros con promedios de precios mayores a 3000\n" +
                "0. Salir\n");
            opcion = Integer.parseInt(Entrada);
            switch(opcion){
                case 1: listadoGeneral(); break;
                case 2: listadoProm(); break;
                case 0: break;
                default: JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
            }
        } while (opcion!=0);
    }
    
    public void promHistoricos(){
        Double prom = 0.0;
        Integer i = 0;
        for(Libro libro: Libros){
            prom += libro.getPromedioPrecios();
            i += 1;
        }
        prom = prom/i;
        JOptionPane.showMessageDialog(null, "Promedio Total: " + prom);
    }
    
    public void menorProm(){
        Libro obj = Libros.get(0);
        Double prom = obj.getPromedioPrecios();
        for(Libro libro: Libros){
            if(libro.getPromedioPrecios() <= prom){
                prom = libro.getPromedioPrecios();
                obj = libro;
                
            }
        }
        JOptionPane.showMessageDialog(null, "El Libro con el menor promedio es: " + obj.getIsbn() + " (" + obj.getTitulo() + ")" +"\n" +
                                            "Promedio: " + prom);
    }
    
    public void mayorProm(){
        Libro obj = Libros.get(0);
        Double prom = obj.getPromedioPrecios();
        for(Libro libro: Libros){
            if(libro.getPromedioPrecios() >= prom){
                prom = libro.getPromedioPrecios();
                obj = libro;
            }
        }
        JOptionPane.showMessageDialog(null, "El Libro con el mayor promedio es: " + obj.getIsbn() + " (" + obj.getTitulo() + ")" +"\n" +
                                            "Promedio: " + prom);
    }
    
    public void estadisticas(){
        int opcion;
        do {
            String Entrada = JOptionPane.showInputDialog(
                "Estadisticas:\n" +
                "1. Promedio de todos los Precios Historicos\n" +
                "2. Libro con el promedio mas bajo\n" +
                "3. Libro con el promedio mas alto\n" +
                "0. Salir\n");
            opcion = Integer.parseInt(Entrada);
            switch(opcion){
                case 1: promHistoricos(); break;
                case 2: menorProm(); break;
                case 3: mayorProm(); break;
                case 0: break;
                default: JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
            }
        } while (opcion!=0);
    }
    
    public void salu2(){
        JOptionPane.showMessageDialog(null, "Autor 1: Juan Esteban Lozano B. - 2363228-2724\n" +
                                            "Autor 2: Juan David Arias Martinez - 2363132-2724\n" +
                                            "Autor 3: Andres Felipe Leon Tabares - 2363-2724");
    }
    
    public void menu(){
        int opc;
        do {
            String Entrada = JOptionPane.showInputDialog(
                "Menú Principal:\n" +
                "1. Gestión de Libros\n" +
                "2. Listados\n" +
                "3. Estadísticas\n" +
                "4. Acerca de\n" +
                "0. Salir");  
            opc = Integer.parseInt(Entrada);
            switch(opc){
                case 1: gestionLibros(); break;
                case 2: listados(); break;
                case 3: estadisticas(); break;
                case 4: salu2();
                case 0: break;
                default: JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
            }
        } while (opc!=0);
    }
    
    public static void main(String[] args) {
        BibliotecaApp_Lab1 Objeto = new BibliotecaApp_Lab1();
        Objeto.menu();
    }
}
