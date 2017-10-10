package apawapi.api.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apawapi.apirest.entity.Article;
import apawapi.apirest.entity.Provider;

public class ArticleTest {

	@Test
	public void testCreateProvider() {
		assertEquals("ArticleCNN", new Article("ArticleCNN",new Provider()).getReference());
	}

}
