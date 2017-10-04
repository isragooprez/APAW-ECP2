package apawapi.apirest.resources;

import apawapi.apirest.dto.ArticleDto;

public class ArticleResource {

	public static String ARTICLES="articles";
	public static String ID="/{id}";
	
	
//	 public ThemeDto readTheme(int themeId) throws ThemeIdNotFoundException {
//	        Optional<ThemeDto> optional = new ThemeController().readTheme(themeId);
//	        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
//	    }
	public ArticleDto readArticle(Integer valueOf) {
		return null;
	
	}

}
