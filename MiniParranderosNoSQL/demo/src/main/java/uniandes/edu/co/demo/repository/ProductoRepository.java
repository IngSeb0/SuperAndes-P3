package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Consulta un producto por su código de barras
    Optional<Producto> findByCodigoBarras(String codigoBarras);

    // Consultar productos por nombre
    @Query("{ 'nombre': ?0 }")
    List<Producto> findByNombre(String nombre);

    // Consultar productos con precio menor o igual a un valor dado
    @Query("{ 'precioUnitarioVenta': { $lte: ?0 } }")
    List<Producto> findByPrecioUnitarioVentaLessThanEqual(Float precio);
}
