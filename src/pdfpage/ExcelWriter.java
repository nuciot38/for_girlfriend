package pdfpage;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {
    public static void writer(String path, String path2, String excelPath) throws IOException {
        Workbook wb = null;
        File file = new File(excelPath);
        Sheet sheet =null;
        //创建工作文档对象
        String fileType = "xls";
        if (!file.exists()) {
                wb = new HSSFWorkbook();
            //创建sheet对象
            sheet = (Sheet) wb.createSheet("sheet1");
            OutputStream outputStream = new FileOutputStream(excelPath);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        //创建sheet对象
        if (sheet==null) {
            wb = new HSSFWorkbook();
            sheet = (Sheet) wb.createSheet("sheet1");
        }
        //添加表头
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        row.setHeight((short) 540);

        CellStyle style = wb.createCellStyle(); // 样式对象
        // 设置单元格的背景颜色为淡蓝色
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        style.setWrapText(true);

        cell.setCellStyle(style);

        Font font = wb.createFont();
        font.setFontName("宋体");
//        font.setFontHeight((short) 280);
        style.setFont(font);
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
//        sheet.autoSizeColumn(5200);

        row = sheet.createRow(0);

        List<ExcelResult> result = new ArrayList<>();
        if (path2 == null|| path2.equals("")){
            FindAllFiles findAllFiles = new FindAllFiles();
            result = findAllFiles.getAllResult(path);
        }else{
            CompareTwo compareTwo = new CompareTwo();
            result = compareTwo.compareTwo(path, path2);
        }

        String[] titleRow = {"filename", "page"};

        for(int i = 0;i < titleRow.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            cell.setCellStyle(style);
            sheet.setColumnWidth(i, 20 * 256);
        }
//        row.setHeight((short) 540);

        for (int i = 0; i < result.size(); i++) {
            row = (Row) sheet.createRow(i+1);
//            row.setHeight((short) 500);
            row.createCell(0).setCellValue(( result.get(i)).getFileName());
            row.createCell(1).setCellValue(( result.get(i)).getPage());
        }

        OutputStream stream = new FileOutputStream(excelPath);
        wb.write(stream);
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        String pathA = "C:\\Users\\忆倾城\\Desktop\\Java";
        String pathB = "C:\\Users\\忆倾城\\Desktop\\Test";
        String excelPath = "C:\\Users\\忆倾城\\Desktop\\Test\\reslut.xls";
        writer(pathA, pathB, excelPath);

        System.out.println("已完成");
    }

}
