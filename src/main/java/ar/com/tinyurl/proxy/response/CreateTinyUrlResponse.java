package ar.com.tinyurl.proxy.response;

/*
{
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
	  "code": 0,
	  "errors": []
	}
*/
public class CreateTinyUrlResponse {

	private DataTinyUrlResponse data;
	private Integer code;
	private String[] errors;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public DataTinyUrlResponse getData() {
		return data;
	}

	public void setData(DataTinyUrlResponse data) {
		this.data = data;
	}

	public String[] getErrors() {
		return errors;
	}

	public void setErrors(String[] errors) {
		this.errors = errors;
	}

}
