package br.cadastro.api.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.cadastro.api.enuns.SituacaoCartaoEnum;

@Entity
@Table(name = "CARTAO_RFID")
public class CartaoRfid {

	@Id
	@Column(name ="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@NotNull(message= "Identificador do cartão não pode ser nulo")
	@Column(name ="TAG_CARTAO")
	private String tag;

	
	@NotNull(message= "A data de criação não pode ser nula")
	@Column(name ="DT_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@Enumerated(EnumType.STRING)
	
	private SituacaoCartaoEnum situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public SituacaoCartaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCartaoEnum situacao) {
		this.situacao = situacao;
	}
	
	@PrePersist
	private void preSalvar() {
		setDataCriacao(LocalDateTime.now());
		setSituacao(SituacaoCartaoEnum.A);
	}
	
	
	
	
}
