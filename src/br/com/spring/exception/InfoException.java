package br.com.spring.exception;

import br.com.spring.domain.Usuario;
import static br.com.spring.Utilities.UtilitiesVar.DF_TIMESTAMP;

import java.util.Date;

public class InfoException extends Exception {

	private static final long serialVersionUID = 5004160205811459683L;

	private Usuario usuario;

	public InfoException() {
		super();
	}

	public InfoException(Throwable cause, Usuario usuario) {
		super(cause);
		this.usuario = usuario;
	}

	public InfoException(String message) {
		super(message);
	}

	public InfoException(Throwable cause) {
		super(cause);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void printMessage(Boolean exibeTela) {
		if (exibeTela) {
			//doShit
		}
		System.out.println("[" + DF_TIMESTAMP.format(new Date()) + "]"
				+ (usuario != null ? "[" + usuario.getUsername() + "]" : "")
				+ "InfoException RAISED: " + super.getCause().toString());
		super.printStackTrace();
	}
}