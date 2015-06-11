package pack.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractPZDAO;
import pack.pojo.PZ;

public class PZDAO extends HibernateDaoSupport implements
AbstractPZDAO {
	
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);
	/**
	 * @param persistentInstance instance of customer.
	 */
	public final void delete(final PZ persistentInstance) {
		
		LOG.debug("deleting PZ instance from DB");
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
	public final List<PZ> findAll() {
		LOG.debug("finding all PZ instances in DB");
		try {
			String queryString = "from PZ ";
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
	public final List<PZ> findByProperty(final String propertyName, 
			final Object value) {
		
		LOG.debug("finding PZ instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PZ as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	public final void save(final PZ transientInstance) {
		
		LOG.debug("saving PZ instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	public final PZ findById(final Long id) {
		
		LOG.debug("getting PZ instance with id: " + id);
		try {
			PZ instance = (PZ) getHibernateTemplate().get(
					"pack.pojo.PZ", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
	
	public static PZDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PZDAO) ctx.getBean("PZDAO");
	}

}
