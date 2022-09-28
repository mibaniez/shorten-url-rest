package ar.com.meli.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SHORTENED_URL", indexes = @Index(columnList = "SHORT_URL"))
public class ShortenedUrl {
	
	@Id
	@Column(name = "SHORT_URL_ID")
	@SequenceGenerator(name = "seq_shortener", sequenceName = "seq_shortener_url", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seq_shortener")
	private long shortUrlid;
	
	@Column(name = "SHORT_URL", unique = true)
	private String shortUrl;
	
	@Column(name = "LONG_URL")
	private String longUrl;

	public long getShortUrlid() {
		return shortUrlid;
	}

	public void setShortUrlid(long shortUrlid) {
		this.shortUrlid = shortUrlid;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

}
