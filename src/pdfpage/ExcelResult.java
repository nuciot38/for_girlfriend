package pdfpage;

public class ExcelResult {
    private String fileName;

    private int page;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean equals(ExcelResult excelResult1, ExcelResult excelResult2){
        if (excelResult1.getPage() == excelResult2.getPage() && excelResult1.getFileName().equals(excelResult2.getFileName())){
            return true;
        }
        return false;
    }
}
