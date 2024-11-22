package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class DetalleOrden {

    private String productoId;
    private int cantidad;
    private double precio;

    // Constructor sin parámetros
    public DetalleOrden() {
    }

    // Constructor con todos los parámetros
    public DetalleOrden(String productoId, int cantidad, double precio) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
