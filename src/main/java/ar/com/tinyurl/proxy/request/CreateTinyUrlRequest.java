package ar.com.tinyurl.proxy.request;

/*
	{
		"url": "https://www.example.com/my-really-long-link-that-I-need-to-shorten/84378949",
		"domain": "tiny.one"
	}
*/
public class CreateTinyUrlRequest {

	private String url;
	private String domain;
	private String alias;
	private String[] tags;
	private String expiresAt;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
