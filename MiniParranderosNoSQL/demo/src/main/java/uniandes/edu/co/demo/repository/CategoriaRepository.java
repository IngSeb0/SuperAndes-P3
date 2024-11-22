package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Categoria;

import java.util.List;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {


    @Query("{'nombre': ?0}")
    List<Categoria> findByNombre(String nombre);

    @Query("{'descripcion': {$regex: ?0, $options: 'i'}}")
    List<Categoria> findByDescripcionContaining(String descripcion);

    @Query("{'codigo': ?0}")
    List<Categoria> findByCodigo(String codigo);
}
