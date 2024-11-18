package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Ciudad;
import uniandes.edu.co.demo.repository.CiudadRepository;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    // Obtener todas las ciudades
    @GetMapping
    public ResponseEntity<List<Ciudad>> obtenerCiudades() {
        try {
            List<Ciudad> ciudades = ciudadRepository.obtenerTodasLasCiudades();
            return new ResponseEntity<>(ciudades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una ciudad por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerCiudadPorId(@PathVariable("id") Integer id) {
        try {
            Ciudad ciudad = ciudadRepository.obtenerCiudadPorId(id);
            if (ciudad != null) {
                return new ResponseEntity<>(ciudad, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar una nueva ciudad
    @PostMapping("/new/save")
    public ResponseEntity<String> insertarCiudad(@RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.save(ciudad);
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una ciudad por su ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarCiudad(@PathVariable("id") Integer id) {
        try {
            ciudadRepository.eliminarCiudadPorId(id);
            return new ResponseEntity<>("Ciudad eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
