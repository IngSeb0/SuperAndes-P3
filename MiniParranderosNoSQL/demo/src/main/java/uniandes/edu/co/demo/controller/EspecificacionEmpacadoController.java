package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.EspecificacionEmpacado;
import uniandes.edu.co.demo.repository.EspecificacionEmpacadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/especificacionesEmpacado")
public class EspecificacionEmpacadoController {

    @Autowired
    private EspecificacionEmpacadoRepository especificacionEmpacadoRepository;

    // Obtener todas las especificaciones de empacado
    @GetMapping
    public ResponseEntity<List<EspecificacionEmpacado>> obtenerEspecificaciones() {
        try {
            List<EspecificacionEmpacado> especificaciones = especificacionEmpacadoRepository.obtenerTodasLasEspecificaciones();
            return new ResponseEntity<>(especificaciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una especificación de empacado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EspecificacionEmpacado> obtenerEspecificacionPorId(@PathVariable("id") String id) {
        EspecificacionEmpacado especificacion = especificacionEmpacadoRepository.obtenerEspecificacionPorId(id);
        if (especificacion != null) {
            return new ResponseEntity<>(especificacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar una nueva especificación de empacado
    @PostMapping("/new/save")
    public ResponseEntity<String> insertarEspecificacion(@RequestBody EspecificacionEmpacado especificacionEmpacado) {
        try {
            especificacionEmpacadoRepository.save(especificacionEmpacado);
            return new ResponseEntity<>("Especificación de empacado creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la especificación de empacado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una especificación de empacado por ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarEspecificacion(@PathVariable("id") String id) {
        try {
            especificacionEmpacadoRepository.deleteById(id);
            return new ResponseEntity<>("Especificación de empacado eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la especificación de empacado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
