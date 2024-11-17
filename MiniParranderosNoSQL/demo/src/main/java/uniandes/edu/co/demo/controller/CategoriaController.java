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
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable("id") String id) {
        try {
            Categoria categoria = categoriaRepository.obtenerCategoriaPorId(id);
            if (categoria != null) {
                return new ResponseEntity<>(categoria, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> insertarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarCategoria(@PathVariable("id") String id, @RequestBody Categoria categoria) {
        try {
            Categoria existente = categoriaRepository.obtenerCategoriaPorId(id);
            if (existente != null) {
                categoria.setCodigoCategoria(id);
                categoriaRepository.save(categoria);
                return new ResponseEntity<>("Categoría actualizada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarCategoria(@PathVariable("id") String id) {
        try {
            categoriaRepository.eliminarCategoriaPorId(id);
            return new ResponseEntity<>("Categoría eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
