package com.umg.biblioteca.controller;

import com.umg.biblioteca.exception.ResourceNotFoundException;
import com.umg.biblioteca.model.Cliente;
import com.umg.biblioteca.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    private List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
@GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> listarClientePorId(@PathVariable long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado : " + id));
        return ResponseEntity.ok(cliente);
    }
@PutMapping("/Clientes/{id}")
   public ResponseEntity<Cliente> editarCliente(@PathVariable long id, @RequestBody Cliente clienteRequest){
    Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado : " + id));
    cliente.setNombres(clienteRequest.getNombres());
    cliente.setApellido1(clienteRequest.getApellido1());
    cliente.setApellido2(clienteRequest.getApellido2());
    cliente.setGeneroPersonaId(clienteRequest.getGeneroPersonaId());
    cliente.setFechaNacimiento(clienteRequest.getFechaNacimiento());
    cliente.setIdiomaId(clienteRequest.getIdiomaId());
    cliente.setGrupoEtnicoId(clienteRequest.getGrupoEtnicoId());
    cliente.setNivelEscolarId(clienteRequest.getNivelEscolarId());
    cliente.setTelefono(clienteRequest.getTelefono());
    cliente.setEmail(clienteRequest.getEmail());
    cliente.setDepartamentoId(clienteRequest.getDepartamentoId());
    cliente.setMunicipioId(clienteRequest.getMunicipioId());
    cliente.setEstadoClId(clienteRequest.getEstadoClId());
    Cliente clienteActualizado = clienteRepository.save(cliente);
    return ResponseEntity.ok(clienteActualizado);
   }

   public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable long id){

       Cliente cliente = clienteRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado : " + id));
       clienteRepository.delete(cliente);
       Map<String,Boolean> response = new HashMap<>();
       response.put("delete",Boolean.TRUE);
       return ResponseEntity.ok(response);
   }

}
