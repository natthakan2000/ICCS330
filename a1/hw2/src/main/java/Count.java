import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class Count{
    public static long directoryCounter = 0;
    public static void fileCounter(File rootDir){
        Iterator<File> files = FileUtils.iterateFiles(rootDir, null, true);
        long counter = 0;
        while (files.hasNext()) {
            files.next();
            counter++;
        }
        System.out.println(counter);;
    }
    private static Map<String,Long> getExt(File rootDir){
        long temp;
        Map<String,Long> m = new HashMap<String, Long>();
        Collection<File> files = FileUtils.listFiles(rootDir, null, true);
        for (File file:files) {
            String fileName = String.valueOf(file);
            String ext = FilenameUtils.getExtension(fileName);
            if (!m.containsKey(ext)){
                m.put(ext, (long) 1);
            }else{
                temp = m.get(ext) + 1;
                m.put(ext,temp);
            }
        }
        return m;
    }
    public static void countExt(File rooDir){
        long counter = 0;
        Map<String,Long> m = getExt(rooDir);
        for (String key:m.keySet()) {
            counter++;
        }
        System.out.println(counter);
    }
    public static void exts(File rootDir){
        Map<String, Long> m = getExt(rootDir);
        for (String key:m.keySet()){
            System.out.println(key);
        }
    }
    public static void countDir(File rootDir){
        File[] dirs = rootDir.listFiles((FileFilter) FileFilterUtils.directoryFileFilter());
        if (dirs != null) {
            for (File dir: dirs) {
                countDir(dir);
                directoryCounter++;
            }
        }
    }
    public static void countTotal(File rootdir, String ext){
        Map<String,Long> m = getExt(rootdir);
        System.out.println(m.get(ext));
    }
}

