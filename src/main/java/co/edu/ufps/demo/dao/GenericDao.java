package co.edu.ufps.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, ID extends Serializable>{
	T save(T entity);
	void delete(ID id);
	T get (ID id);
	List<T> getAll();

}
