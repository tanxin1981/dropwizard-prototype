package com.zalora.core.api.domain;

import java.util.List;

public interface Repository<T> {
	public T find(int id);
	
	public List<T> all();
	
	public void persist(T entity);
	
	public void remove(T entity);
}
