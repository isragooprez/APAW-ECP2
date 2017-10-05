package apawapi.apirest.controllers;

import java.util.Optional;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dto.ArticleDto;


public class ArticleController {

	public Optional<ArticleDto> readArticle(Integer ArticleID) {
		if (existArticleId(ArticleID)) {
			return Optional.of(new ArticleDto(DaoFactory.getFactory().getArticleDao().read(ArticleID)));
		} else {
			return Optional.empty();
		}

	}

	private boolean existArticleId(Integer articleID) {
		return DaoFactory.getFactory().getArticleDao().read((Integer) articleID) != null;
	}

}
