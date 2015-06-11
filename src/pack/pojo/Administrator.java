package pack.pojo;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
/**
 * Class for building administrator table.
 * @author kfiria
 *
 */
@Entity
@DiscriminatorValue("A")
@SecondaryTable(name = "Administrator")
public class Administrator extends User {

	/** Physical address of administrator. */
	@Column(name = "Address", table = "Administrator")
	@Basic(fetch = FetchType.LAZY)
	private String adminsAddress;

	/** Administrators name. */
	@Column(name = "Name", table = "Administrator")
	@Basic(fetch = FetchType.LAZY)
	private String adminsName;

	/** Administrators surname. */
	@Column(name = "Surname", table = "Administrator")
	@Basic(fetch = FetchType.LAZY)
	private String adminsSurname;

	/** Administrators middle name. */
	@Column(name = "MiddleName", table = "Administrator")
	@Basic(fetch = FetchType.LAZY)
	private String adminsMiddleName;

	/** .**************.Getters & Setters.***********************. */
	/**
	 * @return administrators address.
	 */
	public final String getAdminsAddress() {
		return adminsAddress;
	}

	/**
	 * @return administrators name. 
	 */
	public final String getAdminsName() {
		return adminsName;
	}

	/** @return administrators surname. */
	public final String getAdminsSurname() {
		return adminsSurname;
	}

	/** @return administrators middle name. */
	public final String getAdminsMiddleName() {
		return adminsMiddleName;
	}
	
	/**
	 * @param address - physical address. String type.
	 */
	public final void setAdminsAddress(final String address) {
		this.adminsAddress = address;
	}

	/**
	 * @param name - String representation of name.
	 */
	public final void setAdminsName(final String name) {
		this.adminsName = name;
	}

	/**
	 * @param surname String representation of surname.
	 */
	public final void setAdminsSurname(final String surname) {
		this.adminsSurname = surname;
	}

	/**
	 * @param middleName String representation of middle name.
	 */
	public final void setAdminsMiddleName(final String middleName) {
		this.adminsMiddleName = middleName;
	}	
}
