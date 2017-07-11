package com.cand.source.dao;

public interface BasicCrud<T> {

	public T get(Integer id);
	public void insert(T entity);
	public void update(T entity);
	public void fakeDelete(Integer id);
}
