package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class Bebida {
    
    private String nombre;
    private String tipo;
    private int grado_alcohol;
    private String horario;
    private int precio;
    
    public Bebida(String nombre, String tipo, int grado_alcohol, String horario, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.grado_alcohol = grado_alcohol;
        this.horario = horario;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getGrado_alcohol() {
        return grado_alcohol;
    }
    public void setGrado_alcohol(int grado_alcohol) {
        this.grado_alcohol = grado_alcohol;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}
