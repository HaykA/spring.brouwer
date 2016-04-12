package be.brouwers.text.core;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;

public class StyleThemeTypo {
	
	private Font h1;
	private Font h2;
	private Font h3;
	private Font h4;
	private Font h5;
	private Font h6;
	private Font hyperlink;
	private Font regular;
	private Font bold;
	private Font italic;
	private Font boldItalic;
	
	
	public StyleThemeTypo() throws DocumentException, IOException {
		this(BaseFont.createFont());
	}
	
	public StyleThemeTypo(BaseFont baseFont) {
		h1 = new Font(baseFont, 25f, Font.BOLD);
		h2 = new Font(baseFont, 22f, Font.BOLD);
		h3 = new Font(baseFont, 19f, Font.BOLD);
		h4 = new Font(baseFont, 16f, Font.BOLD);
		h5 = new Font(baseFont, 13f, Font.BOLD);
		h6 = new Font(baseFont, 11f, Font.BOLDITALIC);
		hyperlink = new Font(baseFont, 11f);
		regular = new Font(baseFont, 11f);
		bold = new Font(baseFont, 11f, Font.BOLD);
		italic = new Font(baseFont, 11f, Font.ITALIC);
		boldItalic = new Font(baseFont, 11f, Font.BOLDITALIC);
	}
	
	public StyleThemeTypo(String regular, String bold, String italic, String boldItalic) {
		h1 = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 25f);
		h2 = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 22f);
		h3 = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 19f);
		h4 = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16f);
		h5 = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 13f);
		h6 = FontFactory.getFont(boldItalic, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
		hyperlink = FontFactory.getFont(regular, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
		this.regular = FontFactory.getFont(regular, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
		this.bold = FontFactory.getFont(bold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
		this.italic = FontFactory.getFont(italic, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
		this.boldItalic = FontFactory.getFont(boldItalic, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f);
	}

	public Font getH1() {
		return h1;
	}

	public void setH1(Font h1) {
		this.h1 = h1;
	}

	public Font getH2() {
		return h2;
	}

	public void setH2(Font h2) {
		this.h2 = h2;
	}

	public Font getH3() {
		return h3;
	}

	public void setH3(Font h3) {
		this.h3 = h3;
	}

	public Font getH4() {
		return h4;
	}

	public void setH4(Font h4) {
		this.h4 = h4;
	}

	public Font getH5() {
		return h5;
	}

	public void setH5(Font h5) {
		this.h5 = h5;
	}

	public Font getH6() {
		return h6;
	}

	public void setH6(Font h6) {
		this.h6 = h6;
	}

	public Font getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(Font hyperlink) {
		this.hyperlink = hyperlink;
	}

	public Font getRegular() {
		return regular;
	}

	public void setRegular(Font regular) {
		this.regular = regular;
	}

	public Font getBold() {
		return bold;
	}

	public void setBold(Font bold) {
		this.bold = bold;
	}

	public Font getItalic() {
		return italic;
	}

	public void setItalic(Font italic) {
		this.italic = italic;
	}

	public Font getBoldItalic() {
		return boldItalic;
	}

	public void setBoldItalic(Font boldItalic) {
		this.boldItalic = boldItalic;
	}
	
	public void setH1Size(int size) {
		h1.setSize(size);
	}
	
	public void setH2Size(int size) {
		h2.setSize(size);
	}
	
	public void setH3Size(int size) {
		h3.setSize(size);
	}
	
	public void setH4Size(int size) {
		h4.setSize(size);
	}
	
	public void setH5Size(int size) {
		h5.setSize(size);
	}
	
	public void setH6Size(int size) {
		h6.setSize(size);
	}
	
	public void setNormalSize(int size) {
		hyperlink.setSize(size);
		regular.setSize(size);
		bold.setSize(size);
		italic.setSize(size);
		boldItalic.setSize(size);
	}
	
}
