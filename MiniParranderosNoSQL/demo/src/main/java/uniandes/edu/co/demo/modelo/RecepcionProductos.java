package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@ToString
@Document(collection = "recepcionesProductos")
public class RecepcionProductos {

    @Id
    private String id;
    private OrdenCompra ordenCompra; 
    private List<DetalleRecepcion> detalle; 
    private LocalDate fechaRecepcion; 
    // Constructor sin parámetros
    public RecepcionProductos() {
    }

    // Constructor con todos los parámetros
    public RecepcionProductos(String id, OrdenCompra ordenCompra, List<DetalleRecepcion> detalle, LocalDate fechaRecepcion) {
        this.id = id;
        this.ordenCompra = ordenCompra;
        this.detalle = detalle;
        this.fechaRecepcion = fechaRecepcion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public List<DetalleRecepcion> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleRecepcion> detalle) {
        this.detalle = detalle;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
}
