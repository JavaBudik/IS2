package pack.abstractdao;

import java.util.List;

import pack.pojo.PZ;

public interface AbstractPZDAO {
	
	void delete(final PZ persistentInstance);
	List<PZ> findAll();
	List<PZ> findByProperty(final String propertyName, 
			final Object value);
	void save(final PZ transientInstance);
	PZ findById(final Long id);

}
