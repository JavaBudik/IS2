package pack.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("L")
@SecondaryTable(name = "LowUser")
public class LowUser extends User {
	@Column(name = "Address", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerAddress;

	@Column(name = "Name", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerName;

	@Column(name = "Surname", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerSurname;

	@Column(name = "MiddleName", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerMiddleName;

	@Column(name = "City", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerCity;

	@Column(name = "Country", table = "LowUser")
	@Basic(fetch = FetchType.LAZY)
	private String customerCountry;

	/** **************Getters & Setters*********************** */
	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public String getCustomerMiddleName() {
		return customerMiddleName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

}
