package apawapi.apirest.resources;

import java.util.List;
import java.util.Optional;

import apawapi.apirest.controllers.ArticleController;
import apawapi.apirest.dto.ArticleDto;
import apawapi.apirest.resources.exceptions.ArticleIdNoFoundException;
import apawapi.apirest.resources.exceptions.ArticleInvalidException;
import apawapi.apirest.resources.exceptions.ProviderIdNotFoundException;

public class ArticleResource {

	public static final String ARTICLES = "articles";
	public static final String ID = "/{id}";

	public void createArticle(String ArticleReference, int ProviderId)
			throws ArticleInvalidException, ProviderIdNotFoundException {
		if (ArticleReference.isEmpty()) {
			throw new ArticleInvalidException(ArticleReference);
		}
		if (!new ArticleController().createArticle(ArticleReference, ProviderId)) {
			throw new ProviderIdNotFoundException(Integer.toString(ProviderId));
		}
	}

	public ArticleDto readArticle(Integer ArticleId) throws ArticleIdNoFoundException {
		Optional<ArticleDto> optional = new ArticleController().readArticle(ArticleId);
		return optional.orElseThrow(() -> new ArticleIdNoFoundException(Integer.toString(ArticleId)));

	}

	public List<ArticleDto> listArticle() {
		return new ArticleController().articleList();
	}

}
