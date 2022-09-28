package ar.com.meli.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ar.com.meli.entity.Accesos;

@Singleton
public class AccesosDao {
	
	@Inject
	EntityManager entityManager;

	public void save(Accesos entity) {
		entityManager.persist(entity);
	}

	public List<Object[]> getShortUrlCantidad() {
		try {
			String hql = "select a.shortenedUrl.shortUrl, count(a.shortenedUrl.shortUrl) from Accesos a group by a.shortenedUrl.shortUrl";
			Query tq = this.entityManager.createQuery(hql);
			List<Object[]> ret = tq.getResultList();	
			
			return ret;
		} catch (NoResultException e) {
			return null;
		}		
		
	}
}
