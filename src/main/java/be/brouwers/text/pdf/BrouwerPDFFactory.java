package be.brouwers.text.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import be.brouwers.entities.Brouwer;
import be.brouwers.text.concretethemes.LoraStyleTheme;
import be.brouwers.text.core.StyleTheme;

public final class BrouwerPDFFactory {
	private BrouwerPDFFactory() {}

	
	public static void createPDF(List<Brouwer> brouwers, String path) throws FileNotFoundException, DocumentException {
		String pdfPath = path + "\\brouwers.pdf";
		String fontsDir = path + "\\fonts";
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
			StyleTheme theme = new LoraStyleTheme(fontsDir);
			
			document.open();
			document.addSubject("opleiding");
			document.addHeader("1", "All brouwers");
			document.addTitle("All brouwers");
			document.addAuthor("Hayk Avetisyan");
			document.addCreator("Hayk");
			document.addLanguage("English");
			document.addKeywords("list, of, brouwers");
			document.addProducer();
			
			Paragraph ph = new Paragraph(new Phrase("Lijst van brouwers\n\n", theme.getH1()));
			ph.setSpacingBefore(0);
			ph.setSpacingAfter(0);
			document.add(ph);
			PdfContentByte canvas = writer.getDirectContent();
			canvas.setColorStroke(BaseColor.BLACK);
			canvas.setLineWidth(1.1);
			canvas.moveTo(36, 756);
			canvas.lineTo(559, 756);
	        canvas.closePathStroke();
			for (Brouwer brouwer : brouwers) {
				PdfPTable table = new PdfPTable(1);
				table.setWidthPercentage(100f);
				PdfPCell cell = new PdfPCell();
				cell.setBorder(PdfPCell.NO_BORDER);
				
				ph = new Paragraph(new Phrase(brouwer.getNaam() + " ", theme.getH4()));
				if (brouwer.getOmzet() != null && brouwer.getOmzet() > 0) {
					ph.add(new Phrase(String.format("(%(,.2f EUR)", ((double)brouwer.getOmzet())), theme.getRegular()));
				}
				ph.add(new Phrase("\n" + brouwer.getAdres().getStraatEnHuisnr() + "\n", theme.getItalic()));
				ph.add(new Phrase(brouwer.getAdres().getPostcodeEnGemeente().toUpperCase() + "\n", theme.getBold()));
				ph.setSpacingAfter(25f);
				ph.setLeading(15f, 0f);
				cell.addElement(ph);
				table.addCell(cell);
				document.add(table);
			}
		} finally {
			document.close();
		}
	}
	

	
	
	
}
