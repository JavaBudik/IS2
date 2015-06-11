package pack.security;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;

import pack.pojo.Administrator;
import pack.pojo.LowUser;
import pack.pojo.PowerUser;

public class HibernateUserDetails extends org.springframework.security.userdetails.User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4801831421612299548L;
	private String login;
	private String password;
	boolean enabled;	
	
	private Long id;
	
	/*public HibernateUserDetails(String login, String password, 
			boolean enabled, boolean accountNonExpired, 
			boolean credentialsNonExpired, boolean accountNonLocked,
			GrantedAuthority[] authorities) {
		login = user.getLogin();
		password = user.getPassword();		
	}*/
	
	public HibernateUserDetails(pack.pojo.User user) {
		
		super(user.getLogin(), user.getPassword(), 
				(user.getStatus().equals("Checked")),true, true, true, 
				toAuthorities(user));
		
		this.id = user.getId();
		this.password = user.getPassword();
		this.login = user.getLogin();
		
	}	

	/*public com.softservecom.train.pojo.User getUser() {
		return user;
	}

	public void setUser(com.softservecom.train.pojo.User user) {
		HibernateUserDetails.user = user;
	}*/

	
	private static GrantedAuthority[] toAuthorities(pack.pojo.User user) {
		GrantedAuthority authority = new  GrantedAuthorityImpl("ROLE_NULL");
		System.out.println(user.getLogin());
		
		if (user instanceof Administrator) {
			authority = new  GrantedAuthorityImpl("ROLE_ADMIN");
		}
		if (user instanceof LowUser) {
			authority = new  GrantedAuthorityImpl("ROLE_LOW");
		}
		if (user instanceof PowerUser) {
			authority = new  GrantedAuthorityImpl("ROLE_POWER");
		}		
		GrantedAuthority authorities[] = new GrantedAuthorityImpl[1];
		authorities[0]= authority;
		return authorities;
	}
/*
	@Override
	public String getPassword() {
		return password;

	}

	@Override
	public String getUsername() {
		return login;

	}
   */
	/*@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return (user.getStatus().equals("Checked"));
	}

*/
	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String login() {
		return login;
	}

}

