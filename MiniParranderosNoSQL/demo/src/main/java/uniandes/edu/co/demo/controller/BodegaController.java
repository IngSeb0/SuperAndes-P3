package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.repository.BodegaRepository;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping
    public List<Bodega> getAllBodegas() {
        return bodegaRepository.findAll();
    }

    @PostMapping
    public Bodega createBodega(@RequestBody Bodega bodega) {
        return bodegaRepository.save(bodega);
    }

    @GetMapping("/{id}")
    public Bodega getBodegaById(@PathVariable String id) {
        return bodegaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Bodega updateBodega(@PathVariable String id, @RequestBody Bodega updatedBodega) {
        return bodegaRepository.findById(id).map(bodega -> {
            bodega.setNombre(updatedBodega.getNombre());
            bodega.setTamañoM2(updatedBodega.getTamañoM2());
            bodega.setProductos(updatedBodega.getProductos());
            return bodegaRepository.save(bodega);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBodega(@PathVariable String id) {
        bodegaRepository.deleteById(id);
    }
}
