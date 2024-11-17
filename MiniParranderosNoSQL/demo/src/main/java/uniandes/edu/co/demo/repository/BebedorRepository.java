package uniandes.edu.co.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Bebedor;

public interface BebedorRepository extends MongoRepository<Bebedor, Integer> {

    // Consultar todos los bebedores utilizando una consulta nativa de MongoDB
    @Query("{}")
    List<Bebedor> buscarTodosLosBebedores();

    // Consultar bebedor por su ID
    @Query("{_id: ?0}")
    Bebedor buscarBebedorPorId(int id);

    // Consultar bebedores por ciudad
    @Query("{'ciudad': ?0}")
    List<Bebedor> buscarBebedoresPorCiudad(String ciudad);

    // Eliminar un bebedor por su ID
    @Query(value = "{_id: ?0}", delete = true)
    void eliminarBebedorPorId(int id);
}
