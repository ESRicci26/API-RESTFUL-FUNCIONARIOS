package com.javaricci.ApiRestfulFuncionarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaricci.ApiRestfulFuncionarios.Entity.Funcionario;
import com.javaricci.ApiRestfulFuncionarios.Service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioApiController {

    @Autowired
    private FuncionarioService service;


    //OBTENHA todos os funcionários: Método: GET URL: http://localhost:8080/api/funcionarios
    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return service.listarTodos();
    }


    //OBTER funcionário por ID : Método: GET URL: http://localhost:8080/api/funcionarios/2
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = service.buscarPorId(id);
        return ResponseEntity.ok(funcionario);
    }


    /*
    POST para o novo registro : Método: POST URL: http://localhost:8080/api/funcionarios
    Corpo (JSON):
    {
      "nomeCompleto": "INSOMNIA RICCI",
      "dataNascimento": "1985-03-15",
      "salarioMensal": 32778.99,
      "diasTrabalhados": 20,
      "jornadaMensal": 160,
      "salarioReceber": 32778.99,
      "endereco": "Rua dos Milionários, 777",
      "bairro": "Milionários Raiz",
      "cep": "77777-777",
      "cidade": "Afortunados/SP"
    }
    */
    @PostMapping
    public Funcionario salvarFuncionarioApi(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }


    /*
    PUT atualiza um funcionalio existente : Método: PUT URL: http://localhost:8080/api/funcionarios/2
    Corpo (JSON):
    {
      "id": 2,
      "nomeCompleto": "INSOMNIA SALVADOR RICCI-CLF",
      "dataNascimento": "1959-12-24",
      "salarioMensal": 33178.99,
      "diasTrabalhados": 30,
      "jornadaMensal": 200,
      "salarioReceber": 33178.99,
      "endereco": "Rua dos Milionários, 777",
      "bairro": "Milionários Raiz",
      "cep": "77777-777",
      "cidade": "Afortunados/SP"
    }
    */
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        //Se existir o ID no Banco de Dados executa a alteração
    	if (funcionarioDetails.getId() != null && service.existeId(funcionarioDetails.getId())) {
        // Obter o Funcionario existente do banco de dados
        Funcionario funcionario = service.buscarPorId(id);
        
        // Atualizar campos com detalhes do corpo da solicitação
        funcionario.setNomeCompleto(funcionarioDetails.getNomeCompleto());
        funcionario.setDataNascimento(funcionarioDetails.getDataNascimento());
        funcionario.setSalarioMensal(funcionarioDetails.getSalarioMensal());
        funcionario.setDiasTrabalhados(funcionarioDetails.getDiasTrabalhados());
        funcionario.setJornadaMensal(funcionarioDetails.getJornadaMensal());
        funcionario.setSalarioReceber(funcionarioDetails.getSalarioReceber());
        funcionario.setEndereco(funcionarioDetails.getEndereco());
        funcionario.setCep(funcionarioDetails.getCep());
        funcionario.setCidade(funcionarioDetails.getCidade());

        // Salvar o Funcionario atualizado de volta ao banco de dados
        Funcionario updatedFuncionario = service.salvar(funcionario);
        
        return ResponseEntity.ok(updatedFuncionario);
    	} else {
    	//Se NÃO existir o ID no Banco de Dados a operação é cancelada
        return ResponseEntity.ok(null);
        }

    }


    //EXCLUIR registro : Método: DELETE URL: http://localhost:8080/api/funcionarios/6
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionarioApi(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
