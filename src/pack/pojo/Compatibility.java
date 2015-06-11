package pack.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compatibility")
public class Compatibility {
	private Long id;
	private Storage storage;
	private PZ pz;
	private String compatibility;
	
	public Compatibility() {
		
	}
	
	public Compatibility(Long id, Storage storage, PZ pz,
			String compatibility) {
		this.id = id;
		this.storage = storage;
		this.pz = pz;
		this.compatibility = compatibility;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "StorageId")
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PZ_Id")
	public PZ getPz() {
		return pz;
	}
	public void setPz(PZ pz) {
		this.pz = pz;
	}
	@Column(name = "Compatibility")
	public String getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(String compatibility) {
		this.compatibility = compatibility;
	}
}
