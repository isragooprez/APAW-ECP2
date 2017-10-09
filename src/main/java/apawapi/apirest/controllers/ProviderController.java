package apawapi.apirest.controllers;

import java.util.Optional;

import apawapi.apirest.dao.DaoFactory;
import apawapi.apirest.dto.ProviderDto;
import apawapi.apirest.entity.Provider;



public class ProviderController {

	
	private boolean existProviderId(int providerId) {
		return DaoFactory.getFactory().getProviderDao().read(providerId) != null;
	}
	 public void createProvider(String providerCompany) {
	        DaoFactory.getFactory().getProviderDao().create(new Provider(providerCompany));
	       
	    }
	
	public Optional<ProviderDto> readProvider(int providerId) {
		if (existProviderId(providerId)) {
            return Optional.of(new ProviderDto(DaoFactory.getFactory().getProviderDao().read(providerId)));
        } else {
            return Optional.empty();
        }
	}

}
