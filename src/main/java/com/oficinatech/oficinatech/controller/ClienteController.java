package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.model.Cliente;
import com.oficinatech.oficinatech.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        if (busca != null && !busca.isBlank()) {
            model.addAttribute("clientes", clienteRepository.findByNomeContainingIgnoreCase(busca));
        } else {
            model.addAttribute("clientes", clienteRepository.findAll());
        }
        return "clientes-lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }
}