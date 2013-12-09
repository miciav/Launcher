/**
 * 
 */
package it.ciavotta.Launcher.dao;

import java.util.List;

/**
 * @author michele ciavotta
 *
 */
public interface BaseDao {
	
	public void persist(Object object);
	
	public void refresh(Object object);
	
	public <T> List<T> getAll(Class<T> clazz);
}