package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.RecepcionProductos;

import java.util.List;

public interface RecepcionProductosRepository extends MongoRepository<RecepcionProductos, String> {

    @Query("{'ordenCompra._id': ?0}")
    List<RecepcionProductos> findByOrdenCompraId(String ordenCompraId);

    @Query("{'detalle.productoId': ?0}")
    List<RecepcionProductos> findByProductoId(String productoId);


    @Query("{'detalle.cantidad': ?0}")
    List<RecepcionProductos> findByCantidad(int cantidad);
}
