package apawapi.apirest.dao.memory;

import java.util.HashMap;

import apawapi.apirest.dao.ArticleDao;
import apawapi.apirest.entity.Article;

public class ArticleDaoMemory extends GenericDaoMemory<Article> implements ArticleDao {

	public ArticleDaoMemory() {
		this.setRefereces(new HashMap<Integer, Article>());
	}

	@Override
	protected Integer getId(Article entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Article entity, Integer id) {
		entity.setId(id);

	}

}
