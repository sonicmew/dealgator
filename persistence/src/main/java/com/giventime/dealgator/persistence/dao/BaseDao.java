package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author sonicmew
 */
public abstract class BaseDao<E> {

	private EntityManager entityManager;

	private final Class<E> entityClass;

	/**
	 * AbstractDao constructor with entityClass argument
	 * @param entityClass Class<E> 
	 */
	public BaseDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * AbstractDao constructor
	 * @param entityManager  EntityManager
	 * @param entityClass  Class<E>
	 */
	public BaseDao(EntityManager entityManager, Class<E> entityClass) {
		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}

	/**
	 * Retrieve an entity by its internal (sequential) id.
	 * 
	 * @param id The id of the entity to retrieve.
	 * @return The entity with the given id, or {@code null} if no such entity exists.
	 */
	public E byId(Long id) {
		return getEntityManager().find(entityClass, id);
	}
	
	/**
	 * Checks the existence of an object by id
	 * @param id Long 
	 * @return boolean
	 */
	public boolean exists(Long id) {
		E entity = this.getEntityManager().find(entityClass, id);
		return entity != null;
	}
	
	/**
	 * Saves an object 
	 * @param object E
	 * @return E
	 */
	public E save(E object) {		
		return this.getEntityManager().merge(object);
	}	
	
	public List<E> fetchAll() {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<E> query = criteria.createQuery(entityClass);
		query.from(entityClass);
		
		try {
			return getEntityManager().createQuery(query).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * Saves a list of objects
	 * @param elements List<E>
	 */
	public void saveAll(List<E> elements)
	{
		for (E el : elements)
		{
			this.save(el);
		}
	}
	
	
	/**
	 * Removes an object
	 * @param entity E
	 */
	public void remove(E entity) {
		this.entityManager.remove(entity);
	}
	
	/**
	 * Removes an object
	 * @param id Long
	 */
	public void remove(Long id) 
	{
		E record = entityManager.getReference(entityClass, id);
		this.getEntityManager().remove(record);
	}
	
	/**
	 * Checks if an object contains another object
	 * @param object E
	 * @return boolean
	 */
	public boolean contains(E object) {
		return this.getEntityManager().contains(object);
	} 

	/**
	 * Returns the entityManager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Return the entityClass
	 * @return entityClass
	 */
	public Class<E> getEntityClass() {
		return entityClass;
	}

	/**
	 * Sets the entityManager
	 * @param entityManager EntityManager 
	 */
	@PersistenceContext(unitName = "primary")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
