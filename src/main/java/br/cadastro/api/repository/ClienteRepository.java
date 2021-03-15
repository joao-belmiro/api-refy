package br.cadastro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cadastro.api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
