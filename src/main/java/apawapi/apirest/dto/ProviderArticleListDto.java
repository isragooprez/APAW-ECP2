package apawapi.apirest.dto;

import java.util.List;


import apawapi.apirest.entity.Provider;

public class ProviderArticleListDto {

	private ProviderDto providerDto;
	private List<Integer> articlesList;

	public ProviderArticleListDto(Provider provider, List<Integer> articlesList) {
		this.providerDto = new ProviderDto(provider);
		this.articlesList = articlesList;
	}

	public ProviderDto getProviderDto() {
		return providerDto;
	}

	public void setProviderDto(ProviderDto providerDto) {
		this.providerDto = providerDto;
	}

	public List<Integer> getArticlesList() {
		return articlesList;
	}

	public void setArticlesList(List<Integer> articlesList) {
		this.articlesList = articlesList;
	}

	@Override
	public String toString() {
		return "{" + providerDto + "," + articlesList + "}";
	}
	
	
	
	

}
