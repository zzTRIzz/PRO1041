package newpackage3;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Tạo một tài liệu PDF mới
        try {
            PdfWriter writer = new PdfWriter(new File("output.pdf"));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Đặt kích thước của trang PDF
            pdf.setDefaultPageSize(400, 600);

            // Tạo 4 cột
            float columnWidth = pdf.getDefaultPageSize().getWidth() / 4;
            document.setRenderer(new MultiColumnDocumentRenderer(document, 4, columnWidth));

            // Thêm nội dung vào từng cột
            for (int i = 0; i < 40; i++) {
                Paragraph paragraph = new Paragraph();
                paragraph.add(new Text("Nội dung cột " + (i + 1)).setFont(PdfFontFactory.createFont(FontConstants.HELVETICA)));
                document.add(paragraph);
            }

            document.close();
            System.out.println("PDF đã được tạo thành công.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
