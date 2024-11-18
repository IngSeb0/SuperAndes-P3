package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "detalleCostoBodega")
public class DetalleCostoBodega {

    @Id
    private DetalleCostoBodegaPk pk; // Clave primaria compuesta representada como un objeto

    @Field("costoUnitarioBodega")
    private Float costoUnitarioBodega;

    @Field("cantidadExistencia")
    private Integer cantidadExistencia;

    public DetalleCostoBodega() {}

    public DetalleCostoBodega(DetalleCostoBodegaPk pk, Float costoUnitarioBodega, Integer cantidadExistencia) {
        this.pk = pk;
        this.costoUnitarioBodega = costoUnitarioBodega;
        this.cantidadExistencia = cantidadExistencia;
    }

    // Getters y Setters
    public DetalleCostoBodegaPk getPk() {
        return pk;
    }

    public void setPk(DetalleCostoBodegaPk pk) {
        this.pk = pk;
    }

    public Float getCostoUnitarioBodega() {
        return costoUnitarioBodega;
    }

    public void setCostoUnitarioBodega(Float costoUnitarioBodega) {
        this.costoUnitarioBodega = costoUnitarioBodega;
    }

    public Integer getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(Integer cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
}
