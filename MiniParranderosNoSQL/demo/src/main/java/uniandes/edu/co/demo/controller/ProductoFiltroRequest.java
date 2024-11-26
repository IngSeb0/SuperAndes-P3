package uniandes.edu.co.demo.controller;

public class ProductoFiltroRequest {

    private Double precioMin;
    private Double precioMax;
    private String fechaPosterior;
    private String fechaAnterior;
    private String sucursalId;
    private String categoriaNombre;

    public Double getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(Double precioMin) {
        this.precioMin = precioMin;
    }

    public Double getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(Double precioMax) {
        this.precioMax = precioMax;
    }

    public String getFechaPosterior() {
        return fechaPosterior;
    }

    public void setFechaPosterior(String fechaPosterior) {
        this.fechaPosterior = fechaPosterior;
    }

    public String getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(String fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }
}
