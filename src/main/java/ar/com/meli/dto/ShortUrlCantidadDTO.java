package ar.com.meli.dto;

public class ShortUrlCantidadDTO {	

	private String shortUrl;
	private long cantidad;
	
	public ShortUrlCantidadDTO(String shortUrl, long cantidad) {
		super();
		this.shortUrl = shortUrl;
		this.cantidad = cantidad;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

}
