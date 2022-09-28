package ar.com.tinyurl.proxy.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
"data": {
    "domain": "tiny.one",
    "alias": "ypbsytuz",
    "deleted": false,
    "archived": false,
    "analytics": {
      "enabled": true,
      "public": false
    },
    "tags": [],
    "created_at": "2022-09-10T14:24:23+00:00",
    "expires_at": null,
    "tiny_url": "https://tiny.one/ypbsytuz",
    "url": "https://www.example.com/my-really-long-link-that-I-need-to-shorten/84378949"
  },
  */
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
//@JsonPropertyOrder({ "created_at", "tiny_url", "url" })
public class DataTinyUrlResponse {

	private String domain;
	private String alias;
	private boolean deleted;
	private boolean archived;
	private String[] tags;
	//private Object[] analytics;

	@JsonProperty("tiny_url")
	private String tinyUrl;

	//@JsonProperty("url")
	private String url;

	// @JsonProperty("created_at")
	// private String createdAt;

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}



//	public String[] getAnalytics() {
//		return analytics;
//	}
//
//	public void setAnalytics(String[] analytics) {
//		this.analytics = analytics;
//	}

}
