import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/natthakan/muic/iccs330/docs");
        System.out.println("Total number of file is:");
        Count.fileCounter(file); //1.1
        System.out.println("Total number of directory is:");
        Count.countDir(file); //1.2
        System.out.println(Count.directoryCounter);
        System.out.println("Total number of extension is:");
        Count.countExt(file); //1.3
        System.out.println("Unique file extension are:");
        Count.exts(file); //1.4
        System.out.println("Total number of files for each extension is:");
        Count.countTotal(file); //1.5
    }
}
