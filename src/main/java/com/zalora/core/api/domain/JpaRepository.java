package com.zalora.core.api.domain;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class JpaRepository<T> implements Repository<T>
{
	@PersistenceContext
	@Inject
	protected EntityManager entityManager;

	public void persist(T entity) 
	{
		entityManager.persist(entity);
	}

	public void remove(T entity)
	{
		entityManager.remove(entity);
	}
}
