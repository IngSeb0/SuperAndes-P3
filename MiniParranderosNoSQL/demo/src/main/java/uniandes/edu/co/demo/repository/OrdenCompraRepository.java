package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.OrdenCompra;

import java.util.List;

public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, String> {

    @Query("{'sucursal._id': ?0}")
    List<OrdenCompra> findBySucursalId(String sucursalId);


    @Query("{'proveedor._id': ?0}")
    List<OrdenCompra> findByProveedorId(String proveedorId);


    @Query("{'fechaCreacion': {$gte: ?0, $lte: ?1}}")
    List<OrdenCompra> findByFechaCreacionBetween(String fechaInicio, String fechaFin);
}
