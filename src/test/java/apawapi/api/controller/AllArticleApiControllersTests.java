package apawapi.api.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    ProviderControllerIT.class, 
    ArticleControllerIT.class
})
public class AllArticleApiControllersTests {

}
