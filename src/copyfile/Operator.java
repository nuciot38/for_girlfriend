package copyfile;


import java.io.File;
import java.util.List;

public class Operator {
    public static void main(String[] args) throws Exception {
        //A为父集文件夹
        String A = "C:\\Users\\忆倾城\\Desktop\\Java";
        //B为子集文件夹
        String B = "C:\\Users\\忆倾城\\Desktop\\Test";
        //C为结果文件夹
        String C = "C:\\Users\\忆倾城\\Desktop\\Result";
        //D为C中所包含文件的
        String D = "";

        UnContainsFiles unContainsFiles = new UnContainsFiles();
        List<File> list = unContainsFiles.getUnContainsFiles(A, B);

        CopyFileTree copyFileTree = new CopyFileTree();
        copyFileTree.copyFileTrees(A, C, list);

        System.out.println("已完成");
    }
}
