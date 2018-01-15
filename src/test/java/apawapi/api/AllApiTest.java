package apawapi.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import apawapi.api.controller.AllArticleApiControllersTests;
import apawapi.api.dao.AllArticleApiDaosTest;
import apawapi.api.entities.AllArticleEntitiesTest;

@RunWith(Suite.class)
@SuiteClasses({
    AllArticleApiControllersTests.class,
    AllArticleApiDaosTest.class,
    AllArticleEntitiesTest.class
})
public class AllApiTest {

}
