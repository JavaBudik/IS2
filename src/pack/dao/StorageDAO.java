package pack.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractCompatibilityDAO;
import pack.abstractdao.AbstractStorageDAO;
import pack.pojo.Compatibility;
import pack.pojo.Storage;

public class StorageDAO extends HibernateDaoSupport implements
AbstractStorageDAO {
	
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);
	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final Storage persistentInstance) {
		
		LOG.debug("deleting Storage instance from DB");
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
	public final List<Storage> findAll() {
		LOG.debug("finding all Storage instances in DB");
		try {
			String queryString = "from Storage ";
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
	public final List<Storage> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding Storage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Storage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final Storage transientInstance) {
		
		LOG.debug("saving Storage instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final Storage findById(final Long id) {
		
		LOG.debug("getting Storage instance with id: " + id);
		try {
			Storage instance = (Storage) getHibernateTemplate().get(
					"pack.pojo.Storage", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
	
	public static StorageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StorageDAO) ctx.getBean("StorageDAO");
	}

}
