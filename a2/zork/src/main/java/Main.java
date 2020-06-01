import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Boolean playing = true;
        Boolean newGame = null;
        //need command
        //System.out.println(Map.getOriginalMap(new File("/Users/natthakan/muic/iccs330/a2/map1.txt")));
        //Map.getNewMap(new File("/Users/natthakan/muic/iccs330/a2/map1.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.println("New game y/n");
        String temp = sc.nextLine();
        String map = null;
        while (newGame == null) {
            if (temp.equals("y")) {
                newGame = true;
                System.out.println("pls select map 1/2");
                map = sc.nextLine();
            }else if(temp.equals("n")){
                newGame = false;
            }else{
                System.out.println("Invalid in put");
                temp = sc.nextLine();
            }
        }
        while(playing){
            if (newGame){
                Game.setStat(true);
                if (map.equals("1")){
                    Map.getNewMap(new File("/Users/natthakan/muic/iccs330/a2/map1.txt")); //will create function
                    Game.getMonster(true, new File("/Users/natthakan/muic/iccs330/a2/map1.txt"));
                }else{
                    System.out.println("Not created yet");
                }
            }
            //need a function to load saved game
            //need function to retrieve stat
            //need a save function

        }
    }
}
