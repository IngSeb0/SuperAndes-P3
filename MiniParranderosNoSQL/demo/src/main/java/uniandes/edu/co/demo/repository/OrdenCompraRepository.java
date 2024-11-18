package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import java.util.List;

public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, String> {

    @Query("{}")
    List<OrdenCompra> obtenerTodasLasOrdenes();

    @Query("{ '_id': ?0 }")
    OrdenCompra obtenerOrdenPorId(String id);

    @Query("{ 'proveedor.nit': ?0 }")
    List<OrdenCompra> obtenerOrdenesPorProveedor(String nit);
}
