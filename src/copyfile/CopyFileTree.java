package copyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class CopyFileTree {
    public void copyFileTrees(String fromPath, String toPath, List<File> unContainsFiles)throws Exception{
        File dirSource = new File(fromPath);
        if (!dirSource.isDirectory()) {
            //如果不是目录那就不复制
            return;
        }
        File destFile = new File(toPath);
        if (!destFile.exists()){
            destFile.mkdir();
        }
        File[] files = dirSource.listFiles();
        for (File file : files){
            String strFrom = fromPath + File.separator + file.getName();
            String strTo = toPath + File.separator + file.getName();
            if (file.isDirectory()){
                copyFileTrees(strFrom, strTo, unContainsFiles);
            }
            if (file.isFile() && unContainsFiles.contains(file)){
                System.out.println("正在复制文件：" + file.getAbsolutePath());
                copyFile(strFrom, strTo);
            }
        }
    }

    public void copyFile(String fromPath, String toPath) throws Exception{
        FileInputStream in = new FileInputStream(fromPath);
        FileOutputStream out = new FileOutputStream(toPath);
        byte[] bs = new byte[500*1024*1024];
        int count = 0;
        while ((count = in.read(bs)) != -1){
            out.write(bs, 0, count);
        }
        in.close();
        out.flush();
        out.close();
    }
}
