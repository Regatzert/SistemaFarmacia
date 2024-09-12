package com.kevin.Farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.Farmacia.model.Cliente;
import com.kevin.Farmacia.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@Validated
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping //Metodo para guardar un nuevo cliente
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody Cliente cliente){
        Cliente guardarcliente = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(guardarcliente, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los clientes
    public ResponseEntity<List<Cliente>> getAllCliente(){
        List<Cliente> listClientes = clienteService.findClientes();
        return ResponseEntity.ok(listClientes);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo cliente por ID
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id){
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
