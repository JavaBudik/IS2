package pack.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractControlDAO;
import pack.pojo.Control;

public class ControlDAO extends HibernateDaoSupport implements
AbstractControlDAO {
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);
	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final Control persistentInstance) {
		
		LOG.debug("deleting Control instance from DB");
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
	public final List<Control> findAll() {
		LOG.debug("finding all Control instances in DB");
		try {
			String queryString = "from Control ";
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
	public final List<Control> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding Control instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Control as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final Control transientInstance) {
		
		LOG.debug("saving Control instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final Control findById(final Long id) {
		
		LOG.debug("getting Manipulation instance with id: " + id);
		try {
			Control instance = (Control) getHibernateTemplate().get(
					"pack.pojo.Control", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
	
	public static ControlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ControlDAO) ctx.getBean("ControlDAO");
	}

}
