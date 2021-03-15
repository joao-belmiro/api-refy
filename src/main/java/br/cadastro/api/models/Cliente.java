package br.cadastro.api.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name ="CLIENTE_CADASTRO")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID")
	private Long id;
	
	@NotNull(message = "O nome do cliente não pode ser nulo")
	@Column(name = "NOME")
	private String nome;
	
	@Email(message = "E-mail com formato inválido")
	@Column(name = "EMAIL")
	private String email;
	
	@NotNull(message = "O Telefone não pode ser nulo")
    @Column(name = "TELEFONE")
	private String telefone;
    
	@NotNull
	@Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;
        

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@PrePersist
	public void preSalvar () {
		setDataCriacao(LocalDateTime.now());
	}
}
