package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Bodega;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BodegaRepository extends MongoRepository<Bodega, String> {

    // Obtener todas las bodegas
    List<Bodega> findAll();

    // Obtener bodegas por sucursal ID
    List<Bodega> findBySucursalId(String sucursalId);

    // Insertar una nueva bodega
    @Override
    <S extends Bodega> S save(S entity);

    // Eliminar una bodega por ID
    @Override
    void deleteById(String id);

    // Obtener inventario de productos en una bodega (simulado con ejemplo)
    @Query(value = "{ 'id': ?0 }", fields = "{ 'inventario': 1 }")
    List<Map<String, Object>> obtenerInventarioProductosBodega(String idBodega);

    // Obtener índice de ocupación de bodegas en una sucursal
    @Query(value = "{ 'sucursalId': ?0 }", fields = "{ 'nombreBodega': 1, 'tamanioBodega': 1 }")
    List<Map<String, Object>> obtenerIndiceOcupacionBodega(String idSucursal);

    // Obtener documentos de ingreso de productos por sucursal y bodega (simulación de consulta avanzada)
   
}
