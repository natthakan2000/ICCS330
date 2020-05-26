public class Help {
    public static void helper(){
        System.out.println("Available commands are: ");
        String[] str = new String[]{"info", "take", "drop", "attack with", "go {direction}", "map", "autopilot {file}", "help", "quit", "play {map-name}, load {saved-point-name}, save {saved-point-name}", "exit"};
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
