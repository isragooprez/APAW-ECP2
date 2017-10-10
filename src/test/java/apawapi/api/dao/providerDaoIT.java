package apawapi.api.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.dao.DaoFactory;

import apawapi.apirest.dao.memory.DaoMemoryFactory;
import apawapi.apirest.entity.Provider;

public class providerDaoIT {
	Provider provider;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());

	}

	private void createProvider() {
		provider = new Provider("UPM");
	}

	@Test
	public void testCreateProvider() {
		createProvider();
	}

	@Test
	public void testCreateArticleDao() {
		createProvider();
		DaoFactory.getFactory().getProviderDao().create(provider);
	}

	@Test
	public void testReadExistIdArticleDao() {
		createProvider();
		DaoFactory.getFactory().getProviderDao().read(1);
	}

	@Test
	public void testReadNoExistIdArticleDao() {
		createProvider();
		assertNull(DaoFactory.getFactory().getProviderDao().read(10));

	}

}
