package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Producto;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    @Query("{'precio': {$gte: ?0, $lte: ?1}}")
    List<Producto> findByPrecioBetween(double precioMin, double precioMax);

    @Query("{'fechaVencimiento': {$gte: ?0}}")
    List<Producto> findByFechaVencimientoPosterior(String fechaPosterior);

    @Query("{'fechaVencimiento': {$lte: ?0}}")
    List<Producto> findByFechaVencimientoAnterior(String fechaAnterior);

    @Query("{'sucursalId': ?0}")
    List<Producto> findBySucursalId(String sucursalId);

    @Query("{'categoria.nombre': ?0}")
    List<Producto> findByCategoriaNombre(String categoriaNombre);
}
