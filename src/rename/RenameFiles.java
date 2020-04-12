package rename;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RenameFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\忆倾城\\Desktop\\Test";
        String oldName = "spring";
        String newName = "Spring";
        rename(path, oldName, newName);
        System.out.println("已完成");
    }

    public static List<File> getAllFiles(String path, List<File> list) {
        File[] files = new File(path).listFiles();
        List<File> curList = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file.getAbsolutePath(), curList);
            }
            if (file.isFile()) {
                curList.add(file);
            }
        }
        list.addAll(curList);
        return list;
    }

    public static void rename(String path, String oldName, String newName) {
        List<File> filesList = getAllFiles(path, new ArrayList<>());
        File[] files = filesList.toArray(new File[0]);
//        File[] files = new File(path).listFiles();
        for (File file : files) {
            String filename = file.getName().replace(oldName, newName);
            file.renameTo(new File(file.getParent() + "\\" + filename));
        }
    }
}
