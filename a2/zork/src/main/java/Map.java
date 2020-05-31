import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Map {
    public static List<String> getOriginalMap(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        List<String> rows = new ArrayList<String>();
        while (in.readLine() != null){
            String temp = in.readLine();
            rows.add(temp);
        }
        return rows;
    }
    public static char[][] getNewMap(File rootDir) throws IOException {
        List<String> temp = getOriginalMap(rootDir);
        System.out.println(temp.size());
        char[][] m = new char[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            char[] tempChar = new char[temp.get(i).length()];
            for (int j = 0; j < temp.get(i).length(); j++) {
                tempChar[j] = temp.get(i).charAt(j);
            }
            m[i] = tempChar;
        }
        return m;
    }
}
