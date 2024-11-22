package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection = "ciudades")
public class Ciudad {

    private String nombre;
    private String codigo;

    // Constructor sin parámetros
    public Ciudad() {
    }

    // Constructor con todos los parámetros
    public Ciudad(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
