package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Cliente;
import uniandes.edu.co.demo.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener cliente por cédula
    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> obtenerClientePorCedula(@PathVariable("cedula") Long cedula) {
        try {
            Cliente cliente = clienteRepository.obtenerClientePorCedula(cedula);
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar un nuevo cliente
    @PostMapping("/new/save")
    public ResponseEntity<String> insertarCliente(@RequestBody Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un cliente
    @PutMapping("/{cedula}/edit")
    public ResponseEntity<String> actualizarCliente(@PathVariable("cedula") Long cedula, @RequestBody Cliente cliente) {
        try {
            if (clienteRepository.existsById(cedula)) {
                cliente.setCedula(cedula);
                clienteRepository.save(cliente);
                return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un cliente por cédula
    @DeleteMapping("/{cedula}/delete")
    public ResponseEntity<String> eliminarCliente(@PathVariable("cedula") Long cedula) {
        try {
            if (clienteRepository.existsById(cedula)) {
                clienteRepository.eliminarClientePorCedula(cedula);
                return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
