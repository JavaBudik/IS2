package pack.abstractdao;

import java.util.List;

import pack.pojo.LowUser;

/**
 * Interface for customers.
 * @author kfidria
 *
 */
public interface AbstractLowUserDAO {
	
	/**
	 * @param transientInstance save customer instance 
	 */
	void save(LowUser transientInstance);

	/**
	 * @param persistentInstance delete customer
	 */
	void delete(LowUser persistentInstance);

	/**
	 * @param propertyName name of column
	 * @param value value for search
	 * @return list of customers
	 */
	List<LowUser> findByProperty(String propertyName, Object value);

	/**
	 * @return list of all registered customers.
	 */
	List<LowUser> findAllOld();

	/**
	 * @return list of all unregistered customers.
	 */
	List<LowUser> findAllNew();
	
	/**
	 * @param id id of customer.
	 * @return customer instance
	 */
	LowUser findById(java.lang.Long id);
}
