package pack.abstractdao;

import java.util.List;

import pack.pojo.User;

public interface AbstractUserDAO {
	
	void delete(User user);
	void delete(Long id);
	void save(User user);
	User findById(Long id);
	List<User> findAll();
	List<User> findByProperty(String propertyName, Object value);
	List<User> findAllOld();
}
