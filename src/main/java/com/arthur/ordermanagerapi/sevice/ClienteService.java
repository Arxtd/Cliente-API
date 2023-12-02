package com.arthur.ordermanagerapi.sevice;

import com.arthur.ordermanagerapi.entity.Cliente;
import com.arthur.ordermanagerapi.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAllByActive();
    }

    @Transactional
    public Cliente excluirCliente(Long id) {
        try {
            Cliente clienteDeletado = buscarPorId(id);
            clienteDeletado.setActive(false);
            clienteDeletado.setDataEdicao(new Date());

            return clienteRepository.save(clienteDeletado);
        } catch (Exception e) {
            System.err.println("Erro ao excluir o cliente");
            System.err.println(e);
        }

        return null;
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        try {
            Cliente clienteAtualizado = buscarPorId(id);

            clienteAtualizado.setDataEdicao(new Date());
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setCpf(cliente.getCpf());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setCnpj(cliente.getCnpj());

            return clienteRepository.save(clienteAtualizado);
        } catch(Exception e ) {
            System.err.println("Erro ao atualizar o cliente");
            System.err.println(e);
        }

        return null;
    }
}
