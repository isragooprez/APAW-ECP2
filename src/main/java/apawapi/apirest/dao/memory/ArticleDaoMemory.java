package apawapi.apirest.dao.memory;

import java.util.HashMap;
import java.util.List;

import apawapi.apirest.dao.ArticleDao;
import apawapi.apirest.entity.Article;


public class ArticleDaoMemory extends GenericDaoMemory<Article> implements ArticleDao {
	

	public ArticleDaoMemory() {
		this.setMap(new HashMap<Integer, Article>());
	}

	@Override
	protected Integer getId(Article entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Article entity, Integer id) {
		entity.setId(id);

	}

	@Override
	public List<Integer> findValueByThemeId(int themeId) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
