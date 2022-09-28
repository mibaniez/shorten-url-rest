package ar.com.meli.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ar.com.meli.dto.ResponseDTO;
import ar.com.meli.dto.ShortUrlCantidadDTO;
import ar.com.meli.service.ShortenUrlService;

@Path("/shorten-url")
public class ShortenUrlRest {
	
	@Inject
	ShortenUrlService shortenUrlService;	
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO createShortUrl(@QueryParam("url") String url) {
		return shortenUrlService.createShortUrl(url);		
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO deleteShortUrl(@QueryParam("url") String url) {		
		return shortenUrlService.deleteShortUrl(url);		
	}
	
	@GET
	@Path("/get-short-url")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO getShortUrl(@QueryParam("url") String url) {		
		return shortenUrlService.getShortUrl(url);
	}
	
	@GET
	@Path("/get-long-url")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO getLongUrl(@QueryParam("url") String url) {		
		return shortenUrlService.getLongUrl(url);		
	}
	
	@GET
	@Path("/get-cantidad")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO getShortUrlCantidad() {		
		return shortenUrlService.getShortUrlCantidad();
	}
	
}
