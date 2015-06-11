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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Storages")
public class Storage {
	private Long idStorage;
	private String name;
	private String manufacturer;
	private String type;
	private String license;
	private Double capacity;
	private Long mtbf;
	private BigDecimal price;
	private String photo;
	private Set<Compatibility> compatibility = new HashSet<Compatibility>();
	
	public Storage() {
		
	}
	
	public Storage(Long idStorage, String name, String manufacturer,
			String type, String license, Double capacity, Long mtbf,
			BigDecimal price, String photo) {
		super();
		this.idStorage = idStorage;
		this.name = name;
		this.manufacturer = manufacturer;
		this.type = type;
		this.license = license;
		this.capacity = capacity;
		this.mtbf = mtbf;
		this.price = price;
		this.photo = photo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Storage_id")
	public Long getIdStorage() {
		return idStorage;
	}
	public void setIdStorage(Long idStorage) {
		this.idStorage = idStorage;
	}
	@Column(name = "Storage_name")
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
	@Column(name = "Type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "License")
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	@Column(name = "Capacity")
	public Double getCapacity() {
		return capacity;
	}
	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}
	@Column(name = "MTBF")
	public Long getMtbf() {
		return mtbf;
	}
	public void setMtbf(Long mtbf) {
		this.mtbf = mtbf;
	}
	@Column(name = "Price")
	public BigDecimal getPrice() {
		return this.price;
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
	@JoinColumn(name="StorageId")
	public Set<Compatibility> getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(Set<Compatibility> compatibility) {
		this.compatibility = compatibility;
	}
}
