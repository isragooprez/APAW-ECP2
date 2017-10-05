package apawapi.apirest.dao.memory;

import apawapi.apirest.dao.ArticleDao;
import apawapi.apirest.dao.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {
	private ArticleDao articleDao;

	@Override
	public ArticleDao getArticleDao() {
		if (articleDao!=null) {
			articleDao = new ArticleDaoMemory();
		}
		
		return articleDao;
	}

}
