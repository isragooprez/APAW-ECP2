package apawapi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;
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
				.body("uno").build();
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
		assertEquals("{\"id\":1,\"company\":\"uno\"}", new HttpClientService().httpRequest(request).getBody());

	}

}
