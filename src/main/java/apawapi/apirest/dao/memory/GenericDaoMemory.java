package apawapi.apirest.dao.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import apawapi.apirest.dao.GenericDao;

public abstract class GenericDaoMemory<T> implements GenericDao<T, Integer> {

	private Map<Integer, T> refereces;
	private Integer id;

	protected void setRefereces(Map<Integer, T> refereces) {
		this.refereces = refereces;
	}

	protected abstract Integer getId(T entity);

	protected abstract void setId(T entity, Integer id);

	@Override
	public void create(T entity) {
		
		refereces.put(id, entity);
        this.setId(entity, id);
        id++;
	}

	@Override
	public T read(Integer id) {
		return refereces.get(id);

	}

	@Override
	public void update(T entity) {
		if (refereces.containsKey(this.getId(entity))) {
			refereces.put(this.getId(entity), entity);
		}
	}

	@Override
	public void deleteById(Integer id) {
		refereces.remove(id);

	}

	@Override
	public List<T> findAll() {
		return new ArrayList<>(refereces.values());
	}

}
