package com.example.hp.dulcecaro.app.validations;

@SuppressWarnings("Serial")
public class UsuarioExisteException extends Throwable {
	
	public UsuarioExisteException(final String message) {
        super(message);
    }

}
