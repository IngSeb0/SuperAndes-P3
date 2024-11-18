package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Venta;
import java.util.List;

public interface VentaRepository extends MongoRepository<Venta, String> {

    @Query("{}")
    List<Venta> obtenerTodasLasVentas();

    @Query("{'idVenta': ?0}")
    Venta obtenerVentaPorId(String idVenta);

    @Query(value = "{'idVenta': ?0}", delete = true)
    void eliminarVentaPorId(String idVenta);

    @Query("{'sucursal.idSucursal': ?0}")
    List<Venta> obtenerVentasPorSucursal(Long idSucursal);
}
