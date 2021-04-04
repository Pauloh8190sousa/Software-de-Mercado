package system;

import theme.Theme;

public class Config {

	private static Theme theme;
	
	public Config(){
		themeDefault();
	}
	public static void addTheme(Theme tema){
		theme = tema;
	}
	private static void themeDefault(){
		if(theme == null){
			theme = Theme.ESCURO;
		}
	}
	public static Theme getTheme(){
		return theme;
	}
}
