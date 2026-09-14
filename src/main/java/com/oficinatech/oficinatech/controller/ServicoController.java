package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.model.Servico;
import com.oficinatech.oficinatech.repository.ClienteRepository;
import com.oficinatech.oficinatech.repository.ServicoRepository;
import java.security.SecureRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private static final String CARACTERES = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public ServicoController(ServicoRepository servicoRepository, ClienteRepository clienteRepository) {
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicos", servicoRepository.findAll());
        return "servicos-lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "servicos-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Servico servico) {
        servico.setCodigoAcompanhamento(gerarCodigo());
        servicoRepository.save(servico);
        return "redirect:/servicos";
    }

    @PostMapping("/{id}/status")
    public String atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        Servico servico = servicoRepository.findById(id).orElseThrow();
        servico.setStatus(status);
        servicoRepository.save(servico);
        return "redirect:/servicos";
    }

    private String gerarCodigo() {
        StringBuilder sb = new StringBuilder("OFI-");
        for (int i = 0; i < 6; i++) {
            sb.append(CARACTERES.charAt(RANDOM.nextInt(CARACTERES.length())));
        }
        return sb.toString();
    }
}