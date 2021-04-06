package tool;

import theme.Theme;

public class Config {

	private Theme theme;
	
	public Config(){
		themeDefault();
	}
	public void addTheme(Theme tema){
		theme = tema;
	}
	private void themeDefault(){
		if(theme == null){
			theme = Theme.ESCURO;
		}
	}
	public Theme getTheme(){
		return theme;
	}
}
