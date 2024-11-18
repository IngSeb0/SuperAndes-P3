package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "infoExtraBodegas")
public class InfoExtraBodega {

    @Id
    private String id; // ID único generado por MongoDB

    @DBRef
    private Bodega bodega;

    @DBRef
    private Producto producto;

    private Integer totalExistencias;
    private Float costoPromedio;
    private Integer capacidadAlmacenamiento;
    private Float nivelMinimo;

    public InfoExtraBodega() {}

    public InfoExtraBodega(Bodega bodega, Producto producto, Integer totalExistencias, Float costoPromedio, Integer capacidadAlmacenamiento, Float nivelMinimo) {
        this.bodega = bodega;
        this.producto = producto;
        this.totalExistencias = totalExistencias;
        this.costoPromedio = costoPromedio;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nivelMinimo = nivelMinimo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(Integer totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public Float getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(Float costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public Integer getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(Integer capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public Float getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(Float nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }
}
