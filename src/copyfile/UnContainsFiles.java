package copyfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnContainsFiles {
    public List<File> getUnContainsFiles(String path1, String path2){
        File file1 = new File(path1);
        File file2 = new File(path2);

        File[] filesInA = file1.listFiles();
        File[] filesInB = file2.listFiles();

        List<File> listFilesInA = getAllFiles(filesInA, new ArrayList<>());

        List<File> listFilesInB = getAllFiles(filesInB, new ArrayList<>());

        List<File> result = new ArrayList<>();
        for (int i = 0;i<listFilesInA.size();i++){
            boolean flag = false;
            String aName = listFilesInA.get(i).getName();
            Long aLen = listFilesInA.get(i).length();
            for (int j=0;j<listFilesInB.size();j++){
                String bName = listFilesInB.get(j).getName();
                Long bLen = listFilesInB.get(j).length();
                if (aLen.equals(bLen)&&aName.equals(bName)){
                    flag = true;
                }
            }
            if (flag == false){
                result.add(listFilesInA.get(i));
            }
        }
        return result;
    }

    public List<File> getAllFiles(File[] files, List<File> result){
        for (File file : files){
            if (file.isFile()){
                result.add(file);
            }
            if (file.isDirectory()){
                getAllFiles(file.listFiles(), result);
            }
        }
        return result;
    }
}
