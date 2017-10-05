package apawapi.apirest.resources;

import java.util.Optional;

import apawapi.apirest.controllers.ArticleController;
import apawapi.apirest.dto.ArticleDto;
import apawapi.apirest.resources.exceptions.ArticleIdNotFoundExeption;

public class ArticleResource {

	public static final String ARTICLES = "articles";
	public static final String ID = "/{id}";

	public ArticleDto readArticle(Integer ArticleId) throws ArticleIdNotFoundExeption {
		Optional<ArticleDto> optional = new ArticleController().readArticle(ArticleId);
		return optional.orElseThrow(() -> new ArticleIdNotFoundExeption(Integer.toString(ArticleId)));

	}

}
