package apawapi.apirest.dao.memory;

import java.util.HashMap;

import apawapi.apirest.dao.ProviderDao;
import apawapi.apirest.entity.Provider;

public class ProviderDaoMemory extends GenericDaoMemory<Provider> implements ProviderDao {

	public ProviderDaoMemory() {
		this.setMap(new HashMap<Integer, Provider>());
	}

	@Override
	protected Integer getId(Provider entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Provider entity, Integer id) {
		entity.setId(id);

	}

}
