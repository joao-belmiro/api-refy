package br.cadastro.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.cadastro.api.manager.ClienteManager;
import br.cadastro.api.models.Cliente;
import javassist.NotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("cliente")
public class ClienteController {

	
	@Autowired
	private ClienteManager manager;
	
	@PostMapping("salvar")
	public @ResponseBody ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(manager.salvar(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<Cliente> alterar(@PathVariable Long id ,@Valid @RequestBody Cliente cliente) throws NotFoundException {
		return ResponseEntity.ok(manager.alterar(id, cliente));
	}
	
	@GetMapping("buscar-todos")
	public ResponseEntity<List<Cliente>> buscarTodos () {
		return ResponseEntity.ok(manager.buscarTodos());
	}
	
	@DeleteMapping("excluir/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Long id) throws NotFoundException {
		manager.excluir(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}
	
	
}
