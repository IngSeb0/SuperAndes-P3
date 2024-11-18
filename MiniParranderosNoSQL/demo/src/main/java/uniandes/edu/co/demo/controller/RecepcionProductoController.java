package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.RecepcionProducto;
import uniandes.edu.co.demo.repository.RecepcionProductoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recepciones")
public class RecepcionProductoController {

    @Autowired
    private RecepcionProductoRepository recepcionProductoRepository;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarRecepcionProducto(@RequestBody RecepcionProducto recepcionProducto) {
        try {
            String fechaRecepcion = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            recepcionProducto.setFechaRecepcion(fechaRecepcion);
            recepcionProductoRepository.save(recepcionProducto);
            return new ResponseEntity<>("Recepción registrada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar la recepción: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<RecepcionProducto>> obtenerTodasLasRecepciones() {
        try {
            List<RecepcionProducto> recepciones = recepcionProductoRepository.obtenerTodasLasRecepciones();
            return new ResponseEntity<>(recepciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

