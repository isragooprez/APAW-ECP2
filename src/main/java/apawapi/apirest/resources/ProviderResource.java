package apawapi.apirest.resources;

import java.util.List;
import java.util.Optional;
import apawapi.apirest.controllers.ProviderController;
import apawapi.apirest.dto.ProviderArticleListDto;
import apawapi.apirest.dto.ProviderDto;
import apawapi.apirest.resources.exceptions.ProviderFieldInvalidException;
import apawapi.apirest.resources.exceptions.ProviderIdNotFoundException;

public class ProviderResource {

    public static final String PROVIDERS = "providers";

    public static final String ID = "/{id}";

    public static final String ID_ARTICLES = ID + "/articles";

    public ProviderDto readProvider(int providerId) throws ProviderIdNotFoundException {
        Optional<ProviderDto> optional = new ProviderController().readProvider(providerId);
        return optional.orElseThrow(() -> new ProviderIdNotFoundException(Integer.toString(providerId)));
    }

    public void createProvider(String providerCompany) throws ProviderFieldInvalidException {
        this.validateField(providerCompany);
        new ProviderController().createProvider(providerCompany);
    }

    private void validateField(String field) throws ProviderFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ProviderFieldInvalidException(field);
        }
    }

    public List<ProviderDto> providerList() {
        return new ProviderController().providerList();
    }

    public ProviderArticleListDto providerArticleListDto(int idProvider) throws ProviderIdNotFoundException {
        Optional<ProviderArticleListDto> optional = new ProviderController().listProviderArticles(idProvider);
        return optional.orElseThrow(() -> new ProviderIdNotFoundException(Integer.toString(idProvider)));

    }

    public boolean deleteProviderArticles(Integer ProviderId) throws ProviderFieldInvalidException, ProviderIdNotFoundException {
        if (ProviderId == 0) {
            throw new ProviderFieldInvalidException(Integer.toString(ProviderId));
        }
        if (!new ProviderController().deleteProvider(ProviderId)) {

            throw new ProviderIdNotFoundException(Integer.toString(ProviderId));
        }

        return true;
    }
}
