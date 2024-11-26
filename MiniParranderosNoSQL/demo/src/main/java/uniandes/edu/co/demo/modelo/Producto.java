package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private double precio;
    private String detallesEmpacado;
    private Categoria categoria;
    private String fechaVencimiento; // Será nulo si el producto no es perecedero
    private String sucursalId;       // Referencia a la sucursal

    public Producto() {}

    public Producto(String id, String nombre, double precio, String detallesEmpacado, Categoria categoria, String fechaVencimiento, String sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.detallesEmpacado = detallesEmpacado;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.sucursalId = sucursalId;
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }
}
