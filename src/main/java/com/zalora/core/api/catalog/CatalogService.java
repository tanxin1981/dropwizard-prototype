package com.zalora.core.api.catalog;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class CatalogService
{
	private final CatalogRepository repo;
	
	@Inject
	public CatalogService(CatalogRepository repo)
	{
		this.repo = repo;
	}
	
	public Catalog find(int id)
	{
		return repo.find(id);
	}
	
	public Catalog findBySku(final String sku)
	{
		return repo.findOneBy(new HashMap<String, Object>() {{
			put("sku", sku);
		}});
	}
	
	@Transactional
	public void insert(Catalog catalog)
	{
		repo.persist(catalog);
	}
	
	@Transactional
	public void update(Catalog catalog)
	{
		
	}
}
