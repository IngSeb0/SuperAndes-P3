package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "proveedor")  // Nombre de la colección en MongoDB
public class Proveedor implements Serializable {

    @Id
    private Long nit;
    private String nombre;
    private String direccion;
    private String nombreContacto;
    private String telefonoContacto;

    public Proveedor() {}

    public Proveedor(Long nit, String nombre, String direccion, String nombreContacto, String telefonoContacto) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
    }

    // Getters y Setters
    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
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

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nit=" + nit +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", telefonoContacto='" + telefonoContacto + '\'' +
                '}';
    }
}
