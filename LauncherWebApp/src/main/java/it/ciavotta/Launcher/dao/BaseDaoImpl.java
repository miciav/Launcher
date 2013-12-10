/**
 * 
 */
package it.ciavotta.Launcher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author michele ciavotta
 *
 */
@Repository(value ="baseDao")
@Transactional
public class BaseDaoImpl implements BaseDao {

	@PersistenceContext
	private EntityManager emanager;
	
	/* (non-Javadoc)
	 * @see it.ciavotta.Launcher.dao.BaseDao#persist(java.lang.Object)
	 */
	@Override
	public void persist(Object object) {
		emanager.persist(object);
	}

	/* (non-Javadoc)
	 * @see it.ciavotta.Launcher.dao.BaseDao#getAll(java.lang.Class)
	 */
	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		TypedQuery<T> query = emanager.createQuery(" from "+clazz.getName(), clazz);
		return query.getResultList();
	}

	@Override
	public void refresh(Object object) {
		emanager.refresh(object);		
	}

	@Override
	public boolean contains(Object object){
		return emanager.contains(object);
		
	}
	
}
