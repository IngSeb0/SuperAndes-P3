package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "OrdenesCompra")
public class OrdenCompra {

    @Id
    private String idOrden; // ID único

    private Date fechaCreacion;
    private String estado;
    private Date fechaEntrega;

    @DBRef
    private Sucursal sucursal;

    @DBRef
    private Producto producto;

    @DBRef
    private Proveedor proveedor;

    public OrdenCompra() {}

    public OrdenCompra(String idOrden, Date fechaCreacion, String estado, Date fechaEntrega, Sucursal sucursal, Producto producto, Proveedor proveedor) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.sucursal = sucursal;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    // Getters y Setters
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "idOrden='" + idOrden + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", sucursal=" + sucursal +
                ", producto=" + producto +
                ", proveedor=" + proveedor +
                '}';
    }
}
