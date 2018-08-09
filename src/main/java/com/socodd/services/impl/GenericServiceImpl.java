package com.socodd.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.socodd.dao.IGenericDao;
import com.socodd.services.IGenericService;

@Transactional
public class GenericServiceImpl<E> implements IGenericService<E> {

	private IGenericDao<E> dao;
	
	public void setDao(IGenericDao<E> dao) {
		this.dao = dao;
	}

	@Override
	public E save(E entity) {
		return dao.save(entity);
	}

	@Override
	public E update(E entity) {
		return dao.update(entity);
	}

	@Override
	public List<E> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public E getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public E findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public E findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
