package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bebedores")  // Nombre de la colección en MongoDB
public class Bebedor {

    @Id
    private int id;
    private String nombre;
    private String ciudad;
    private String presupuesto;
    private int puntos;
    private List<String> preferencias;  // Lista de nombres de bebidas preferidas
    private List<Integer> bares_frecuentados;  // Lista de IDs de los bares frecuentados

    // Constructor vacío (necesario para operaciones de Spring Data)
    public Bebedor() {}

    // Constructor con parámetros
    public Bebedor(int id, String nombre, String ciudad, String presupuesto, int puntos, List<String> preferencias, List<Integer> bares_frecuentados) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
        this.puntos = puntos;
        this.preferencias = preferencias;
        this.bares_frecuentados = bares_frecuentados;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(List<String> preferencias) {
        this.preferencias = preferencias;
    }

    public List<Integer> getBares_frecuentados() {
        return bares_frecuentados;
    }

    public void setBares_frecuentados(List<Integer> bares_frecuentados) {
        this.bares_frecuentados = bares_frecuentados;
    }

    @Override
    public String toString() {
        return "Bebedor [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", presupuesto=" + presupuesto + ", puntos=" + puntos
                + ", preferencias=" + preferencias + ", bares_frecuentados=" + bares_frecuentados + "]";
    }
}
