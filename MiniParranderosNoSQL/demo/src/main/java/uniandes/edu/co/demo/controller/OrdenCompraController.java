package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.Proveedor;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.OrdenCompraRepository;
import uniandes.edu.co.demo.repository.ProveedorRepository;
import uniandes.edu.co.demo.repository.SucursalRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todas las órdenes de compra
    @GetMapping
    public ResponseEntity<List<OrdenCompra>> getAllOrdenesCompra() {
        return new ResponseEntity<>(ordenCompraRepository.findAll(), HttpStatus.OK);
    }

    // Crear una nueva orden de compra
    @PostMapping
    public ResponseEntity<String> createOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        try {
            // Validar la sucursal
            Sucursal sucursal = sucursalRepository.findById(ordenCompra.getSucursalId()).orElse(null);
            if (sucursal == null) {
                return new ResponseEntity<>("La sucursal no existe", HttpStatus.BAD_REQUEST);
            }

            // Validar el proveedor
            Proveedor proveedor = proveedorRepository.findById(ordenCompra.getProveedorId()).orElse(null);
            if (proveedor == null) {
                return new ResponseEntity<>("El proveedor no existe", HttpStatus.BAD_REQUEST);
            }

            // Asignar la fecha de creación como la fecha actual
            String fechaCreacion = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ordenCompra.setFechaCreacion(fechaCreacion);
            ordenCompra.setEstado("vigente");
            // Guardar la orden de compra
            ordenCompraRepository.save(ordenCompra);
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una orden de compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdenCompraById(@PathVariable String id) {
        try {
            // Buscar la orden de compra por ID
            Optional<OrdenCompra> optionalOrden = ordenCompraRepository.findById(id);
    
            if (optionalOrden.isPresent()) {
                OrdenCompra ordenCompra = optionalOrden.get();
    
                // Buscar datos adicionales
                Sucursal sucursal = sucursalRepository.findById(ordenCompra.getSucursalId()).orElse(null);
                Proveedor proveedor = proveedorRepository.findById(ordenCompra.getProveedorId()).orElse(null);
    
                // Construir respuesta enriquecida
                var response = new Object() {
                    public final OrdenCompra orden = ordenCompra;
                    public final Sucursal sucursalInfo = sucursal;
                    public final Proveedor proveedorInfo = proveedor;
                };
    
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Orden de compra no encontrada");
            }
        } catch (Exception e) {
            // Manejo de errores genéricos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar la orden de compra: " + e.getMessage());
        }
    }
    
    
   // Actualizar una orden de compra existente
@PutMapping("/{id}")
public ResponseEntity<String> updateOrdenCompra(@PathVariable String id, @RequestBody OrdenCompra updatedOrdenCompra) {
    try {
        return ordenCompraRepository.findById(id).map(ordenCompra -> {
            // Validar la sucursal y asignarla al objeto
            Sucursal sucursal = sucursalRepository.findById(updatedOrdenCompra.getSucursalId())
                    .orElseThrow(() -> new IllegalArgumentException("La sucursal no existe"));

            // Validar el proveedor y asignarlo al objeto
            Proveedor proveedor = proveedorRepository.findById(updatedOrdenCompra.getProveedorId())
                    .orElseThrow(() -> new IllegalArgumentException("El proveedor no existe"));

            // Actualizar los campos
            ordenCompra.setSucursalId(sucursal.getId());
            ordenCompra.setProveedorId(proveedor.getNit());
            ordenCompra.setDetalle(updatedOrdenCompra.getDetalle());

       

            ordenCompraRepository.save(ordenCompra);
            return new ResponseEntity<>("Orden de compra actualizada exitosamente", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Orden de compra no encontrada", HttpStatus.NOT_FOUND));
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
        return new ResponseEntity<>("Error al actualizar la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    // Eliminar una orden de compra por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrdenCompra(@PathVariable String id) {
        ordenCompraRepository.deleteById(id);
        return new ResponseEntity<>("Orden de compra eliminada exitosamente", HttpStatus.OK);
    }
}
