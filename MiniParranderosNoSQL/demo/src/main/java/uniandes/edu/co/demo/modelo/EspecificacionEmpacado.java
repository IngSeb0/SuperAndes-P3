package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EspecificacionesEmpacado")
public class EspecificacionEmpacado {

    @Id
    private String idEspecificacion;

    private Float volumen;
    private Float peso;

    public EspecificacionEmpacado() {}

    public EspecificacionEmpacado(Float volumen, Float peso) {
        this.volumen = volumen;
        this.peso = peso;
    }

    public String getIdEspecificacionEmpacado() {
        return idEspecificacion;
    }

    public void setIdEspecificacionEmpacado(String idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    public Float getVolumen() {
        return volumen;
    }

    public void setVolumen(Float volumen) {
        this.volumen = volumen;
    }

    public Float getPesoGr() {
        return peso;
    }

    public void setPesoGr(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "EspecificacionEmpacado{" +
                "idEspecificacion='" + idEspecificacion + '\'' +
                ", volumen=" + volumen +
                ", peso=" + peso +
                '}';
    }
}
