import java.io.File;
import java.io.IOException;
import java.util.List;

public class Game {
    public static void getMonster(Boolean newGame, File rootDir) throws IOException {
        if (newGame){
            char[][] m = Map.getNewMap(rootDir);
        }
    }
}
