package pack.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import pack.dao.CompatibilityDAO;
import pack.abstractdao.AbstractCompatibilityDAO;
import pack.pojo.Compatibility;


public class CompatibilityDAO extends HibernateDaoSupport implements
AbstractCompatibilityDAO {
	/** Constant for logging hibernate. */
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);
    private static CompatibilityDAO compatibilityDao;
	
	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final Compatibility persistentInstance) {
		
		LOG.debug("deleting Compatibility instance from DB");
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
	public final List<Compatibility> findAll() {
		LOG.debug("finding all Compatibilities instances in DB");
		try {
			String queryString = "from Compatibility ";
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
	public final List<Compatibility> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding Compatibility instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Compatibility as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final Compatibility transientInstance) {
		
		LOG.debug("saving Compatibility instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final Compatibility findById(final Long id) {
		
		LOG.debug("getting Compatibility instance with id: " + id);
		try {
			Compatibility instance = (Compatibility) getHibernateTemplate().get(
					"pack.pojo.Compatibility", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
	
	public static CompatibilityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CompatibilityDAO) ctx.getBean("CompatibilityDAO");
	}
}
