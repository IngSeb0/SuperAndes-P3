package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.RecepcionProducto;
import java.util.List;

public interface RecepcionProductoRepository extends MongoRepository<RecepcionProducto, String> {

    // Obtener todas las recepciones de productos
    @Query("{}")
    List<RecepcionProducto> obtenerTodasLasRecepciones();
}
