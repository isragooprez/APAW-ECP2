package apawapi.apirest.dao;

import java.util.List;

import apawapi.apirest.entity.Article;

public interface ArticleDao extends GenericDao<Article, Integer> {
	
	List<Integer> findValueByArticleId(int articleId);

}
