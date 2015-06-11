package pack.dao;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractPowerUserDAO;
import pack.pojo.PowerUser;

public class PowerUserDAO extends HibernateDaoSupport implements AbstractPowerUserDAO {
	private static final Log log = LogFactory.getLog(PowerUserDAO.class);
	// property constants
	public static final String CITY = "city";
	public static final String COUNTRY = "country";	
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}
	
	public static PowerUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PowerUserDAO) ctx.getBean("PowerUserDAO");
	}

	public void save(PowerUser transientInstance) {
		log.debug("saving PowerUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PowerUser persistentInstance) {
		log.debug("deleting PowerUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PowerUser findById(java.lang.Long id) {
		log.debug("getting PowerUser instance with id: " + id);
		try {
			PowerUser instance = (PowerUser) getHibernateTemplate().get(
					"pack.pojo.PowerUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	public List<PowerUser> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<PowerUser> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}	

	public List<PowerUser> findByName(Object name) {
		return findByProperty(NAME, name);
	}	
	
	public List findByExample(PowerUser instance) {
		log.debug("finding PowerUser instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PowerUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PowerUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PowerUser> findAllNew() {
		List<PowerUser> importers = new LinkedList<PowerUser>();
		for(PowerUser importer: findAll()){
			if (importer.getStatus().equals("Unchecked")){
				importers.add(importer);
			}
		}
		return importers;
	}

	public List<PowerUser> findAllOld() {
		List<PowerUser> importers = new LinkedList<PowerUser>();
		for(PowerUser importer: findAll()){
			if (importer.getStatus().equals("Checked")){
				importers.add(importer);
			}
		}
		return importers;
	}

	@SuppressWarnings("unchecked")
	public List<PowerUser> findAll() {
		log.debug("finding all PowerUser instances in DB");
		try {
			String queryString = " from PowerUser ";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PowerUser> findByIdImporter( Object value) {
		log.debug("finding id");
		try {
			String queryString = "from PowerUser as model where model.id=?";

			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}	
}