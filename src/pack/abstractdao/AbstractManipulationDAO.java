package pack.abstractdao;

import java.util.List;

import pack.pojo.Manipulation;

public interface AbstractManipulationDAO {
	void delete(final Manipulation persistentInstance);
	List<Manipulation> findAll();
	List<Manipulation> findByProperty(final String propertyName, 
			final Object value);
	void save(final Manipulation transientInstance);
	Manipulation findById(final Long id);

}
