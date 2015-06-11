package pack.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractManipulationDAO;
import pack.pojo.Manipulation;

public class ManipulationDAO extends HibernateDaoSupport implements
AbstractManipulationDAO {
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);
	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final Manipulation persistentInstance) {
		
		LOG.debug("deleting Manipulation instance from DB");
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
	public final List<Manipulation> findAll() {
		LOG.debug("finding all Manipulation instances in DB");
		try {
			String queryString = "from Manipulation ";
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
	public final List<Manipulation> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding Manipulation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Manipulation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final Manipulation transientInstance) {
		
		LOG.debug("saving Manipulation instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final Manipulation findById(final Long id) {
		
		LOG.debug("getting Manipulation instance with id: " + id);
		try {
			Manipulation instance = (Manipulation) getHibernateTemplate().get(
					"pack.pojo.Manipulation", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
	
	public static ManipulationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ManipulationDAO) ctx.getBean("ManipulationDAO");
	}

}
