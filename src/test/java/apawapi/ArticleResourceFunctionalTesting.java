package apawapi;

import static org.junit.Assert.*;

import org.junit.Test;

import apawapi.apirest.resources.ArticleResource;
import apawapi.http.HttpClientService;
import apawapi.http.HttpMethod;
import apawapi.http.HttpRequest;
import apawapi.http.HttpRequestBuilder;

public class ArticleResourceFunctionalTesting {

	// private void createTheme() {
	// HttpRequest request = new
	// HttpRequestBuilder().method(HttpMethod.POST).path(ThemeResource.THEMES).body("uno").build();
	// new HttpClientService().httpRequest(request);
	// }
	//
	// @Test
	// public void testCreateTheme() {
	// this.createTheme();
	// }

	// @Test
	// public void testReadTheme() {
	// this.createTheme();
	// HttpRequest request = new
	// HttpRequestBuilder().method(HttpMethod.GET).path(ThemeResource.THEMES).path(ThemeResource.ID)
	// .expandPath("1").build();
	// assertEquals("{\"id\":1,\"name\":\"uno\"}", new
	// HttpClientService().httpRequest(request).getBody());
	//
	// }

	private void createArticle() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES)
				.body("Article1").build();
		new HttpClientService().httpRequest(request);

	}

	@Test
	public void testCreateArticle() {
		this.createArticle();
	}

	@Test
	public void testReadArticle() {
		this.createArticle();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ArticleResource.ARTICLES)
				.path(ArticleResource.ID).expandPath("1").build();
		assertEquals("{\"id\":1,\"name\":\"Article1\"}", new HttpClientService().httpRequest(request).getBody());

	}

}
