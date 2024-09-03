/*
Proposito: Definicion de la clase Libro
Autor 1: Juan Esteban Lozano B. - 2363228-2724
Autor 2: Juan David Arias Martinez - 2363132-2724
Autor 3: Andres Felipe Leon Tabares - 2363217-2724
Fecha: 31-08-2024
Version: 0.8
*/
package bibliotecaapp_lab1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Libro {
    Integer isbn;  // llave primaria
    String Entrada;
    String titulo;
    String autor;
    String editorial;
    ArrayList<Double> preciosHistoricos = new ArrayList<Double>();
    Double promPrecios;

    // Constructor
    public Libro() {
        isbn = 0;
        Entrada = "";
        titulo = "";
        autor = "";
        promPrecios = 0.0;
        preciosHistoricos.add(promPrecios);
        preciosHistoricos.add(promPrecios);
        preciosHistoricos.add(promPrecios);
        editorial = "";
    }

    // Getters y Setters
    public Integer getIsbn() {
        return isbn;
    }
    
    public void setIsbn(Integer entrada) {
        isbn = entrada;
    }

    public void setIsbn() {
        Entrada = JOptionPane.showInputDialog("Ingrese el ISBN(Codigo de 4 Digitos Numericos):");
        isbn = Integer.parseInt(Entrada);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo() {
        titulo = JOptionPane.showInputDialog("Ingrese el Titulo:");
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor() {
        autor = JOptionPane.showInputDialog("Ingrese el Autor:");
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial() {
        editorial = JOptionPane.showInputDialog("Ingrese la Editorial:");
    }

    public ArrayList<Double> getPreciosHistoricos() {
        return preciosHistoricos;
    }

    public void setPreciosHistoricos() {
        String a = JOptionPane.showInputDialog("Ingrese el Primer Precio Historico");
        Double aNum = Double.parseDouble(a);
        preciosHistoricos.set(0, aNum);
        
        String b = JOptionPane.showInputDialog("Ingrese el segundo Precio Historico");
        Double bNum = Double.parseDouble(b);
        preciosHistoricos.set(1, bNum);
        
        String c = JOptionPane.showInputDialog("Ingrese el tercer Precio Historico");
        Double cNum = Double.parseDouble(c);
        preciosHistoricos.set(2, cNum);
        
    }
    
    public Double getPromedioPrecios(){
        return promPrecios;
    }
    
    public void setPromedioPrecios(){
        promPrecios = (preciosHistoricos.get(0) + preciosHistoricos.get(1) + preciosHistoricos.get(2))/3;
    }

    public void getLibro(){
        System.out.println(
               "----------------------------------------------------------------\n" +
               "ISBN: " + isbn + "\n" +
               "Titulo: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Editorial: " + editorial + "\n" +
               "Precios Historicos: " + preciosHistoricos.toString()+ "\n" + 
               "Promedio de los precios: " + promPrecios +
               "----------------------------------------------------------------\n");
    }
}
