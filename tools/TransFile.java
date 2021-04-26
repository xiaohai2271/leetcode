import java.io.File;
import java.util.function.Consumer;

public class TransFile {

    public static void main(String[] args) {
        new TransFile().eachFile(new File("."), deleteFile());
        //        new TransFile().eachFile(new File("."), file -> {
        //            if (file.getName().endsWith(".java")) {
        //                System.out.printf("%s\n", file.getName());
        //            }
        //        });
    }

    public static Consumer<File> deleteFile() {
        return file -> {
            System.out.printf("%b%s\n", file.delete(), file.getName());
        };
    }

    /**
     * 遍历文件
     */
    public void eachFile(File file, Consumer<File> fileConsumer) {
        if (file == null) return;
        if (file.isFile()) {
            fileConsumer.accept(file);
            return;
        }
        File[] files = file.listFiles();
        if (files == null) return;
        for (File TFile : files) eachFile(TFile, fileConsumer);
    }
}
