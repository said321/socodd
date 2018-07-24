package com.socodd.services;

import java.util.List;

public interface IGenericService<E> {
	
	public E save(E entity);
	
	public E update(E entity);

	public List<E> selectAll();

	public List<E> selectAll(String sortField, String sort);

	public E getById(int id);

	public void remove(int id);

	public E findOne(String paramName, Object paramValue);

	public E findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}
