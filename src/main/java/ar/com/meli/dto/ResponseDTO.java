package ar.com.meli.dto;

public class ResponseDTO {

	private String error;
	private Object resultado;

	public ResponseDTO(String error, Object resultado) {
		super();
		this.error = error;
		this.resultado = resultado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

}
