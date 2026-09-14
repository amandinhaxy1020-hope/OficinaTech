package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.model.Servico;
import com.oficinatech.oficinatech.repository.ServicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acompanhar")
public class PublicoController {

    private final ServicoRepository servicoRepository;

    public PublicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @GetMapping
    public String form() {
        return "acompanhar-form";
    }

    @PostMapping
    public String consultar(@RequestParam String codigo, Model model) {
        var servicoOpt = servicoRepository.findByCodigoAcompanhamento(codigo.trim().toUpperCase());

        if (servicoOpt.isEmpty()) {
            model.addAttribute("erro", "Código não encontrado. Verifique e tente novamente.");
            return "acompanhar-form";
        }

        Servico servico = servicoOpt.get();
        model.addAttribute("servico", servico);
        return "acompanhar-resultado";
    }
}