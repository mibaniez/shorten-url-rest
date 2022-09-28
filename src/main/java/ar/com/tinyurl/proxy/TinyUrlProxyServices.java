package ar.com.tinyurl.proxy;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ar.com.tinyurl.proxy.request.CreateTinyUrlRequest;
import ar.com.tinyurl.proxy.response.CreateTinyUrlResponse;

@RegisterRestClient
public interface TinyUrlProxyServices {	

	@POST
	@Path("/create")
	public CreateTinyUrlResponse create(
									@HeaderParam(value = "authorization") String authorization,
									CreateTinyUrlRequest request) throws WebApplicationException;
	
	@GET
	@Path("/alias/{domain}/{alias}")
	public CreateTinyUrlResponse getLongUrl(
									@HeaderParam(value = "authorization") String authorization,
									@PathParam("domain") String domain, 
									@PathParam("alias") String alias) throws WebApplicationException;
	
}
