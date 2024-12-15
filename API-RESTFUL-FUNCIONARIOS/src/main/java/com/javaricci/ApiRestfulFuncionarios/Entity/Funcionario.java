package com.javaricci.ApiRestfulFuncionarios.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIOS")
@SequenceGenerator(name = "seq_id", sequenceName = "seq_id", allocationSize = 1, initialValue = 1)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_id")
	private Long id;

	@Column(name = "NomeCompleto", nullable = false)
	private String nomeCompleto;

	@Column(name = "DataNascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "SalarioMensal", nullable = false)
	private BigDecimal salarioMensal;

	@Column(name = "DiasTrabalhados")
	private Integer diasTrabalhados;
	
	@Column(name = "JornadaMensal")	
	private Integer jornadaMensal;
	
	@Column(name = "SalarioReceber")	
	private BigDecimal salarioReceber;

	@Column(name = "Endereco")	
	private String endereco;
	
	@Column(name = "Bairro")	
	private String bairro;
	
	@Column(name = "CEP")	
	private String cep;
	
	@Column(name = "Cidade")	
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(BigDecimal salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public Integer getDiasTrabalhados() {
		return diasTrabalhados;
	}

	public void setDiasTrabalhados(Integer diasTrabalhados) {
		this.diasTrabalhados = diasTrabalhados;
	}

	public Integer getJornadaMensal() {
		return jornadaMensal;
	}

	public void setJornadaMensal(Integer jornadaMensal) {
		this.jornadaMensal = jornadaMensal;
	}

	public BigDecimal getSalarioReceber() {
		return salarioReceber;
	}

	public void setSalarioReceber(BigDecimal salarioReceber) {
		this.salarioReceber = salarioReceber;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
