package uniandes.edu.co.demo.modelo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

import java.util.List;
@ToString
@Document(collection = "sucursales")
public class Sucursal {

    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Ciudad ciudad; // Embebido
    private List<Bodega> bodegas; // Embebido

    // Constructor sin parámetros
    public Sucursal() {
    }

    // Constructor con todos los parámetros
    public Sucursal(String id, String nombre, String direccion, String telefono, Ciudad ciudad, List<Bodega> bodegas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.bodegas = bodegas;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

   
}
