package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.repository.BodegaRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    // Obtener todas las bodegas
    @GetMapping
    public ResponseEntity<List<Bodega>> obtenerBodegas() {
        try {
            List<Bodega> bodegas = bodegaRepository.findAll();
            return new ResponseEntity<>(bodegas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener bodegas por sucursal ID
    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<Bodega>> obtenerBodegasPorSucursal(@PathVariable String idSucursal) {
        try {
            List<Bodega> bodegas = bodegaRepository.findBySucursalId(idSucursal);
            if (bodegas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(bodegas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear una nueva bodega
    @PostMapping("/new")
    public ResponseEntity<Bodega> crearBodega(@RequestBody Bodega bodega) {
        try {
            Bodega nuevaBodega = bodegaRepository.save(bodega);
            return new ResponseEntity<>(nuevaBodega, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una bodega existente
    @PutMapping("/{id}")
    public ResponseEntity<Bodega> actualizarBodega(@PathVariable String id, @RequestBody Bodega bodega) {
        try {
            if (bodegaRepository.existsById(id)) {
                bodega.setId(id);
                Bodega bodegaActualizada = bodegaRepository.save(bodega);
                return new ResponseEntity<>(bodegaActualizada, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una bodega por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarBodega(@PathVariable String id) {
        try {
            if (bodegaRepository.existsById(id)) {
                bodegaRepository.deleteById(id);
                return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Bodega no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener inventario de productos en una bodega
    @GetMapping("/{idBodega}/inventario")
    public ResponseEntity<List<Map<String, Object>>> obtenerInventarioBodega(@PathVariable String idBodega) {
        try {
            List<Map<String, Object>> inventario = bodegaRepository.obtenerInventarioProductosBodega(idBodega);
            if (inventario.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(inventario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener índice de ocupación de bodegas en una sucursal
    @GetMapping("/{idSucursal}/ocupacion")
    public ResponseEntity<List<Map<String, Object>>> obtenerIndiceOcupacionBodegas(@PathVariable String idSucursal) {
        try {
            List<Map<String, Object>> ocupacion = bodegaRepository.obtenerIndiceOcupacionBodega(idSucursal);
            if (ocupacion.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ocupacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}