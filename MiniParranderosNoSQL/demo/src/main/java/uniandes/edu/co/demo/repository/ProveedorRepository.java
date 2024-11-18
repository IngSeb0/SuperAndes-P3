package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Proveedor;
import java.util.List;

public interface ProveedorRepository extends MongoRepository<Proveedor, Long> {

    // Obtener todos los proveedores
    @Query("{}")
    List<Proveedor> obtenerTodosLosProveedores();

    // Obtener proveedor por NIT
    @Query("{ 'nit': ?0 }")
    Proveedor obtenerProveedorPorNit(Long nit);

    
}
