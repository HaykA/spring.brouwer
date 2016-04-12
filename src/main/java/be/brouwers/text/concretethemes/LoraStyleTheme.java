package be.brouwers.text.concretethemes;

import com.itextpdf.text.Font;

import be.brouwers.text.core.StyleTheme;
import be.brouwers.text.core.StyleThemeFactory;
import be.brouwers.text.core.StyleThemeTypo;

public class LoraStyleTheme implements StyleTheme {
	private StyleThemeFactory factory;
	
	public LoraStyleTheme(String fontsDir) {
		factory = new StyleThemeFactory(
				FluoColorScheme.createColorScheme(),
				new StyleThemeTypo(fontsDir + "\\Lora-Regular.ttf",
						fontsDir + "\\Lora-Bold.ttf",
						fontsDir + "\\Lora-Italic.ttf",
						fontsDir + "\\Lora-BoldItalic.ttf"));
	}

	@Override
	public Font getH1() {
		return factory.getH1();
	}

	@Override
	public Font getH2() {
		return factory.getH2();
	}

	@Override
	public Font getH3() {
		return factory.getH3();
	}

	@Override
	public Font getH4() {
		return factory.getH4();
	}

	@Override
	public Font getH5() {
		return factory.getH5();
	}

	@Override
	public Font getH6() {
		return factory.getH6();
	}

	@Override
	public Font getHyperlink() {
		return factory.getHyperlink();
	}

	@Override
	public Font getRegular() {
		return factory.getRegular();
	}

	@Override
	public Font getBold() {
		return factory.getBold();
	}

	@Override
	public Font getItalic() {
		return factory.getItalic();
	}

	@Override
	public Font getBoldItalic() {
		return factory.getBoldItalic();
	}

}
