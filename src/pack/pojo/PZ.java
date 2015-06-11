package pack.pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PZ")
public class PZ {
	
	private Long pzId;
	private String name;
	private String manufacturer;
    private String scale;
    private String license;
    private BigDecimal price;
    private String photo;
    private Manipulation manipulation;
    private Control control;
    private Set<Compatibility> compatibility = new HashSet<Compatibility>();
    
    public PZ() {
    	
    }
    public PZ(Long pzId, String name, String manufacturer,
    		String scale, String license, BigDecimal price) {
    	this.pzId = pzId;
    	this.name = name;
    	this.manufacturer = manufacturer;
    	this.scale = scale;
    	this.license = license;
    	this.price = price;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PZ_id")
	public Long getPzId() {
		return pzId;
	}
	public void setPzId(Long pzId) {
		this.pzId = pzId;
	}
	@Column(name = "PZ_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "Manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Column(name = "Scale")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@Column(name = "License")
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	@Column(name = "Price")
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Column(name = "PhotoURL")
	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="PZ_Id")
	public Set<Compatibility> getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(Set<Compatibility> compatibility) {
		this.compatibility = compatibility;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manId")
	public Manipulation getManipulation() {
		return manipulation;
	}
	public void setManipulation(Manipulation manipulation) {
		this.manipulation = manipulation;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "controlId")
	public Control getControl() {
		return control;
	}
	public void setControl(Control control) {
		this.control = control;
	}
}
