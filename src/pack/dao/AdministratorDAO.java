package pack.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractAdministratorDAO;
import pack.pojo.Administrator;
/**
 * DAO's for administrators in DB.
 * @author kfidria
 *
 */
public class AdministratorDAO extends HibernateDaoSupport implements
		AbstractAdministratorDAO {
	
	/**	Constant for logging hibernate. */
	private static final Log LOG = LogFactory.getLog(AdministratorDAO.class);

	/**
	 * @param persistentInstance administrator instance.
	 */
	public final void delete(final Administrator persistentInstance) {
		LOG.debug("deleting Administrator instance from DB");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOG.debug("delete successful");
		} catch (RuntimeException re) {
			LOG.error("delete failed", re);
			throw re;
		}
	}

	/** @return list of administrators. */
	@SuppressWarnings("unchecked")
	public final List<Administrator> findAll() {
		LOG.debug("finding all Administrators instances in DB");
		try {
			String queryString = "from Administrator ";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOG.error("find all failed", re);
			throw re;
		}
	}

	/** @return list of administrators.
	 * @param propertyName name
	 * @param value property value
	 */
	@SuppressWarnings("unchecked")
	public final List<Administrator> findByProperty(
			final String propertyName, final Object value) {
		
		LOG.debug("finding Administrator instance with " 
				+ "property: " + propertyName	
				+ ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOG.error("find by property name failed", re);
			throw re;
		}
	}

	/** saves one instance of administrator. 
	 * @param transientInstance one administrator
	 */
	public final void save(final Administrator transientInstance) {
		
		LOG.debug("saving Administrator instance in DB");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOG.debug("save successful");
		} catch (RuntimeException re) {
			LOG.error("save failed", re);
			throw re;
		}
	}

	/**
	 * @return list of administrators.
	 */
	public final List<Administrator> findAllOld() {
		List<Administrator> administrators = new LinkedList<Administrator>();
		for (Administrator admin : findAll()) {
			if (admin.getStatus().equals("Checked")) {
				administrators.add(admin);
			}
		}
		return administrators;
	}

	/**
	 * @return list of administrators.
	 */
	public final List<Administrator> findAllNew() {
		List<Administrator> administrators = new LinkedList<Administrator>();
		for (Administrator admin : findAll()) {
			if (admin.getStatus().equals("Unchecked")) {
				administrators.add(admin);
			}
		}
		return administrators;
	}

	/**
	 * @return administrators by id.
	 * @param id - id of administrator
	 */
	@SuppressWarnings("unchecked")
	public final Administrator findById(final java.lang.Long id) {
		
		LOG.debug("getting Administrators instance with id: " + id);
		try {
			Administrator instance = (Administrator) getHibernateTemplate().get(
					"pack.pojo.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}
}
