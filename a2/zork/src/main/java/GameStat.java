public class GameStat {
    private String name;
    private int hp;
    private int power;
    private char[][] map;
    private String room;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMap(char[][] map){
        this.map = map;
    }
    public char[][] getMap(){
        return map;
    }
    public void setRoom(String room){
        this.room = room;
    }
    public String getRoom(){
        return room;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return hp;
    }
    public void setPower(int power){
        this.power = power;
    }
    public int getPower(){
        return power;
    }
}
