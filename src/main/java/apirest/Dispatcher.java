package apirest;

import apirest.resources.ArticleResource;
import apirest.resources.ProviderResource;
import http.HttpResponse;
import http.HttpRequest;
import http.HttpStatus;

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
