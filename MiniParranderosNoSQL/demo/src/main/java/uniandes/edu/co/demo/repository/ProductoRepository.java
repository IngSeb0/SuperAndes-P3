package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Producto;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    @Query("{'nombre': ?0}")
    List<Producto> findByNombre(String nombre);

    @Query("{'categoria.nombre': ?0}")
    List<Producto> findByCategoriaNombre(String categoriaNombre);

    @Query("{'precio': {$gte: ?0, $lte: ?1}}")
    List<Producto> findByPrecioBetween(double precioMin, double precioMax);
}
