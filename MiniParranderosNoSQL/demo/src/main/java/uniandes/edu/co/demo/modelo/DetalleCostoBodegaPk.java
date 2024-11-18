package uniandes.edu.co.demo.modelo;

import java.io.Serializable;

public class DetalleCostoBodegaPk implements Serializable {

    private Long idBodega;
    private String codigoBarras;
    private Long idDetalleCosto;

    public DetalleCostoBodegaPk() {}

    public DetalleCostoBodegaPk(Long idBodega, String codigoBarras, Long idDetalleCosto) {
        this.idBodega = idBodega;
        this.codigoBarras = codigoBarras;
        this.idDetalleCosto = idDetalleCosto;
    }

    // Getters y Setters
    public Long getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Long idBodega) {
        this.idBodega = idBodega;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Long getIdDetalleCosto() {
        return idDetalleCosto;
    }

    public void setIdDetalleCosto(Long idDetalleCosto) {
        this.idDetalleCosto = idDetalleCosto;
    }
}
