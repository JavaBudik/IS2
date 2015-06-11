package pack.security;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import pack.dao.UserDAO;
import pack.pojo.User;

public class UserServiceProvider implements UserDetailsService {
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException, DataAccessException {
		//HibernateUserDetails userDetails = new HibernateUserDetails();
		List<User> users = userDAO.findByProperty("login", login);
		if (users.isEmpty()){ 
			throw new UsernameNotFoundException("no such user in database!!!");
			}
		HibernateUserDetails userDetails = new HibernateUserDetails(users.get(0));
		//userDetails.setUser(users.get(0));
		return userDetails;	
	}

}