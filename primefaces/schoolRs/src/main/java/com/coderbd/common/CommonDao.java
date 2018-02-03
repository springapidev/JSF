/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.common;

import java.util.List;

/**
 *
 * @author Rajaul Islam
 * @param <E>
 */
public interface CommonDao<E> {

	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

	List<E> findByProperty(String prop, Object val) throws Exception;

	List<E> findInRange(int firstResult, int maxResults) throws Exception;

	long count() throws Exception;

	public void dynamicListPersists(List<E> entities) throws Exception;

	public void dynamicListMerge(List<E> listForMerge) throws Exception;
	


}
