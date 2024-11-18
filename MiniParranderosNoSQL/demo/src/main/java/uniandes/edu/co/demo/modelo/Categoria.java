package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CategoriaS")
public class Categoria {

    @Id
    private String codigoCategoria;
    private String caracteristicasAlmacenamiento;
    private String nombreCategoria;
    private String descripcion;
    private String codigoBarrasProducto;

    public Categoria() {}

    public Categoria(String codigoCategoria, String caracteristicasAlmacenamiento, String nombreCategoria, String descripcion, String codigoBarrasProducto) {
        this.codigoCategoria = codigoCategoria;
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.codigoBarrasProducto = codigoBarrasProducto;
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getCaracteristicasAlmacenamiento() {
        return caracteristicasAlmacenamiento;
    }

    public void setCaracteristicasAlmacenamiento(String caracteristicasAlmacenamiento) {
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarrasProducto() {
        return codigoBarrasProducto;
    }

    public void setCodigoBarrasProducto(String codigoBarrasProducto) {
        this.codigoBarrasProducto = codigoBarrasProducto;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "codigoCategoria='" + codigoCategoria + '\'' +
                ", caracteristicasAlmacenamiento='" + caracteristicasAlmacenamiento + '\'' +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigoBarrasProducto='" + codigoBarrasProducto + '\'' +
                '}';
    }
}
