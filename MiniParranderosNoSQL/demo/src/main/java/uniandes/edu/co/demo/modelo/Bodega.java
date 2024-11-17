package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bodegas")
public class Bodega {
    @Id
    private String id;
    private String nombreBodega;
    private Float tamanioBodega;
    private String sucursalId; // Referencia a la sucursal

    public Bodega() {}

    public Bodega(String nombreBodega, Float tamanioBodega, String sucursalId) {
        this.nombreBodega = nombreBodega;
        this.tamanioBodega = tamanioBodega;
        this.sucursalId = sucursalId;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public Float getTamanioBodega() {
        return tamanioBodega;
    }

    public void setTamanioBodega(Float tamanioBodega) {
        this.tamanioBodega = tamanioBodega;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }
}
