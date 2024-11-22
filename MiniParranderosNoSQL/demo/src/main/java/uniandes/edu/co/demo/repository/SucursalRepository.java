package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Sucursal;

import java.util.List;

public interface SucursalRepository extends MongoRepository<Sucursal, String> {

    // Buscar sucursales por ciudad (nombre exacto)
    @Query("{'ciudad.nombre': ?0}")
    List<Sucursal> findByCiudadNombre(String ciudadNombre);

    // Buscar sucursales por dirección
    @Query("{'direccion': ?0}")
    List<Sucursal> findByDireccion(String direccion);

    // Buscar sucursales que contengan una bodega específica (por nombre de bodega)
    @Query("{'bodegas.nombre': ?0}")
    List<Sucursal> findByBodegaNombre(String bodegaNombre);
    @Query("{'_id': ?0}")
    Sucursal findSucursalWithBodegas(String sucursalId);
}
