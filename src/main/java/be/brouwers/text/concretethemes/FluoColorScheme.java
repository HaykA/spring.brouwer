package be.brouwers.text.concretethemes;

import com.itextpdf.text.BaseColor;

import be.brouwers.text.core.StyleThemeColorScheme;

public final class FluoColorScheme {
	private FluoColorScheme() {}
	public static StyleThemeColorScheme createColorScheme() {
		StyleThemeColorScheme colorScheme = new StyleThemeColorScheme();
		colorScheme.setH1(new BaseColor(255, 0, 135));
		colorScheme.setH2(new BaseColor(255, 0, 135));
		colorScheme.setH3(new BaseColor(255, 0, 135));
		colorScheme.setH4(new BaseColor(255, 0, 135));
		colorScheme.setH5(new BaseColor(255, 0, 135));
		colorScheme.setH6(new BaseColor(255, 0, 135));
		colorScheme.setH1(new BaseColor(255, 0, 135));
		return colorScheme;
	}
}
