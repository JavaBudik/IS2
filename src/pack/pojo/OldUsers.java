package pack.pojo;

import java.util.List;
/**
 * class for admin_view_users.jsp.
 * @author kfidria
 */
public class OldUsers {
	
	/** List of administrators. */
	private List<Administrator> admins;
	
	/** List of customers. */
	private List<LowUser> lowUser;
	
	/** List of importers. */
	private List<PowerUser> powerUser;
	
		
	/**
	 * @return list of administrators.
	 */
	public final List<Administrator> getAdmins() {
		return admins;
	}
	
	
	/**
	 * @return list of customers.
	 */
	public final List<LowUser> getlowUser() {
		return lowUser;
	}
	
	/**
	 * @return list of importers.
	 */
	public final List<PowerUser> getPowerUser() {
		return powerUser;
	}
	
	/**
	 * @param administrator list of administrators.
	 */
	public final void setAdmins(final List<Administrator> administrator) {
		this.admins = administrator;
	}	
	
	/**
	 * @param customer list of customers.
	 */
	public final void setLowUser(final List<LowUser> lowUser) {
		this.lowUser = lowUser;
	}
	
	/**
	 * @param importer - list of importers.
	 */
	public final void setPowerUser(final List<PowerUser> powerUser) {
		this.powerUser = powerUser;
	}	
	
}

