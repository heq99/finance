package qiang.finance.portfolio.dao.jpa;

import java.util.List;

import qiang.finance.portfolio.domain.DomainObject;

public interface GenericDao<T extends DomainObject> {

	public T get(Integer id);
	public List<T> getAll();
	public T save(T obj);
	public T update(T obj);
	public T delete(T obj);
	
}
