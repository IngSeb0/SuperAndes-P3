package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        try {
            List<Producto> productos = productoRepository.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un producto por su código de barras
    @GetMapping("/{codigoBarras}")
    public ResponseEntity<Producto> obtenerProductoPorCodigoBarras(@PathVariable String codigoBarras) {
        Optional<Producto> producto = productoRepository.findByCodigoBarras(codigoBarras);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo producto
    @PostMapping("/new/save")
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        try {
            productoRepository.save(producto);
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto
    @PutMapping("/{codigoBarras}/edit")
    public ResponseEntity<String> actualizarProducto(@PathVariable String codigoBarras, @RequestBody Producto producto) {
        try {
            if (productoRepository.existsById(codigoBarras)) {
                producto.setCodigoBarras(codigoBarras);
                productoRepository.save(producto);
                return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{codigoBarras}/delete")
    public ResponseEntity<String> eliminarProducto(@PathVariable String codigoBarras) {
        try {
            if (productoRepository.existsById(codigoBarras)) {
                productoRepository.deleteById(codigoBarras);
                return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
