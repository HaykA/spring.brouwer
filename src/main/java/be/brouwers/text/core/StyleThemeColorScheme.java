package be.brouwers.text.core;

import com.itextpdf.text.BaseColor;

public class StyleThemeColorScheme {
		
	private BaseColor h1;
	private BaseColor h2;
	private BaseColor h3;
	private BaseColor h4;
	private BaseColor h5;
	private BaseColor h6;
	private BaseColor hyperlink;
	private BaseColor normal;
	
	public StyleThemeColorScheme() {
		h1 = BaseColor.BLACK;
		h2 = BaseColor.BLACK;
		h3 = BaseColor.BLACK;
		h4 = BaseColor.BLACK;
		h5 = BaseColor.BLACK;
		h6 = BaseColor.BLACK;
		hyperlink = BaseColor.BLACK;
		normal = BaseColor.BLACK;
	}

	public BaseColor getH1() {
		return h1;
	}

	public void setH1(BaseColor h1) {
		this.h1 = h1;
	}

	public BaseColor getH2() {
		return h2;
	}

	public void setH2(BaseColor h2) {
		this.h2 = h2;
	}

	public BaseColor getH3() {
		return h3;
	}

	public void setH3(BaseColor h3) {
		this.h3 = h3;
	}

	public BaseColor getH4() {
		return h4;
	}

	public void setH4(BaseColor h4) {
		this.h4 = h4;
	}

	public BaseColor getH5() {
		return h5;
	}

	public void setH5(BaseColor h5) {
		this.h5 = h5;
	}

	public BaseColor getH6() {
		return h6;
	}

	public void setH6(BaseColor h6) {
		this.h6 = h6;
	}

	public BaseColor getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(BaseColor hyperlink) {
		this.hyperlink = hyperlink;
	}

	public BaseColor getNormal() {
		return normal;
	}

	public void setNormal(BaseColor normal) {
		this.normal = normal;
	}
	
	
}
