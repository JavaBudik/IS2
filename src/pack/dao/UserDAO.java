package pack.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pack.abstractdao.AbstractUserDAO;
import pack.pojo.User;


public class UserDAO extends HibernateDaoSupport implements AbstractUserDAO{
	private static final Log log = LogFactory.getLog(AdministratorDAO.class);
	private UserDAO userDAO;

    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

public void delete(User user) {
	log.debug("deleting Customers instance from DB");
	try {
		getHibernateTemplate().delete(user);
		log.debug("delete successful");
	} catch (RuntimeException re) {
		log.error("delete User failed", re);
		throw re;
	}
}

public void delete(Long id) {
	log.debug("deleting Customers instance from DB");
	try {
		User record = (User) getHibernateTemplate().load(User.class, id);
		getHibernateTemplate().delete(record);
		log.debug("delete successful");
	} catch (RuntimeException re) {
		log.error("delete User failed", re);
		throw re;
	}
}

public void save(User user) {
	log.debug("saving User instance in DB");
	try {
		getHibernateTemplate().saveOrUpdate(user);
		log.debug("save successful");
	} catch (RuntimeException re) {
		log.error("save failed", re);
		throw re;
	}
}

public User findById(Long id) {
	log.debug("getting Customers instance with id: " + id);
	try {
		User user = (User) getHibernateTemplate().get(
				"pack.pojo.User", id);
		return user;
	} catch (RuntimeException re) {
		log.error("get failed", re);
		throw re;
	}
	
}

@SuppressWarnings("unchecked")
public List<User> findAll() {
	log.debug("finding all Users instances in DB");
	try {
		String queryString = " from User ";
		return getHibernateTemplate().find(queryString);
	} catch (RuntimeException re) {
		log.error("find all failed", re);
		throw re;
	}
}

@SuppressWarnings("unchecked")
public List<User> findByProperty(String propertyName, Object value) {
	log.debug("finding User instance with property: " + propertyName
			+ ", value: " + value);
	try {
		String queryString = "from User as model where model."
				+ propertyName + "=?";
		return getHibernateTemplate().find(queryString, value);
	} catch (RuntimeException re) {
		log.error("find by property name failed", re);
		throw re;
	}
}
public List<User> findAllOld() {
	log.debug("finding all Users instances in DB");
	try {
		String queryString = " from User as us where us.status = 'Checked'";
		return getHibernateTemplate().find(queryString);
	} catch (RuntimeException re) {
		log.error("find all failed", re);
		throw re;
	}
}

}
