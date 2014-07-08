package com.zalora.core.api.catalog;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/catalogs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogResource
{	
	private final CatalogRepository repo;
	
	@Inject
	public CatalogResource(CatalogRepository repo)
	{
		this.repo = repo;
	}
	
	@GET 
	public List<Catalog> getAll()
	{
		return repo.all();
	}
	
	@GET 
	@Path("/{catalog}") 
	public Catalog get(@PathParam("catalog") int id) 
	{
		return repo.find(id);
	}
}
