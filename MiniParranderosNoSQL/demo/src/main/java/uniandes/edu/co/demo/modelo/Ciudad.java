package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ciudades")
public class Ciudad {
    @Id
    private Integer codigoCiudad;
    private String nombreCiudad;

    public Ciudad() {}

    public Ciudad(Integer codigoCiudad, String nombreCiudad) {
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Integer codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "codigoCiudad=" + codigoCiudad +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                '}';
    }
}
