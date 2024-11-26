package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Categoria;
import uniandes.edu.co.demo.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas las categorías
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerCategorias() {
        try {
            List<Categoria> categorias = categoriaRepository.findAll();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorCodigo(@PathVariable("id") String id) {
        try {
            // Utiliza findByCodigo y verifica que devuelva al menos un resultado
            List<Categoria> categorias = categoriaRepository.findByCodigo(id);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            // Devuelve el primer elemento de la lista
            return new ResponseEntity<>(categorias.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<String> insertarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCategoria(@PathVariable("id") String id, @RequestBody Categoria categoria) {
        try {
            return categoriaRepository.findById(id).map(existente -> {
                categoria.setCodigo(id); // Asegurarse de mantener el mismo ID
                categoriaRepository.save(categoria);
                return new ResponseEntity<>("Categoría actualizada exitosamente", HttpStatus.OK);
            }).orElse(new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la categoría: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable("id") String id) {
        try {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>("Categoría eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoría: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
