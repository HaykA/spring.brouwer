package be.brouwers.text.core;

import com.itextpdf.text.Font;

public class StyleThemeFactory {
	
	private StyleThemeColorScheme colorScheme;
	private StyleThemeTypo typo;
	
	public StyleThemeFactory(StyleThemeColorScheme colorScheme,
			StyleThemeTypo typo) {
		this.colorScheme = colorScheme;
		this.typo = typo;
	}
	
	public Font getH1() {
		Font font = typo.getH1();
		font.setColor(colorScheme.getH1());
		return font;
	}
	
	public Font getH2() {
		Font font = typo.getH2();
		font.setColor(colorScheme.getH2());
		return font;
	}
	
	public Font getH3() {
		Font font = typo.getH3();
		font.setColor(colorScheme.getH3());
		return font;
	}
	
	public Font getH4() {
		Font font = typo.getH4();
		font.setColor(colorScheme.getH4());
		return font;
	}
	
	public Font getH5() {
		Font font = typo.getH5();
		font.setColor(colorScheme.getH5());
		return font;
	}
	
	public Font getH6() {
		Font font = typo.getH6();
		font.setColor(colorScheme.getH6());
		return font;
	}
	
	public Font getHyperlink() {
		Font font = typo.getHyperlink();
		font.setColor(colorScheme.getHyperlink());
		return font;
	}
	
	public Font getRegular() {
		Font font = typo.getRegular();
		font.setColor(colorScheme.getNormal());
		return font;
	}
	
	public Font getBold() {
		Font font = typo.getBold();
		font.setColor(colorScheme.getNormal());
		return font;
	}
	
	public Font getItalic() {
		Font font = typo.getItalic();
		font.setColor(colorScheme.getNormal());
		return font;
	}
	
	public Font getBoldItalic() {
		Font font = typo.getBoldItalic();
		font.setColor(colorScheme.getNormal());
		return font;
	}
}
