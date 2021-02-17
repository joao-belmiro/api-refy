package br.cadastro.api.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "REGISTRO_LOG")
public class RegistroLog {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name= "DATA_HORA_LOG")
	private LocalDateTime dataHoraLog;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE_FK")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraLog() {
		return dataHoraLog;
	}

	public void setDataHoraLog(LocalDateTime dataHoraLog) {
		this.dataHoraLog = dataHoraLog;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PrePersist
	private void preSalvar() {
		setDataHoraLog(LocalDateTime.now());
	}

}
