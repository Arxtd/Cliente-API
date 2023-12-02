package com.arthur.ordermanagerapi.web.controller;

import com.arthur.ordermanagerapi.entity.Cliente;
import com.arthur.ordermanagerapi.sevice.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("order-manager/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente novoCliente) {
        Cliente cliente = clienteService.salvar(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/atualizarCliente/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @PatchMapping("/removerCliente/{id}")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {
        Cliente clienteDeletado = clienteService.excluirCliente(id);
        System.err.println("Cliente: " + clienteDeletado.getNome() + " foi deletado com sucesso!");
        return ResponseEntity.ok(clienteDeletado);
    }

}
