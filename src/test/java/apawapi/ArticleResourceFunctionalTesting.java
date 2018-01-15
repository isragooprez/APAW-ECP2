package apawapi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dao.memory.DaoMemoryFactory;
import apawapi.apirest.resources.ArticleResource;
import apawapi.apirest.resources.ProviderResource;
import apawapi.http.HttpClientService;
import apawapi.http.HttpException;
import apawapi.http.HttpMethod;
import apawapi.http.HttpRequest;
import apawapi.http.HttpRequestBuilder;

public class ArticleResourceFunctionalTesting {

    private HttpRequest request;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }

    private void createProvider() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ProviderResource.PROVIDERS).body("UPM").build();
        new HttpClientService().httpRequest(request);

    }

    private void CreateArticle() {
        this.createProvider();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("1:1").build();
        new HttpClientService().httpRequest(request);
    }

    private void CreateArticle2() {
        this.createProvider();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("1:2").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateArticle() {
        CreateArticle();
    }

    @Test(expected = HttpException.class)
    public void testCreateArticleWitoutID() {
        createProvider();
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(ArticleResource.ARTICLES).body("5:x").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateProvider() {
        createProvider();
    }

    @Test
    public void testReadArticle() {
        this.CreateArticle();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ArticleResource.ARTICLES).path(ArticleResource.ID)
                .expandPath("1").build();

        System.out.println(new HttpClientService().httpRequest(request).getBody());
        // System.out.println("{\"id\":2,\"reference\":\"1\"}");

        assertEquals("{\"id\":1,\"reference\":\"1\"}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testListArticle() {
        this.CreateArticle();
        this.CreateArticle2();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(ArticleResource.ARTICLES).build();
        assertEquals("[{\"id\":1,\"reference\":\"1\"}, {\"id\":2,\"reference\":\"2\"}]",
                new HttpClientService().httpRequest(request).getBody());

    }

    @Test
    public void testDeleteArticle() {
        this.CreateArticle();
        request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(ArticleResource.ARTICLES).path(ArticleResource.ID).body("1")
                .build();
        new HttpClientService().httpRequest(request);
    }

}
