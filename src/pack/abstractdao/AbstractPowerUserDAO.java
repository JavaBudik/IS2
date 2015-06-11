package pack.abstractdao;

import java.util.List;

import pack.pojo.Administrator;
import pack.pojo.PowerUser;


public interface AbstractPowerUserDAO {	
	
	public void save(PowerUser transientInstance);	
	public void delete(PowerUser persistentInstance);
	
	public PowerUser findById(java.lang.Long id);	
	public List<PowerUser> findByName(Object importerName);
	public List<PowerUser> findByCountry(Object country);
	public List<PowerUser> findByCity(Object city);
	public List<PowerUser> findByIdImporter(Object value);	
	public List<PowerUser> findAllOld();
	public List<PowerUser> findAllNew();
	public List<PowerUser> findAll();
}
