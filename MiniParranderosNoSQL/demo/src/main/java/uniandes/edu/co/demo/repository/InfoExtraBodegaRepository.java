package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.InfoExtraBodega;

import java.util.List;

public interface InfoExtraBodegaRepository extends MongoRepository<InfoExtraBodega, String> {

    // Obtener toda la información de extra bodega
    @Query("{}")
    List<InfoExtraBodega> obtenerTodaLaInfoExtraBodega();

    // Obtener una info extra bodega por ID de bodega y producto (referencias manuales)
    @Query("{ 'bodega.$id': ?0, 'producto.$id': ?1 }")
    InfoExtraBodega obtenerInfoExtraBodegaPorBodegaYProducto(String bodegaId, String productoId);
}
