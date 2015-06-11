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
@Table(name = "Controls")
public class Control {
	private Long idControl;
	private String report;
	private String validation;
	private String log;
	private String monitoring;
	private Set<PZ> pz = new HashSet<PZ>();
	public Control() {
		
	}
	public Control(Long idControl, String report, String validation,
			String log, String monitoring) {
		super();
		this.idControl = idControl;
		this.report = report;
		this.validation = validation;
		this.log = log;
		this.monitoring = monitoring;		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getIdControl() {
		return idControl;
	}
	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}
	@Column(name = "Report")
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	@Column(name = "Validation")
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	@Column(name = "Log")
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	@Column(name = "Monitoring")
	public String getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="controlId")
	public Set<PZ> getPz() {
		return pz;
	}
	public void setPz(Set<PZ> pz) {
		this.pz = pz;
	}
	
	
}
