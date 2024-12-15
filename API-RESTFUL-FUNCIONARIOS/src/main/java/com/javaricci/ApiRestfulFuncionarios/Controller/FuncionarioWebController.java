package com.javaricci.ApiRestfulFuncionarios.Controller;

import com.javaricci.ApiRestfulFuncionarios.Entity.Funcionario;
import com.javaricci.ApiRestfulFuncionarios.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioWebController {

    @Autowired
    private FuncionarioService service;

    //GET - OBTER todos os funcionários para visualização na web
    @GetMapping
    public String listarFuncionarios(Model model) {
        model.addAttribute("funcionarios", service.listarTodos());
        model.addAttribute("novoFuncionario", new Funcionario());
        return "funcionarios"; // Retorna o nome da visualização para Thymeleaf
    }

    // POST - Criar um novo funcionário a partir do formulário web
    @PostMapping
    public String salvarFuncionario(@ModelAttribute Funcionario funcionario) {
        service.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    // GET - Editar funcionário por ID para visualização na web
    @GetMapping("/editar/{id}")
    public String editarFuncionario(@PathVariable Long id, Model model) {
        model.addAttribute("novoFuncionario", service.buscarPorId(id));
        model.addAttribute("funcionarios", service.listarTodos());
        return "funcionarios";
    }

    // GET - Excluir funcionário por ID para visualização na web
    @GetMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/funcionarios";
    }
}

