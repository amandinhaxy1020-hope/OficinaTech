package com.oficinatech.oficinatech.controller;

import com.oficinatech.oficinatech.model.Material;
import com.oficinatech.oficinatech.repository.MaterialRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialRepository materialRepository;

    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("materiais", materialRepository.findAll());
        return "materiais-lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("material", new Material());
        return "materiais-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Material material) {
        materialRepository.save(material);
        return "redirect:/materiais";
    }

    @PostMapping("/{id}/entrada")
    public String entrada(@PathVariable Long id, @RequestParam Double quantidade) {
        Material material = materialRepository.findById(id).orElseThrow();
        material.setQuantidade(material.getQuantidade() + quantidade);
        materialRepository.save(material);
        return "redirect:/materiais";
    }

    @PostMapping("/{id}/saida")
    public String saida(@PathVariable Long id, @RequestParam Double quantidade) {
        Material material = materialRepository.findById(id).orElseThrow();
        material.setQuantidade(material.getQuantidade() - quantidade);
        materialRepository.save(material);
        return "redirect:/materiais";
    }
}