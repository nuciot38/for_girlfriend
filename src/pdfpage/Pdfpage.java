package pdfpage;

import com.spire.pdf.PdfDocument;

public class Pdfpage {

    public int getPageCount(String filename) {

        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        doc.loadFromFile(filename);

        //获取PDF文件的页数
        int pageCount = doc.getPages().getCount();

        return pageCount;
    }
}