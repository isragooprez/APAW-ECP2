package apawapi.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.controllers.ArticleController;
import apawapi.apirest.controllers.ProviderController;
import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;

public class ArticleControllerIT {

	private ArticleController articleController;
	private ProviderController providerController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		articleController = new ArticleController();
		providerController = new ProviderController();

		providerController.createProvider("CNN");
		articleController.createArticle("AricleCNN", 1);
	}

	private void createArticle() {
		providerController.createProvider("CNN");
		articleController.createArticle("ArticlceUPM", 1);
	}

	@Test
	public void testCreatArticle() {

		createArticle();
	}

	@Test
	public void testReadArticle() {
		assertEquals("AricleCNN", articleController.readArticle(1).get().getReference());
	}

}
