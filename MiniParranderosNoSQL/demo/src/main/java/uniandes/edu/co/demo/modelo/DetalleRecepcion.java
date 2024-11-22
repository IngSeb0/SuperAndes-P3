package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class DetalleRecepcion {

    private String productoId;
    private int cantidad;

    // Constructor sin parámetros
    public DetalleRecepcion() {
    }

    // Constructor con todos los parámetros
    public DetalleRecepcion(String productoId, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
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
}
