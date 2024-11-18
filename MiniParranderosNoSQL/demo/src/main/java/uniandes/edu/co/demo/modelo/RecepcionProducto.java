package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "recepcionProductos")
public class RecepcionProducto implements Serializable {

    @Id
    private String id;

    private String fechaRecepcion;

    @DBRef
    private OrdenCompra ordenCompra;

    @DBRef
    private Bodega bodega;

    public RecepcionProducto() {}

    public RecepcionProducto(OrdenCompra ordenCompra, Bodega bodega, String fechaRecepcion) {
        this.ordenCompra = ordenCompra;
        this.bodega = bodega;
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

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Override
    public String toString() {
        return "RecepcionProducto{" +
                "id='" + id + '\'' +
                ", fechaRecepcion='" + fechaRecepcion + '\'' +
                ", ordenCompra=" + ordenCompra +
                ", bodega=" + bodega +
                '}';
    }
}
