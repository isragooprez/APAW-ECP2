package apawapi.apirest;

import apawapi.apirest.resources.ArticleResource;
import apawapi.apirest.resources.ProviderResource;
import apawapi.http.HttpRequest;
import apawapi.http.HttpResponse;
import apawapi.http.HttpStatus;

public class Dispatcher {
	private ArticleResource ArticleResource = new ArticleResource();
	private ProviderResource providerResource = new ProviderResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"Error:\":\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {

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

//				response.setBody(ArticleResource.readArticle(Integer.valueOf(request.paths()[1].toString())));

			} else {

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
