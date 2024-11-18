package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "Productos")
public class Producto implements Serializable {

    @Id
    private String codigoBarras;

    private String nombre;
    private Float precioUnitarioVenta;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Date fechaExpiracion;
    private List<EspecificacionEmpacado> especificaciones; // Lista de especificaciones

    public Producto() {}

    // Constructor con todos los argumentos
    public Producto(String codigoBarras, String nombre, Float precioUnitarioVenta, String presentacion,
                    Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion,
                    List<EspecificacionEmpacado> especificaciones) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.fechaExpiracion = fechaExpiracion;
        this.especificaciones = especificaciones;
    }

    // Getters y Setters
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Float precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public List<EspecificacionEmpacado> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<EspecificacionEmpacado> especificaciones) {
        this.especificaciones = especificaciones;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioUnitarioVenta=" + precioUnitarioVenta +
                ", presentacion='" + presentacion + '\'' +
                ", cantidadPresentacion=" + cantidadPresentacion +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", fechaExpiracion=" + fechaExpiracion +
                ", especificaciones=" + especificaciones +
                '}';
    }
}
