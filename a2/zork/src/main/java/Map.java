import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    public void saveMap(char[][] temp) throws IOException {
        List<String> map = new ArrayList<String>();
        for (char[] chars : temp) {
            String str = String.copyValueOf(chars);
            map.add(str);
        }
        File file = new File("/Users/natthakan/muic/iccs330/a2/save.txt");
        FileWriter fr = null;
        fr = new FileWriter(file);
        for (int i = 0; i < map.size(); i++) {
            try {
                fr.write(map.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                //close resources
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
