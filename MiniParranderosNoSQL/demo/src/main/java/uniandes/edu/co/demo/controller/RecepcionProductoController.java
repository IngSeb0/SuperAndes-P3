package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.RecepcionProductos;
import uniandes.edu.co.demo.repository.RecepcionProductosRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/recepciones")
public class RecepcionProductoController {

    @Autowired
    private RecepcionProductosRepository recepcionProductoRepository;

    // Registrar una recepción de productos
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarRecepcionProducto(@RequestBody RecepcionProductos recepcionProducto) {
        try {
            // Validar si la orden de compra existe
            if (recepcionProducto.getOrdenCompra() == null) {
                return new ResponseEntity<>("La orden de compra es obligatoria", HttpStatus.BAD_REQUEST);
            }

            // Asignar la fecha actual
            recepcionProducto.setFechaRecepcion(LocalDate.now());

            // Guardar la recepción
            recepcionProductoRepository.save(recepcionProducto);
            return new ResponseEntity<>("Recepción registrada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar la recepción: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Listar todas las recepciones
    @GetMapping
    public ResponseEntity<List<RecepcionProductos>> obtenerTodasLasRecepciones() {
        try {
            List<RecepcionProductos> recepciones = recepcionProductoRepository.findAll();
            return new ResponseEntity<>(recepciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
