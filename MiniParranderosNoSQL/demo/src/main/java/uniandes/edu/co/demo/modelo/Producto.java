package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection = "productos")
public class Producto {
    
    private String nombre;
    private double precio;
    private String detallesEmpacado;
    private Categoria categoria;


    public Producto() {
    }


    public Producto(String nombre, double precio, String detallesEmpacado, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.detallesEmpacado = detallesEmpacado;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDetallesEmpacado() {
        return detallesEmpacado;
    }

    public void setDetallesEmpacado(String detallesEmpacado) {
        this.detallesEmpacado = detallesEmpacado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
