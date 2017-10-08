package apawapi.apirest.dao.memory;

import apawapi.apirest.dao.ArticleDao;
import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.ProviderDao;

public class DaoMemoryFactory extends DaoFactory {
	private ArticleDao articleDao;
	private ProviderDao providerDao;

	@Override
	public ArticleDao getArticleDao() {
		if (articleDao!=null) {
			articleDao = new ArticleDaoMemory();
		}
		
		return articleDao;
	}

	@Override
	public ProviderDao getProviderDao() {
		if (providerDao!=null) {
			providerDao = new ProviderDaoMemory();
		}
		
		return providerDao;
	}

}
