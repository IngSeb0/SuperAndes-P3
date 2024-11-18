package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Proveedor;
import uniandes.edu.co.demo.repository.ProveedorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerProveedores() {
        try {
            List<Proveedor> proveedores = proveedorRepository.obtenerTodosLosProveedores();
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un proveedor por NIT
    @GetMapping("/{nit}")
    public ResponseEntity<Proveedor> obtenerProveedorPorNit(@PathVariable("nit") Long nit) {
        Proveedor proveedor = proveedorRepository.obtenerProveedorPorNit(nit);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Insertar un nuevo proveedor
    @PostMapping("/new/save")
    public ResponseEntity<String> insertarProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorRepository.save(proveedor);
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un proveedor por NIT
    @PutMapping("/{nit}/edit")
    public ResponseEntity<String> actualizarProveedor(@PathVariable("nit") Long nit, @RequestBody Proveedor proveedor) {
        try {
            if (proveedorRepository.existsById(nit)) {
                proveedor.setNit(nit);
                proveedorRepository.save(proveedor);
                return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un proveedor por NIT
    @DeleteMapping("/{nit}/delete")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("nit") Long nit) {
        try {
            if (proveedorRepository.existsById(nit)) {
                proveedorRepository.deleteById(nit);
                return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
