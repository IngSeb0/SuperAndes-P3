package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Categoria;

import java.util.List;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    // Consultar todas las categorías utilizando una consulta nativa de MongoDB
    @Query("{}")
    List<Categoria> obtenerTodasLasCategorias();

    // Consultar una categoría por su ID
    @Query("{codigoCategoria: ?0}")
    Categoria obtenerCategoriaPorId(String codigoCategoria);

    // Consultar categorías por nombre
    @Query("{'nombreCategoria': ?0}")
    List<Categoria> buscarCategoriasPorNombre(String nombreCategoria);

    // Eliminar una categoría por su ID
    @Query(value = "{codigoCategoria: ?0}", delete = true)
    void eliminarCategoriaPorId(String codigoCategoria);
}
