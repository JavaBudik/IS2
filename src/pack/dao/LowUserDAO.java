package pack.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractLowUserDAO;
import pack.pojo.LowUser;

/**
 * DAO's for customer for DB.
 * 
 * @author kfidria
 * 
 */
public class LowUserDAO extends HibernateDaoSupport implements
		AbstractLowUserDAO {

	/** Constant for logging hibernate. */
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);

	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final LowUser persistentInstance) {
		
		LOG.debug("deleting LowUser instance from DB");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOG.debug("delete successful");
		} catch (RuntimeException re) {
			LOG.error("delete failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	/** 
	 * @return list of customers.
	 */
	public final List<LowUser> findAll() {
		LOG.debug("finding all Customers instances in DB");
		try {
			String queryString = "from LowUser ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOG.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * Implemented method.
	 */
	public final List<LowUser> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding LowUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LowUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final LowUser transientInstance) {
		
		LOG.debug("saving LowUser instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final List<LowUser> findAllNew() {
		
		List<LowUser> customers = new LinkedList<LowUser>();
		for (LowUser customer : findAll()) {
			if (customer.getStatus().equals("Unchecked")) {
				customers.add(customer);
			}
		}
		return customers;
	}

	public final List<LowUser> findAllOld() {

		List<LowUser> customers = new LinkedList<LowUser>();
		for (LowUser customer : findAll()) {
			if (customer.getStatus().equals("Checked")) {
				customers.add(customer);
			}
		}
		return customers;
	}

	public final LowUser findById(final Long id) {
		
		LOG.debug("getting LowUser instance with id: " + id);
		try {
			LowUser instance = (LowUser) getHibernateTemplate().get(
					"pack.pojo.LowUser", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
}
