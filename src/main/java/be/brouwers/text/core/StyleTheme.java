package be.brouwers.text.core;

import com.itextpdf.text.Font;

public interface StyleTheme {
	Font getH1();
	Font getH2();
	Font getH3();
	Font getH4();
	Font getH5();
	Font getH6();
	Font getHyperlink();
	Font getRegular();
	Font getBold();
	Font getItalic();
	Font getBoldItalic();
}
