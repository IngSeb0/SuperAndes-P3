package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Cliente;
import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {

    // Obtener todos los clientes
    @Query("{}")
    List<Cliente> obtenerTodosLosClientes();

    // Obtener cliente por cédula
    @Query("{'_id': ?0}")
    Cliente obtenerClientePorCedula(Long cedula);

    // Eliminar un cliente por cédula
    @Query(value = "{'_id': ?0}", delete = true)
    void eliminarClientePorCedula(Long cedula);
}
