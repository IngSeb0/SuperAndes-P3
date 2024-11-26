package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;
import uniandes.edu.co.demo.service.InventarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    @PostMapping
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @GetMapping("/{id}")
    public Sucursal getSucursalById(@PathVariable String id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Sucursal updateSucursal(@PathVariable String id, @RequestBody Sucursal updatedSucursal) {
        return sucursalRepository.findById(id).map(sucursal -> {
            sucursal.setNombre(updatedSucursal.getNombre());
            sucursal.setDireccion(updatedSucursal.getDireccion());
            sucursal.setTelefono(updatedSucursal.getTelefono());
            sucursal.setCiudad(updatedSucursal.getCiudad());
            sucursal.setBodegas(updatedSucursal.getBodegas());
            return sucursalRepository.save(sucursal);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSucursal(@PathVariable String id) {
        sucursalRepository.deleteById(id);
    }
    @GetMapping("/{id}/inventario")
    public ResponseEntity<?> getInventarioSucursal(@PathVariable String id) {
        try {
            Map<String, Object> inventario = inventarioService.generarInventarioSucursal(id);
            return ResponseEntity.ok(inventario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el inventario: " + e.getMessage());
        }
    }
}
