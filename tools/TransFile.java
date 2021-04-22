import java.io.*;


public class TransFile {
    public static void main(String[] args) {
        eachFile(new File("../src/cn/celess"));
    }

    public static void delete(File file) {
        if (file.getPath().indexOf("-") != -1) {
            System.out.printf("%b \t %s\n", file.delete(), file.getPath());
        }
    }

    /**
     * 遍历文件
     * @param file
     */
    public static void eachFile(File file) {
        if (file.isFile()) {
            delete(file);
            return;
        }
        for (File TFile : file.listFiles()) {
            eachFile(TFile);
        }
    }
}
