package apawapi.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.controllers.ProviderController;
import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;


public class ArticleControllerIT {

	private ProviderController providerController;
	
	@Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        providerController = new ProviderController();
        providerController.createProvider("tema1");
    }
	
	@Test
    public void testReadTheme() {
       assertEquals("tema1",providerController.readProvider(1).get().getCompany());
    }


}
