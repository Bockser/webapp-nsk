package org.document.manager;

import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class AbstractDao<PK extends Serializable, T> {


	@PersistenceContext
	EntityManager entityManager;

	private final Class<T> persistentClass;

	private final String getAllQuery;

	private final String getDistinctQuery;

	private final String getDistinctQueryWhere;

	private final String getQueryWhere;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		String genericClassName = persistentClass.toGenericString();
		String className = genericClassName.substring(genericClassName.lastIndexOf('.')+1);
		getAllQuery = "FROM " +className;
		getDistinctQuery = "SELECT DISTINCT e FROM " +className+ " e";
		getDistinctQueryWhere = getDistinctQuery + " WHERE e.";
		getQueryWhere = "SELECT e FROM " +className+ " e WHERE e.";
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return entityManager.find(persistentClass, key);
	}

	public void update(T entity) {
		try {
			entityManager.merge(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public List<T> getAll() {
		return entityManager.createQuery(getAllQuery,persistentClass).getResultList();
	}

	public void persist(T entity) {
		try {
			entityManager.persist(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void deleteByKey(PK pk) {
		T entity = entityManager.find(persistentClass, pk);
		try {
			entityManager.remove(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}