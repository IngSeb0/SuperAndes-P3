package uniandes.edu.co.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventarioService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Map<String, Object> generarInventarioSucursal(String sucursalId) {
        Sucursal sucursal = sucursalRepository.findSucursalWithBodegas(sucursalId);

        if (sucursal == null) {
            throw new RuntimeException("Sucursal no encontrada");
        }

        Map<String, Object> inventario = new HashMap<>();
        inventario.put("Sucursal", sucursal.getNombre());
        inventario.put("Direccion", sucursal.getDireccion());
        inventario.put("Ciudad", sucursal.getCiudad().getNombre());

        List<Bodega> bodegas = sucursal.getBodegas();
        Map<String, Object> detalleBodegas = new HashMap<>();

        for (Bodega bodega : bodegas) {
            Map<String, Object> detalleProductos = new HashMap<>();
            for (Producto producto : bodega.getProductos()) {
                Map<String, Object> detallesProducto = new HashMap<>();
                detallesProducto.put("Cantidad", 100); // Simulación: Extraer de la bodega
                detallesProducto.put("MinimoRequerido", 50); // Simulación: Valor configurado
                detallesProducto.put("CostoPromedio", 2000.0); // Simulación: Calcular basado en datos reales

                detalleProductos.put(producto.getNombre(), detallesProducto);
            }
            detalleBodegas.put(bodega.getNombre(), detalleProductos);
        }

        inventario.put("Bodegas", detalleBodegas);
        return inventario;
    }
}
