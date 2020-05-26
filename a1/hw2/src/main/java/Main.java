import java.io.File;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("a", "total-num-files", false, "The total number of files");
        options.addOption("b", "total-num-dirs", false, "Total number of directory");
        options.addOption("c", "list-exts", false, "Total number of unique file extensions");
        options.addOption("d", "list-exts", false, "List all unique file extensions. Do not list duplicates");
        options.addOption(new Option(null,"num-ext=", true, "List total number of file with specified extension EXT."));
        options.addOption("f", null, true, "Path to the documentation folder. This is a required argument");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);
        if (cmd.hasOption("f")){
            File file = new File(cmd.getOptionValue("f"));
            if (cmd.hasOption("a")){
                System.out.println("Total number of file is:");
                Count.fileCounter(file); //1.1
            }if (cmd.hasOption("b")){
                System.out.println("Total number of directory is:");
                Count.countDir(file); //1.2
                System.out.println(Count.directoryCounter);
            }if (cmd.hasOption("c")){
                System.out.println("Total number of extension is:");
                Count.countExt(file); //1.3
            }if (cmd.hasOption("d")){
                System.out.println("Unique file extension are:");
                Count.exts(file); //1.4
            }if (cmd.hasOption("num-ext=")){
                String ext = cmd.getOptionValue("num-ext="); //1.5
                System.out.println("Total number of files with "+ext+" is:");
                Count.countTotal(file,ext);
            }
        }else{
            System.out.println("-f is required");
        }
    }
}

