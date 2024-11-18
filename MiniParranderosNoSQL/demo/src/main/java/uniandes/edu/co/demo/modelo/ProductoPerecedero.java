package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductosPerecederos") 
public class ProductoPerecedero {

    @Id
    private String codigoBarras;  

    private String fechaVencimiento;  

    public ProductoPerecedero() {}

    public ProductoPerecedero(String codigoBarras, String fechaVencimiento) {
        this.codigoBarras = codigoBarras;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y setters
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "ProductoPerecedero{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                '}';
    }
}
