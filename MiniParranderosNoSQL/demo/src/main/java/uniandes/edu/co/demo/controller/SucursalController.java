package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping
    public ResponseEntity<List<Sucursal>> obtenerSucursales() {
        try {
            List<Sucursal> sucursales = sucursalRepository.obtenerTodasLasSucursales();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerSucursalPorId(@PathVariable("id") String id) {
        try {
            Sucursal sucursal = sucursalRepository.obtenerSucursalPorId(id);
            return sucursal != null ? ResponseEntity.ok(sucursal) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> insertarSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.save(sucursal);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sucursal creada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la sucursal");
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<String> actualizarSucursal(@PathVariable("id") String id, @RequestBody Sucursal sucursal) {
        try {
            Sucursal sucursalExistente = sucursalRepository.findById(id).orElse(null);
            if (sucursalExistente != null) {
                sucursal.setIdSucursal(id);
                sucursalRepository.save(sucursal);
                return ResponseEntity.ok("Sucursal actualizada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sucursal no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la sucursal");
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarSucursal(@PathVariable("id") String id) {
        try {
            sucursalRepository.deleteById(id);
            return ResponseEntity.ok("Sucursal eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la sucursal");
        }
    }
}
