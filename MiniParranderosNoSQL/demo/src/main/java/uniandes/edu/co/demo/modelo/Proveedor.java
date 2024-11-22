package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Document(collection = "proveedores")
public class Proveedor {

    @Id
    private String nit;
    private String nombre;
    private String contacto;
    private List<Producto> productos; // Referencia a productos

    // Constructor sin parámetros
    public Proveedor() {
    }

    // Constructor con todos los parámetros
    public Proveedor(String nit, String nombre, String contacto, List<Producto> productos) {
        this.nit = nit;
        this.nombre = nombre;
        this.contacto = contacto;
        this.productos = productos;
    }

    // Getters y Setters
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
