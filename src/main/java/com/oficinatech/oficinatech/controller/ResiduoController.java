package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.model.Residuo;
import com.oficinatech.oficinatech.repository.ResiduoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/residuos")
public class ResiduoController {

    private final ResiduoRepository residuoRepository;

    public ResiduoController(ResiduoRepository residuoRepository) {
        this.residuoRepository = residuoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("residuos", residuoRepository.findAll());
        return "residuos-lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("residuo", new Residuo());
        return "residuos-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Residuo residuo) {
        residuoRepository.save(residuo);
        return "redirect:/residuos";
    }
}