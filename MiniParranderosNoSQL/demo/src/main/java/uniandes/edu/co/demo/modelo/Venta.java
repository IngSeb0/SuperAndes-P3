package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Ventas")
public class Venta implements Serializable {

    @Id
    private String idVenta;
    private Date fecha;
    private Long cantidadExistencia;

    private Sucursal sucursal;
    private Cliente cliente;
    private Proveedor proveedor;

    public Venta() {}

    public Venta(String idVenta, Date fecha, Long cantidadExistencia, Sucursal sucursal, Cliente cliente, Proveedor proveedor) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cantidadExistencia = cantidadExistencia;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.proveedor = proveedor;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(Long cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta='" + idVenta + '\'' +
                ", fecha=" + fecha +
                ", cantidadExistencia=" + cantidadExistencia +
                ", sucursal=" + sucursal +
                ", cliente=" + cliente +
                ", proveedor=" + proveedor +
                '}';
    }
}
