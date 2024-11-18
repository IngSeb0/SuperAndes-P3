package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.EspecificacionEmpacado;

import java.util.List;

public interface EspecificacionEmpacadoRepository extends MongoRepository<EspecificacionEmpacado, String> {

    // Consultar todas las especificaciones de empacado
    @Query("{}")
    List<EspecificacionEmpacado> obtenerTodasLasEspecificaciones();

    // Consultar una especificación de empacado por ID
    @Query("{'_id': ?0}")
    EspecificacionEmpacado obtenerEspecificacionPorId(String id);
}
