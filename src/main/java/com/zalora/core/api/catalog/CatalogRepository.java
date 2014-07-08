package com.zalora.core.api.catalog;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

import com.zalora.core.api.domain.JpaRepository;
import com.zalora.core.api.domain.Repository;

class CatalogRepository extends JpaRepository<Catalog>
{	
	public Catalog find(int id)
	{
		return entityManager.find(Catalog.class, id);
	}
	
	public Catalog findOneBy(Map<String, Object> criterias)
	{
		CriteriaBuilder b = entityManager.getCriteriaBuilder();
		CriteriaQuery<Catalog> q = b.createQuery(Catalog.class);
		Root<Catalog> catalog = q.from(Catalog.class);
		
		for (Map.Entry<String, Object> entry : criterias.entrySet()) {
		    q.where(b.equal(catalog.get(entry.getKey()), entry.getValue()));
		}

		return entityManager.createQuery(q).getSingleResult();
	}
	
	public List<Catalog> findBy(Map<String, Object> criterias)
	{
		CriteriaBuilder b = entityManager.getCriteriaBuilder();
		CriteriaQuery<Catalog> q = b.createQuery(Catalog.class);
		Root<Catalog> catalog = q.from(Catalog.class);
		
		for (Map.Entry<String, Object> entry : criterias.entrySet()) {
		    q.where(b.equal(catalog.get(entry.getKey()), entry.getValue()));
		}

		return entityManager.createQuery(q).getResultList();
	}
	
	public List<Catalog> all()
	{
		final String query = 
			"SELECT c " +
			"FROM com.zalora.core.api.catalog.Catalog c " +
			"JOIN FETCH c.config cc";
		
		return entityManager
			.createQuery(query, Catalog.class)
			.setMaxResults(10)
			.getResultList();
	}

	public void persist(Catalog entity) {
		entityManager.persist(entity);
		entityManager.refresh(entity);
	}

	public void remove(Catalog entity) {
		entityManager.remove(entity);
	}
}
