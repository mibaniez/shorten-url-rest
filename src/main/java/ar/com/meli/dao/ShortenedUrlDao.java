package ar.com.meli.dao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ar.com.meli.entity.ShortenedUrl;

@Singleton
public class ShortenedUrlDao {

	@Inject
	EntityManager entityManager;

	public void save(ShortenedUrl entity) {
		this.entityManager.persist(entity);
	}
	
	public void update(ShortenedUrl entity) {
		this.entityManager.merge(entity);
	}
	
	public void delete(ShortenedUrl entity) {
		this.entityManager.remove(entity);
	}

	public ShortenedUrl getByShortUrl(String shortUrl) {
		try {
			String hql = "select s from ShortenedUrl s where s.shortUrl = :shortUrl";
			TypedQuery<ShortenedUrl> tq = this.entityManager.createQuery(hql, ShortenedUrl.class);
			tq.setParameter("shortUrl", shortUrl);
			ShortenedUrl ret = tq.getSingleResult();
			return ret;
		} catch (NoResultException e) {
			return null;
		}
	}

	public ShortenedUrl getByLongUrl(String longUrl) {
		try {
			String hql = "select s from ShortenedUrl s where s.longUrl = :longUrl";
			TypedQuery<ShortenedUrl> tq = this.entityManager.createQuery(hql, ShortenedUrl.class);
			tq.setParameter("longUrl", longUrl);
			ShortenedUrl ret = tq.getSingleResult();
			return ret;
		} catch (NoResultException e) {
			return null;
		}
	}

}
