package com.javaricci.ApiRestfulFuncionarios.Repository;


import com.javaricci.ApiRestfulFuncionarios.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
