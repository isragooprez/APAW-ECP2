package apawapi.apirest;

import apawapi.apirest.resources.ArticleResource;
import apawapi.apirest.resources.ProviderResource;
import apawapi.apirest.resources.exceptions.RequestInvalidException;
import apawapi.http.HttpRequest;
import apawapi.http.HttpResponse;
import apawapi.http.HttpStatus;

public class Dispatcher {
	private ArticleResource articleResource = new ArticleResource();

	private ProviderResource providerResource = new ProviderResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"Error:\":\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(ArticleResource.ARTICLES)) {
				String providerId = request.getBody().split(":")[0]; // body="themeId:vote"
				String articleReference = request.getBody().split(":")[1];
				articleResource.createArticle(articleReference, Integer.valueOf(providerId));
				response.setStatus(HttpStatus.CREATED);
			} else if (request.isEqualsPath(ProviderResource.PROVIDERS)) {
				providerResource.createProvider(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} else if (request.isEqualsPath(ArticleResource.ARTICLES + ArticleResource.ID)) {
				response.setBody(articleResource.readArticle(Integer.valueOf(request.paths()[1])).toString());
			} else if (request.isEqualsPath(ProviderResource.PROVIDERS)) {
				response.setBody(providerResource.providerList().toString());
			}
			else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}

	}

	public void doPatch(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(ArticleResource.ARTICLES + ArticleResource.ID)) {
				response.setBody(articleResource.readArticle(Integer.valueOf(request.paths()[1])).toString());
			}else if (request.isEqualsPath(ProviderResource.PROVIDERS)) {
				response.setBody(providerResource.providerList().toString());
			} else if (request.isEqualsPath(ProviderResource.PROVIDERS + ProviderResource.ID)) {
				response.setBody(providerResource.readProvider(Integer.valueOf(request.paths()[1])).toString());
			} else if (request.isEqualsPath(ArticleResource.ARTICLES)) {
				response.setBody(articleResource.toString());
			} else {
				throw new RequestInvalidException(request.getPath());
			}

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
	}

}
