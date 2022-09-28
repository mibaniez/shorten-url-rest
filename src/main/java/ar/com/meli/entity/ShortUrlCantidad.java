package ar.com.meli.entity;

public class ShortUrlCantidad {

	private String shortUrl;
	private long cantidad;

	public ShortUrlCantidad(String shortUrl, long cantidad) {
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
