/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author olivier-h
 */
public interface DAO<T> {
    	void insert(T o);
	void update(T o);
	void delete(T o) throws Exception;
	T getById(Serializable id);
	List<T> getAll();
}
