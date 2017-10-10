package apawapi.api.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;
import apawapi.apirest.entity.Article;
import apawapi.apirest.entity.Provider;

public class articleDaoIT {

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());

	}

	private void DaoCreteDaoArticle() {
		Provider provider = new Provider("UPM");
		Article article = new Article("ArticleCNN", provider);
		DaoMemoryFactory.getFactory().getArticleDao().create(article);
	}

	@Test
	public void testCreateDaoArticle() {
		DaoCreteDaoArticle();
	}

	@Test
	public void testReadExistByIDDaoArticle() {
		DaoCreteDaoArticle();
		assertNull(DaoMemoryFactory.getFactory().getArticleDao().read(8));

	}

	@Test
	public void testReadExistDaoArticle() {
		DaoCreteDaoArticle();
		assertEquals(
				"Article [id=1, reference=ArticleCNN, stock=0, discontinued=false, provider=Provider [id=0, company=UPM, adress=null]]",
				DaoMemoryFactory.getFactory().getArticleDao().read(1).toString());

	}

}
