package ar.com.meli.exception;

public class MeliServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor default.
	 */
	public MeliServiceException() {
		super();
	}

	/**
	 * Constructor con mensaje.
	 * @param msj
	 */
	public MeliServiceException(String msj) {
		super(msj);
	}

	/**
	 * Constructor para throwable.
	 * @param t
	 */
	public MeliServiceException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor para throwable y mensaje.
	 * @param msj
	 * @param t
	 */
	public MeliServiceException(String msj, Throwable t) {
		super(msj, t);
	}
}
