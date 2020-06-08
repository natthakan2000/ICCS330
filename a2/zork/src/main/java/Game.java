import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class Game {
    public static Map map = new Map;
    public static GameStat gameStat = new GameStat();
    private static final UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
    public static char[][] getMonster(Boolean newGame, File rootDir) throws IOException {
        List<Integer> allMonster = new ArrayList<Integer>();
        if (newGame){
            char[][] m = Map.getNewMap(rootDir);
            for (int i = 0; i < m.length; i++) {
                int rand = random(m[i].length);
                int j = 1;
                while(j == 1){
                    if (m[i][rand] != '|' && m[i][rand] != 'd'){
                        m[i][rand] = 'm';
                        allMonster.add(j);
                        j = 0;
                    }else{
                        rand = random(m[i].length);
                    }
                }
            }
            return m;
        }else{
            char[][] m = gameStat.getMap();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] == 'm'){
                        m[i][j] = ' ';
                        int rand = random(2);
                        if (rand % 2 == 1){
                            if (m[i][j+1] != '|' || m[i][j+1] != 'd'){
                                m[i][j+1] = 'm';
                                allMonster.add(j+1);
                            }else{
                                m[i][j-1] = 'm';
                                allMonster.add(j-1);
                            }
                        }else{
                            if (m[i][j-1] != '|' || m[i][j-1] != 'd'){
                                m[i][j-1] = 'm';
                                allMonster.add(j-1);
                            }else{
                                m[i][j+1] = 'm';
                                allMonster.add(j+1);
                            }
                        }
                    }
                }
            }
            gameStat.setAllMonster(allMonster);
            gameStat.setMap(m);
            return m;
        }
    }
    private static int random(int size){
        return rng.nextInt(size);
    }
    public static char[][] movePlayer(String position){
        char[][] m = gameStat.getMap();
        if (position.equals("up")){

        }
    }
    public static void setStat(Boolean newGame){
        if (newGame){
            GameStat gameStat = new GameStat();
            gameStat.setHp(50);
            gameStat.setPower(50);
            gameStat.setPlayerLocation(1);
        }
    }
}
