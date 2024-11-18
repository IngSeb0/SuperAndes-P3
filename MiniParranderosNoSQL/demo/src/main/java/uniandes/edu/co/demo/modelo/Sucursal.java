package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.io.Serializable;

@Document(collection = "Sucursales")
public class Sucursal implements Serializable {

    @Id
    private String idSucursal;

    private String nombreSucursal;
    private Float tamanioInstalacion;
    private String direccion;
    private String telefono;

    @DBRef
    private Ciudad ciudad;

    public Sucursal() {}

    public Sucursal(String nombreSucursal, Float tamanioInstalacion, String direccion, String telefono, Ciudad ciudad) {
        this.nombreSucursal = nombreSucursal;
        this.tamanioInstalacion = tamanioInstalacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Float getTamanioInstalacion() {
        return tamanioInstalacion;
    }

    public void setTamanioInstalacion(Float tamanioInstalacion) {
        this.tamanioInstalacion = tamanioInstalacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "idSucursal='" + idSucursal + '\'' +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", tamanioInstalacion=" + tamanioInstalacion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ciudad=" + (ciudad != null ? ciudad.getCodigoCiudad() : "null") +
                '}';
    }
}
