package pack.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("P")
@SecondaryTable(name = "PowerUser")
public class PowerUser extends User {
	@Column(name = "City", table = "PowerUser")
	@Basic(fetch = FetchType.LAZY)
	private String importerCity;

	@Column(name = "Country", table = "PowerUser")
	@Basic(fetch = FetchType.LAZY)
	private String importerCountry;
	
	@Column(name = "Name", table = "PowerUser")
	@Basic(fetch = FetchType.LAZY)
	private String importerName;

	/** **************Getters & Setters*********************** */
	public String getImporterCity() {
		return importerCity;
	}

	public String getImporterCountry() {
		return importerCountry;
	}

	public void setImporterCity(String importerCity) {
		this.importerCity = importerCity;
	}

	public void setImporterCountry(String importerCountry) {
		this.importerCountry = importerCountry;
	}

	public String getImporterName() {
		return importerName;
	}

	public void setImporterName(String importerName) {
		this.importerName = importerName;
	}
}
