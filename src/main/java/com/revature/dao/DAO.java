/**
 * 
 */
package com.revature.dao;

import java.util.List;

/**
 * @author DonatoManzione
 * 
 *         DAO interface to act as contract that all DAO classes should abide by
 *
 *         Includes basic Create, Read, Update, Delete (CRUD) operations and is
 *         generic
 */
public interface DAO<T> {

	boolean create(T instance);

	T read(String name);

	boolean update(T instance);

	boolean delete(T instance);

	List<T> readAll();

}
