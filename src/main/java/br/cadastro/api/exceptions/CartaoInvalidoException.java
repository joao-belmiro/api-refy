package br.cadastro.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CartaoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CartaoInvalidoException (String message) {
		super(message);	
	}
}
