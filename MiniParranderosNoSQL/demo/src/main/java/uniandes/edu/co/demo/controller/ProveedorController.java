package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Proveedor;
import uniandes.edu.co.demo.repository.ProveedorRepository;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable String id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable String id, @RequestBody Proveedor updatedProveedor) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setNombre(updatedProveedor.getNombre());
            proveedor.setContacto(updatedProveedor.getContacto());
            proveedor.setProductos(updatedProveedor.getProductos());
            return proveedorRepository.save(proveedor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable String id) {
        proveedorRepository.deleteById(id);
    }
}
