package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Ciudad;

import java.util.List;

public interface CiudadRepository extends MongoRepository<Ciudad, Integer> {

    // Obtener todas las ciudades
    @Query("{}")
    List<Ciudad> obtenerTodasLasCiudades();

    // Obtener una ciudad por su ID
    @Query("{'_id': ?0}")
    Ciudad obtenerCiudadPorId(Integer codigoCiudad);

    // Eliminar una ciudad por su ID
    @Query(value = "{'_id': ?0}", delete = true)
    void eliminarCiudadPorId(Integer codigoCiudad);
}
