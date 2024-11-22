package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable String id) {
        return productoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable String id, @RequestBody Producto updatedProducto) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(updatedProducto.getNombre());
            producto.setPrecio(updatedProducto.getPrecio());
            producto.setDetallesEmpacado(updatedProducto.getDetallesEmpacado());
            producto.setCategoria(updatedProducto.getCategoria());
            return productoRepository.save(producto);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
    }
}
