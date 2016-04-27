package com.examples.activitiSpringMvc.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * Basic DAO
 * 
 * 
 * @param <E>
 *            The Entity to be handled by the DAO
 * @param <K>
 *            The Entity's private key
 */
@Transactional
public abstract class BaseDao<E, K extends Serializable> {



	private Class<E> clazz;

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Fetch all results from the database
	 * 
	 * @return <code>List<E></code>
	 */
	public List<E> findAll() {
		return em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz).getResultList();
	}

	/**
	 * Find <E> by id of type <K>
	 * 
	 * @param id
	 * @return <code>E</code>
	 */
	public E find(K id) {
		return em.find(clazz, id);
	}

	/**
	 * Persist an entity
	 * 
	 * @param entity
	 */
	public void save(E entity) {
		em.persist(entity);
	}

	/**
	 * Merge an entity
	 * 
	 * @param entity
	 * @return The updated entity instance.
	 */
	public E update(E entity) {
		return em.merge(entity);
	}

	/**
	 * Delete an entity
	 * 
	 * @param entity
	 */
	public void delete(E entity) {
		em.remove(entity);
	}

	protected Class<E> getClazz() {
		return clazz;
	}

	protected void setClazz(Class<E> clazz) {
		this.clazz = clazz;
	}
}
