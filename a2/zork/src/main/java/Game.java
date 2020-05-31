import java.io.File;
import java.io.IOException;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class Game {
    private static final UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
    public static char[][] getMonster(Boolean newGame, File rootDir) throws IOException {
        if (newGame){
            char[][] m = Map.getNewMap(rootDir);
            for (int i = 0; i < m.length; i++) {
                int rand = random(m[i].length);
                int j = 1;
                while(j == 1){
                    if (m[i][rand] != '|'){
                        m[i][rand] = 'm';
                        j = 0;
                    }else{
                        rand = random(m[i].length);
                    }
                }
            }
            return m;
        }
        return null;
    }
    private static int random(int size){
        return rng.nextInt(size);
    }
    public static void setStat(Boolean newGame){

    }
}
