package br.cadastro.api.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.cadastro.api.models.Cliente;
import br.cadastro.api.repository.ClienteRepository;
import javassist.NotFoundException;

@Component
public class ClienteManager {

	
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);	
	}
	
	public Cliente alterar(Long id, Cliente cliente) throws NotFoundException {
		Optional<Cliente> clienteExiste = repository.findById(id);
		if (clienteExiste.isPresent()) {
			return repository.save(cliente);
		} else {
			throw new NotFoundException("Cliente não foi encontrado");
		}
	}
	
	public List<Cliente> buscarTodos () {
		return repository.findAll();
	}
	
	public void excluir (Long id) throws NotFoundException {
		Optional<Cliente> clienteLocalizado = repository.findById(id);
		if (clienteLocalizado.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new NotFoundException("Cliente não Encontrado");
		}
	}
	
}
