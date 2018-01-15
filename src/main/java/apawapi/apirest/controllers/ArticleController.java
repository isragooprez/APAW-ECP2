package apawapi.apirest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dto.ArticleDto;
import apawapi.apirest.entity.Article;
import apawapi.apirest.entity.Provider;


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

	public Boolean createArticle(String reference, int providerId) {
		Provider provider = DaoFactory.getFactory().getProviderDao().read(providerId);
		if (provider != null) {
			DaoFactory.getFactory().getArticleDao().create(new Article(reference, provider));
			return true;
		} else {
			return false;
		}
	}

	public List<ArticleDto> articleList() {
		List<Article> articles = DaoFactory.getFactory().getArticleDao().findAll();
		List<ArticleDto> articleDtoList = new ArrayList<>();
		for (Article article : articles) {
			articleDtoList.add(new ArticleDto(article));
		}
		return articleDtoList;
	}
	
	public Boolean deleteArticle(Integer ArticleID) {
        if (existArticleId(ArticleID)) {
            DaoFactory.getFactory().getArticleDao().deleteById(ArticleID);
            return true;
        } else {
            return false;

        }
    };
	
	
	

}
