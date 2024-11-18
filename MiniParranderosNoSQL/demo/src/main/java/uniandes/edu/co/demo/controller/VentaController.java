package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Venta;
import uniandes.edu.co.demo.repository.VentaRepository;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable("id") String id) {
        Venta venta = ventaRepository.obtenerVentaPorId(id);
        if (venta != null) {
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> insertarVenta(@RequestBody Venta venta) {
        try {
            ventaRepository.save(venta);
            return new ResponseEntity<>("Venta creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<String> actualizarVenta(@PathVariable("id") String id, @RequestBody Venta venta) {
        try {
            if (ventaRepository.obtenerVentaPorId(id) != null) {
                venta.setIdVenta(id);
                ventaRepository.save(venta);
                return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarVenta(@PathVariable("id") String id) {
        try {
            if (ventaRepository.obtenerVentaPorId(id) != null) {
                ventaRepository.eliminarVentaPorId(id);
                return new ResponseEntity<>("Venta eliminada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
