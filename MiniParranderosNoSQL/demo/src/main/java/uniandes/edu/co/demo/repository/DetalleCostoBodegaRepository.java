package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.DetalleCostoBodega;
import uniandes.edu.co.demo.modelo.DetalleCostoBodegaPk;

import java.util.List;

public interface DetalleCostoBodegaRepository extends MongoRepository<DetalleCostoBodega, DetalleCostoBodegaPk> {

    // Obtener todos los detalles de costos de bodega
    @Query("{}")
    List<DetalleCostoBodega> obtenerTodosLosDetallesCostoBodega();

    // Obtener un detalle de costo por clave compuesta
    @Query("{ '_id.idBodega': ?0, '_id.codigoBarras': ?1, '_id.idDetalleCosto': ?2 }")
    DetalleCostoBodega obtenerDetalleCostoBodegaPorId(Long idBodega, String codigoBarras, Long idDetalleCosto);

    // Eliminar un detalle de costo por clave compuesta
    @Query(value = "{ '_id.idBodega': ?0, '_id.codigoBarras': ?1, '_id.idDetalleCosto': ?2 }", delete = true)
    void eliminarDetalleCostoBodega(Long idBodega, String codigoBarras, Long idDetalleCosto);
}
