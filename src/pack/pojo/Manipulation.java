package pack.pojo;

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
@Table(name = "Manipulations")
public class Manipulation {
	private Long idManip;
	private String cipher;
	private String compress;
	private String copy;
	private Set<PZ> pz = new HashSet<PZ>();
	
	public Manipulation() {
		
	}
	public Manipulation(Long idManip, String cipher, String compress,
			String copy) {
		super();
		this.idManip = idManip;
		this.cipher = cipher;
		this.compress = compress;
		this.copy = copy;		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getIdManip() {
		return idManip;
	}
	public void setIdManip(Long idManip) {
		this.idManip = idManip;
	}
	@Column(name = "Cipher")
	public String getCipher() {
		return cipher;
	}
	public void setCipher(String cipher) {
		this.cipher = cipher;
	}
	@Column(name = "Compress")
	public String getCompress() {
		return compress;
	}
	public void setCompress(String compress) {
		this.compress = compress;
	}
	@Column(name = "Copy")
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="manId")
	public Set<PZ> getPz() {
		return pz;
	}
	public void setPz(Set<PZ> pz) {
		this.pz = pz;
	}
	
	

}
