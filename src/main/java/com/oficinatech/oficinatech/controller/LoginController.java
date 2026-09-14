package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.repository.ClienteRepository;
import com.oficinatech.oficinatech.repository.MaterialRepository;
import com.oficinatech.oficinatech.repository.ServicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;
    private final MaterialRepository materialRepository;

    public LoginController(ClienteRepository clienteRepository, ServicoRepository servicoRepository, MaterialRepository materialRepository) {
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
        this.materialRepository = materialRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long emAndamento = servicoRepository.findAll().stream()
                .filter(s -> !s.getStatus().equals("Concluído"))
                .count();
        long prontos = servicoRepository.findAll().stream()
                .filter(s -> s.getStatus().equals("Pronto para retirada"))
                .count();

        model.addAttribute("emAndamento", emAndamento);
        model.addAttribute("prontos", prontos);
        model.addAttribute("totalClientes", clienteRepository.count());
        model.addAttribute("totalMateriais", materialRepository.count());

        return "dashboard";
    }
}