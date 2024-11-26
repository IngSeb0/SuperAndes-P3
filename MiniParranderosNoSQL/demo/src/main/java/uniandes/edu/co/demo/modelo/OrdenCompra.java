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
    private String sucursalId; 
    private String proveedorId; 
    private String estado; 
    private List<DetalleOrden> detalle; 
    
    public OrdenCompra() {
        this.estado = "vigente";
    }


    public OrdenCompra(String id, String fechaCreacion, String sucursalId, String proveedorId, String estado, List<DetalleOrden> detalle) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.sucursalId = sucursalId;
        this.proveedorId = proveedorId;
        this.estado = estado;
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

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleOrden> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleOrden> detalle) {
        this.detalle = detalle;
    }
}
