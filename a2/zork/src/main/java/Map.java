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
    public static void test(List<String> temp){
        char[] tempCh = new char[temp.size()];
        for (int i = 0; i < temp.size(); i++) {

        }
    }
}
