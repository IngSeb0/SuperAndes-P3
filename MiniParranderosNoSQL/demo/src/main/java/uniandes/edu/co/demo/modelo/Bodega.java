package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Document(collection = "bodegas")
public class Bodega {

    private String nombre;
    private double tamañoM2;
    private List<Producto> productos; 


    public Bodega() {
    }

    // Constructor con todos los parámetros
    public Bodega(String nombre, double tamañoM2, List<Producto> productos) {
        this.nombre = nombre;
        this.tamañoM2 = tamañoM2;
        this.productos = productos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamañoM2() {
        return tamañoM2;
    }

    public void setTamañoM2(double tamañoM2) {
        this.tamañoM2 = tamañoM2;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
