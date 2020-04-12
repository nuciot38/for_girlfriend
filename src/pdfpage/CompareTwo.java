package pdfpage;

import java.util.ArrayList;
import java.util.List;

public class CompareTwo {
    public List<ExcelResult> compareTwo(String path1, String path2){
        FindAllFiles findAllFiles = new FindAllFiles();
        List<ExcelResult> list1 = findAllFiles.getAllResult(path1);
        List<ExcelResult> list2 = findAllFiles.getAllResult(path2);
        List<ExcelResult> result = new ArrayList<>();
        for (int i=0;i<list1.size();i++){
            boolean ifExist = false;
            for (int j=0;j<list2.size();j++){
                ExcelResult excelResult = new ExcelResult();
                if (excelResult.equals(list1.get(i), list2.get(j))){
                    ifExist = true;
                }
            }
            if (ifExist == false){
                result.add(list1.get(i));
            }
        }
        return result;
    }
}
