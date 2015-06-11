package pack.abstractdao;

import java.util.List;

import pack.pojo.Administrator;

/**
 * Interface for administrator DAO's for DB.
 * @author Zetka
 *
 */
public interface AbstractAdministratorDAO {

	/**
	 * @param transientInstance administrator for save of update.
	 */
	void save(Administrator transientInstance);
	
	/**
	 * @param persistentInstance administrator for deleting.
	 */
	void delete(Administrator persistentInstance);
	
	/**
	 * @param propertyName name of column
	 * @param value value of search
	 * @return list of administrators
	 */
	List<Administrator> findByProperty(String propertyName, Object value);
	
	/**
	 * @return list of all registered administrators.
	 */
	List<Administrator> findAllOld();
	
	/** 
	 * @return list of all unregistered administrators.
	 */
	List<Administrator> findAllNew();
	
	/**
	 * @param id id of administrator.
	 * @return administrator instance
	 */
	Administrator findById(java.lang.Long id);
}
