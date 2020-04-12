package pdfpage;

import java.io.File;
import java.util.*;

public class FindAllFiles {

    public static List<String> folderMethod1(String path) {

        File file = new File(path);
        LinkedList<File> list = new LinkedList<>();

        //保存所有pdf文件的对象
        LinkedList<File> pdfList = new LinkedList<File>();

        //该路径对应的文件或文件夹是否存在
        if (file.exists()) {

            //如果该路径为---文件或空文件夹
            if (null == file.listFiles()) {
//            	System.out.println(file.getAbsolutePath());
                if(file.getAbsolutePath().endsWith(".pdf"))
                    pdfList.add(file);
            }

            //如果该路径为非空文件夹
            else {
                //将该路径下的所有文件（文件或文件夹）对象加入队列
                list.addAll(Arrays.asList(file.listFiles()));
                //遍历该队列
                while (!list.isEmpty()) {

                    File firstF = list.removeFirst();

                    //这里不论是文件夹还是文件，只需判断是否以“.pdf”结尾
                    if(firstF.getAbsolutePath().endsWith(".pdf"))
                        pdfList.add(firstF);

                    File[] files = firstF.listFiles();

                    if (null == files) {
                        //System.out.println(firstF.getAbsolutePath());
                        continue;
                    }
                    for (File f : files) {
                        if (f.isDirectory()) {
                            //System.out.println("文件夹:" + f.getAbsolutePath());
                            list.add(f);
                        } else {
                            //System.out.println("文件:" + f.getAbsolutePath());

                            if(f.getAbsolutePath().endsWith(".pdf"))
                                pdfList.add(f);

                        }
                    }
                }
            }

        } else {
            System.out.println("文件不存在!");
        }

        List<String> fileList = new ArrayList<>();
        //输出所有pdf文件的路径
        for(File f : pdfList)
            fileList.add(f.getAbsolutePath());

        return fileList;
    }

    public List<ExcelResult> getAllResult(String path) {
        List<String> list = folderMethod1(path);
        Pdfpage pdfpage = new Pdfpage();
        List<ExcelResult> result = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ExcelResult excelResult = new ExcelResult();
            String[] fileNames = list.get(i).split("\\\\");
            String fileName = fileNames[fileNames.length-1];
            excelResult.setFileName(fileName.substring(0, fileName.length()-4));
            excelResult.setPage(pdfpage.getPageCount(list.get(i)));
            result.add(excelResult);
        }
        return result;
    }


}