package apawapi.api.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apawapi.apirest.entity.Provider;

public class ProviderTest {

	@Test
	public void testCreateProvider() {
		assertEquals("CNN", new Provider("CNN").getCompany());
	}

}
