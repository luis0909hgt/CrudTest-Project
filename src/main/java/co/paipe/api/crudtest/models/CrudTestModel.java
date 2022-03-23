package co.paipe.api.crudtest.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CRUD_TEST_PAIPE")

public class CrudTestModel {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, unique = true, length = 14)
	private String cpf;
	@Column(nullable = false)
	private LocalDateTime dataAdmissao;
	@Column(nullable = false, unique = true)
	private String dataNasc;
	@Column(nullable = false)
	private String setor;
	@Column(nullable = false)
	private String cargo;
	@Column(nullable = false)
	private String email;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
