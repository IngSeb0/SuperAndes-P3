package uniandes.edu.co.demo.modelo;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Document(collection = "ordenesCompra")
public class OrdenCompra {

    @Id
    private String id;
    private String fechaCreacion;
    private Sucursal sucursal; // Referencia
    private Proveedor proveedor; // Referencia
    private List<DetalleOrden> detalle; // Embebido

    // Constructor sin parámetros
    public OrdenCompra() {
    }

    // Constructor con todos los parámetros
    public OrdenCompra(String id, String fechaCreacion, Sucursal sucursal, Proveedor proveedor, List<DetalleOrden> detalle) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.sucursal = sucursal;
        this.proveedor = proveedor;
        this.detalle = detalle;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleOrden> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleOrden> detalle) {
        this.detalle = detalle;
    }
}
