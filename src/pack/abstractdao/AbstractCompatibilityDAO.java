package pack.abstractdao;

import java.util.List;

import pack.pojo.Compatibility;

public interface AbstractCompatibilityDAO {
	
	void delete(final Compatibility persistentInstance); 
	List<Compatibility> findAll();
	List<Compatibility> findByProperty(final String propertyName, 
			final Object value);
	void save(final Compatibility transientInstance);
	Compatibility findById(final Long id);
	
}
