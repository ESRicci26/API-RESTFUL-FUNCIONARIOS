package com.javaricci.ApiRestfulFuncionarios.Service;

import com.javaricci.ApiRestfulFuncionarios.Entity.Funcionario;
import com.javaricci.ApiRestfulFuncionarios.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }
    
    //Se existir um Id = true
    public boolean existeId(Long id) {
        return repository.existsById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
