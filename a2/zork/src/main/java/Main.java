import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Options options = new Options();
        Boolean playing = false;
        Boolean newGame = false;
        options.addOption("info", null, false, "print out information of the player and the room");
        options.addOption("take", null, false, "take command is used to pick up the item in the current room");
        options.addOption("drop", null, false, "drop item of choice that the player currently carries");
        options.addOption("attack with", null, false, "used to attack a monster in the current room");
        options.addOption("go", null, true, "move player to the room as specified by the direction");
        options.addOption("map", null, false, "print 2D map using ascii art");
        options.addOption("autopilot", null, true, "run this game in autopilot mode using the list of command in the file");
        options.addOption("help", null, false, "print all commands");
        options.addOption("quit", null, false, "end the current game and return to command prompt");
        options.addOption("play", null, true, "play new game");
        options.addOption("load", null, false, " load game state from saved point");
        options.addOption("save", null, false, "load game state from saved point");
        options.addOption("exit", null, false, "exit whole game");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);
        if (!playing){
            if (cmd.hasOption("help")){
                Help.helper();
            }if (cmd.hasOption("play")){
                playing = true;
                newGame = true;
            }
        }
        //Boolean newGame = null;
        //need command
        //System.out.println(Map.getOriginalMap(new File("/Users/natthakan/muic/iccs330/a2/map1.txt")));
        //Map.getNewMap(new File("/Users/natthakan/muic/iccs330/a2/map1.txt"));
       // Scanner sc = new Scanner(System.in);
        System.out.println("New game y/n");
        //String temp = sc.nextLine();
        String map = null;
        while(playing){
            System.out.println();
            //need a function to load saved game
            //need function to retrieve stat
        }
    }
}
