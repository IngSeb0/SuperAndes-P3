package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Sucursal;

import java.util.List;

public interface SucursalRepository extends MongoRepository<Sucursal, String> {

    @Query("{}")
    List<Sucursal> obtenerTodasLasSucursales();

    @Query("{ 'idSucursal': ?0 }")
    Sucursal obtenerSucursalPorId(String id);

    @Query("{ 'ciudad.codigoCiudad': ?0 }")
    List<Sucursal> obtenerSucursalesPorCodigoCiudad(Integer codigoCiudad);

    @Query("{ $or: [ { 'producto.idProducto': ?0 }, { 'producto.nombre': ?1 } ] }")
    List<Sucursal> obtenerSucursalesConProductoDisponible(String productoId, String nombreProducto);
}
