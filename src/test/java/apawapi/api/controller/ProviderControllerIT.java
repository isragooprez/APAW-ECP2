package apawapi.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.controllers.ProviderController;
import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;


public class ProviderControllerIT {
	private ProviderController providerController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		providerController = new ProviderController();
		providerController.createProvider("UMP");
	}

	@Test
	public void testReadProvider() {
		assertEquals("UMP", providerController.readProvider(1).get().getCompany());
	}

	@Test
	public void testReadProviderNonExistId() {
		assertFalse(providerController.readProvider(20).isPresent());
	}

	@Test
	public void testListProvider() {
		assertEquals(1, providerController.providerList().size());
		assertEquals("UMP", providerController.providerList().get(0).getCompany());

	}


}
