package ar.com.meli.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import ar.com.meli.dao.AccesosDao;
import ar.com.meli.dao.ShortenedUrlDao;
import ar.com.meli.dto.ResponseDTO;
import ar.com.meli.dto.ShortUrlCantidadDTO;
import ar.com.meli.entity.Accesos;
import ar.com.meli.entity.ShortenedUrl;
import ar.com.meli.exception.MeliServiceException;
import ar.com.meli.interceptor.Logged;
import ar.com.tinyurl.client.TinyUrlClientServices;
import ar.com.tinyurl.proxy.request.CreateTinyUrlRequest;
import ar.com.tinyurl.proxy.response.CreateTinyUrlResponse;

@ApplicationScoped
public class ShortenUrlService {
	
	private static final Logger LOG = Logger.getLogger(ShortenUrlService.class);
	
	@Inject
	TinyUrlClientServices client;
	
	@ConfigProperty(name = "quarkus.rest-client.tinyurl.domain")
	String domain;
	
	@Inject
	ShortenedUrlDao dao;
	
	@Inject
	AccesosDao accesosDao;
	
	@Transactional
	public ResponseDTO createShortUrl(String longUrl) {
		
		CreateTinyUrlResponse response = null;
		try {
			CreateTinyUrlRequest request = new CreateTinyUrlRequest();
			request.setDomain(domain);
			request.setUrl(longUrl);
			
			response = client.create(request);
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}	
		
		ShortenedUrl shortenedUrl = null;
		
		try {
			String[] split = longUrl.split("//");
			String shortUrl = split[0] + "//" + domain + "/" + response.getData().getAlias();
			
			shortenedUrl = new ShortenedUrl();
			shortenedUrl.setLongUrl(longUrl);
			shortenedUrl.setShortUrl(shortUrl);
			
			saveShortenedUrl(shortenedUrl);			
			
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}
		
		return new ResponseDTO(null, shortenedUrl.getShortUrl());		
				
	}
		
	@Transactional
	public ResponseDTO deleteShortUrl(String shortUrl) {
		
		try {
			ShortenedUrl entity = dao.getByShortUrl(shortUrl);
			
			if (entity==null) {
				throw new MeliServiceException("No existe la short url que desea borrar : " + shortUrl);	
			} else {
				dao.delete(entity);
				return new ResponseDTO(null, shortUrl);
			}
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}
		
	}
	
	private void saveShortenedUrl(ShortenedUrl shortenedUrl) {		
		
		ShortenedUrl entity = dao.getByShortUrl(shortenedUrl.getShortUrl());
		
		if (entity==null) {
			dao.save(shortenedUrl);	
		}
	}

	@Logged
	public ResponseDTO getLongUrl(String shortUrl) {
		
		try {
			ShortenedUrl shortenedUrl = dao.getByShortUrl(shortUrl);
			
			if (shortenedUrl == null) {
				throw new MeliServiceException("No se encuentra long url para : " + shortUrl);
			} else {
				return new ResponseDTO(null, shortenedUrl.getLongUrl());
			}
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}
	}

	public ResponseDTO getShortUrl(String longUrl) {
		try {
			ShortenedUrl shortenedUrl = dao.getByLongUrl(longUrl);
			
			if (shortenedUrl == null) {
				throw new MeliServiceException("No se encuentra short url para : " + longUrl);
			} else {				
				return new ResponseDTO(null, shortenedUrl.getShortUrl());
			}
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}
	}

	@Transactional
	public void log(String shortUrl) {
		ShortenedUrl shortenedUrl = dao.getByShortUrl(shortUrl);	
		
		if (shortenedUrl != null) {
			Accesos accesos = new Accesos();
			accesos.setFechaHora(new Date());
			accesos.setShortenedUrl(shortenedUrl);
			
			accesosDao.save(accesos);
		}	
		
	}

	public ResponseDTO getShortUrlCantidad() {
		
		try {
			List<Object[]> list = accesosDao.getShortUrlCantidad();
			
			List<ShortUrlCantidadDTO> ret = null;
			if (!list.isEmpty()) {
				ret = new ArrayList<ShortUrlCantidadDTO>();
				for(int i = 0; i<list.size(); i++) {
					ret.add(new ShortUrlCantidadDTO((String)list.get(i)[0], (Long)list.get(i)[1]));
				}
			}			
			
			return new ResponseDTO(null, ret);
		} catch (Exception e) {
			LOG.error(e);
			return new ResponseDTO(e.getMessage(), null);
		}
	}
	
}
