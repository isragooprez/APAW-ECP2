package apawapi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import apawapi.http.HttpRequestTest;

@RunWith(Suite.class)
@SuiteClasses({ HttpRequestTest.class, ArticleResourceFunctionalTesting.class, 
	ProviderResourceFunctionalTesting.class
	})
public class AllArticleFunctionalTestings {

	public AllArticleFunctionalTestings() {
		// TODO Auto-generated constructor stub
	}

}
