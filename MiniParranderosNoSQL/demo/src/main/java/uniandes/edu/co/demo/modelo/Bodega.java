package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Document(collection = "bodegas")
public class Bodega {

    @Id
    private String id; // Nuevo campo ID
    private String nombre;
    private double tamañoM2;
    private List<Producto> productos;

    // Constructor sin parámetros
    public Bodega() {
    }

    // Constructor con todos los parámetros
    public Bodega(String id, String nombre, double tamañoM2, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.tamañoM2 = tamañoM2;
        this.productos = productos;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
