package apawapi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;
import apawapi.apirest.resources.ArticleResource;
import apawapi.apirest.resources.ProviderResource;
import apawapi.http.HttpClientService;
import apawapi.http.HttpException;
import apawapi.http.HttpMethod;
import apawapi.http.HttpRequest;
import apawapi.http.HttpRequestBuilder;

public class ProviderResourceFunctionalTesting {

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
	}

	private void createProvider() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ProviderResource.PROVIDERS)
				.body("Israel").build();
		new HttpClientService().httpRequest(request);

	}

	private void createProvider2() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ProviderResource.PROVIDERS)
				.body("Santiago").build();
		new HttpClientService().httpRequest(request);

	}

	@Test
	public void testCreateProvider() {
		createProvider();
	}

	@Test(expected = HttpException.class)
	public void testCreateProviderCompanyEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ProviderResource.PROVIDERS).body("")
				.build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateWithOutProviderEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ProviderResource.PROVIDERS).build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testReadProvider() {
		this.createProvider();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ProviderResource.PROVIDERS)
				.path(ProviderResource.ID).expandPath("1").build();

		assertEquals("{\"id\":1,\"company\":\"Israel\",\"adress\":\"null\"}",
				new HttpClientService().httpRequest(request).getBody());

	}

	@Test
	public void testProviderList() {
		createProvider();
		createProvider2();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ProviderResource.PROVIDERS).build();

		assertEquals(
				"[{\"id\":1,\"company\":\"Israel\",\"adress\":\"null\"}, {\"id\":2,\"company\":\"Santiago\",\"adress\":\"null\"}]",
				new HttpClientService().httpRequest(request).getBody());

	}

	@Test
	public void testProviderListEmty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ProviderResource.PROVIDERS).build();
		assertEquals("[]", new HttpClientService().httpRequest(request).getBody());
	}

	@Test
	public void testProviderArticlesList() {

		this.createProvider();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES)
				.body("1:4").build();
		new HttpClientService().httpRequest(request);
		request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("1:5").build();
		new HttpClientService().httpRequest(request);
		request = new HttpRequestBuilder().method(HttpMethod.GET).path(ProviderResource.PROVIDERS)
				.path(ProviderResource.ID_ARTICLES).expandPath("1").build();

		 assertEquals("{{\"id\":1,\"company\":\"Israel\",\"adress\":\"null\"},[1, 2]}", new HttpClientService().httpRequest(request).getBody());

	}

}
