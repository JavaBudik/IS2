package pack.abstractdao;

import java.util.List;

import pack.pojo.Storage;

public interface AbstractStorageDAO {
	
	void delete(final Storage persistentInstance);
	List<Storage> findAll();
	List<Storage> findByProperty(final String propertyName, 
			final Object value);
	void save(final Storage transientInstance);
	Storage findById(final Long id);

}
