package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Categoria;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.CategoriaRepository;
import uniandes.edu.co.demo.repository.ProductoRepository;

import java.util.List;
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/filtrar")
    public ResponseEntity<?> filtrarProductos(@RequestBody ProductoFiltroRequest filtroRequest) {
        try {
            List<Producto> productos = productoRepository.findAll();

            if (filtroRequest.getPrecioMin() != null && filtroRequest.getPrecioMax() != null) {
                productos = productos.stream()
                        .filter(p -> p.getPrecio() >= filtroRequest.getPrecioMin() && p.getPrecio() <= filtroRequest.getPrecioMax())
                        .toList();
            }

            if (filtroRequest.getFechaPosterior() != null) {
                productos = productos.stream()
                        .filter(p -> p.getFechaVencimiento() != null && p.getFechaVencimiento().compareTo(filtroRequest.getFechaPosterior()) >= 0)
                        .toList();
            }

            if (filtroRequest.getFechaAnterior() != null) {
                productos = productos.stream()
                        .filter(p -> p.getFechaVencimiento() != null && p.getFechaVencimiento().compareTo(filtroRequest.getFechaAnterior()) <= 0)
                        .toList();
            }

            if (filtroRequest.getSucursalId() != null) {
                productos = productos.stream()
                        .filter(p -> p.getSucursalId() != null && p.getSucursalId().equals(filtroRequest.getSucursalId()))
                        .toList();
            }

            if (filtroRequest.getCategoriaNombre() != null) {
                productos = productos.stream()
                        .filter(p -> p.getCategoria() != null && p.getCategoria().getNombre().equalsIgnoreCase(filtroRequest.getCategoriaNombre()))
                        .toList();
            }

            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al filtrar productos: " + e.getMessage());
        }
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        Categoria categoria = categoriaRepository.findByCodigo(producto.getCategoria().getCodigo())
                .stream().findFirst().orElse(null);
        if (categoria == null) {
            return new ResponseEntity<>("Categoría no encontrada", HttpStatus.BAD_REQUEST);
        }
        producto.setCategoria(categoria);
        productoRepository.save(producto);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        return productoRepository.findById(id)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable String id, @RequestBody Producto updatedProducto) {
        return productoRepository.findById(id).map(producto -> {
            Categoria categoria = categoriaRepository.findByCodigo(updatedProducto.getCategoria().getCodigo())
                    .stream().findFirst().orElse(null);
            if (categoria == null) {
                return new ResponseEntity<>("Categoría no encontrada", HttpStatus.BAD_REQUEST);
            }
            producto.setNombre(updatedProducto.getNombre());
            producto.setPrecio(updatedProducto.getPrecio());
            producto.setDetallesEmpacado(updatedProducto.getDetallesEmpacado());
            producto.setCategoria(categoria);
            productoRepository.save(producto);
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND));
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
        return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
    }
}
