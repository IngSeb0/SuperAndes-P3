package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.repository.OrdenCompraRepository;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @GetMapping
    public List<OrdenCompra> getAllOrdenesCompra() {
        return ordenCompraRepository.findAll();
    }

    @PostMapping
    public OrdenCompra createOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    @GetMapping("/{id}")
    public OrdenCompra getOrdenCompraById(@PathVariable String id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public OrdenCompra updateOrdenCompra(@PathVariable String id, @RequestBody OrdenCompra updatedOrdenCompra) {
        return ordenCompraRepository.findById(id).map(ordenCompra -> {
            ordenCompra.setFechaCreacion(updatedOrdenCompra.getFechaCreacion());
            ordenCompra.setProveedor(updatedOrdenCompra.getProveedor());
            ordenCompra.setSucursal(updatedOrdenCompra.getSucursal());
            ordenCompra.setDetalle(updatedOrdenCompra.getDetalle());
            return ordenCompraRepository.save(ordenCompra);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdenCompra(@PathVariable String id) {
        ordenCompraRepository.deleteById(id);
    }
}
