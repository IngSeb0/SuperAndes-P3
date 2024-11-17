package uniandes.edu.co.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Bebedor;
import uniandes.edu.co.demo.repository.BebedorRepository;

@RestController
public class BebedoresController {

    @Autowired
    private BebedorRepository bebedorRepository;

    // Obtener todos los bebedores
    @GetMapping("/bebedores")
    public ResponseEntity<Collection<Bebedor>> obtenerTodosLosBebedores() {
        try {
            // Llamar al método definido en el repositorio para obtener todos los registros
            List<Bebedor> bebedores = bebedorRepository.buscarTodosLosBebedores();

            return ResponseEntity.ok(bebedores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener bebedor por ID
    @GetMapping("/bebedores/{id}")
    public ResponseEntity<Bebedor> obtenerBebedorPorId(@PathVariable("id") int id) {
        try {
            Bebedor bebedor = bebedorRepository.buscarBebedorPorId(id);
            if (bebedor != null) {
                return ResponseEntity.ok(bebedor);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Crear un nuevo bebedor
    @PostMapping("/bebedores/new/save")
    public ResponseEntity<String> guardarBebedor(@RequestBody Bebedor bebedor) {
        try {
            bebedorRepository.save(bebedor);
            return new ResponseEntity<>("Bebedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un bebedor existente
    @PostMapping("/bebedores/{id}/edit/save")
    public ResponseEntity<String> editarGuardarBebedor(@PathVariable("id") int id, @RequestBody Bebedor bebedor) {
        try {
            bebedor.setId(id);
            bebedorRepository.save(bebedor);
            return new ResponseEntity<>("Bebedor actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un bebedor por ID
    @DeleteMapping("/bebedores/{id}/delete")
    public ResponseEntity<String> eliminarBebedor(@PathVariable("id") int id) {
        try {
            bebedorRepository.eliminarBebedorPorId(id);
            return new ResponseEntity<>("Bebedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el bebedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
