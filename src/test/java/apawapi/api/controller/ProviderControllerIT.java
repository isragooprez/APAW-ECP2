package apawapi.api.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.controllers.ArticleController;
import apawapi.apirest.controllers.ProviderController;
import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;

public class ProviderControllerIT {
	private ProviderController providerController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		providerController = new ProviderController();
		providerController.createProvider("UPM");
	}

	@Test
	public void testReadProvider() {
		assertEquals("UPM", providerController.readProvider(1).get().getCompany());
	}

	@Test
	public void testReadProviderNonExistId() {
		assertFalse(providerController.readProvider(20).isPresent());
	}

	@Test
	public void testListProvider() {
		assertEquals(1, providerController.providerList().size());
		assertEquals("UPM", providerController.providerList().get(0).getCompany());

	}

	@Test
	public void testProviderArticleList() {

		new ArticleController().createArticle("Article1", 1);
		new ArticleController().createArticle("Article5", 1);
		assertEquals("UPM", providerController.listProviderArticles(1).get().getProviderDto().getCompany());
		assertArrayEquals(new Integer[] { 1, 2 },
				providerController.listProviderArticles(1).get().getArticlesList().toArray(new Integer[0]));

	}

}
