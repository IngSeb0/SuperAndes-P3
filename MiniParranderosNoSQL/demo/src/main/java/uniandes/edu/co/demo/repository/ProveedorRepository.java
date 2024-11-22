package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Proveedor;

import java.util.List;

public interface ProveedorRepository extends MongoRepository<Proveedor, String> {

  
    @Query("{'nombre': ?0}")
    List<Proveedor> findByNombre(String nombre);


    @Query("{'productos._id': ?0}")
    List<Proveedor> findByProductoId(String productoId);
}
