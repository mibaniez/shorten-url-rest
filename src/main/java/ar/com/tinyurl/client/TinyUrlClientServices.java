package ar.com.tinyurl.client;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.WebApplicationException;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import ar.com.tinyurl.proxy.TinyUrlProxyServices;
import ar.com.tinyurl.proxy.request.CreateTinyUrlRequest;
import ar.com.tinyurl.proxy.response.CreateTinyUrlResponse;

@Singleton
public class TinyUrlClientServices {

	private static final Logger LOGGER = Logger.getLogger(TinyUrlClientServices.class);

	@ConfigProperty(name = "quarkus.rest-client.tinyurl.token")
	String token;

	@Inject
	@RestClient
	TinyUrlProxyServices proxy;

	public CreateTinyUrlResponse create(CreateTinyUrlRequest request) throws WebApplicationException {

		LOGGER.info("INVOCACION TinyUrl");
		//LOGGER.debug("REQUEST: " + objectToJson(request));

		final String authStringEnc = "Bearer " + token;

		CreateTinyUrlResponse response = proxy.create(authStringEnc, request);

		return response;
	}
	
	public CreateTinyUrlResponse getLongUrl(String domain, String alias) throws WebApplicationException {

		LOGGER.info("INVOCACION TinyUrl");

		final String authStringEnc = "Bearer " + token;

		CreateTinyUrlResponse response = proxy.getLongUrl(authStringEnc, domain, alias);

		return response;
	}

}
