package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Bodega;

import java.util.List;

public interface BodegaRepository extends MongoRepository<Bodega, String> {


    @Query("{'nombre': ?0}")
    List<Bodega> findByNombre(String nombre);

    @Query("{'productos._id': ?0}")
    List<Bodega> findByProductoId(String productoId);

    @Query("{'tamañoM2': {$gte: ?0}}")
    List<Bodega> findByTamañoMayorIgual(double tamañoM2);
}
