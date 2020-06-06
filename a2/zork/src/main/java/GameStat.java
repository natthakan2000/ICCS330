import java.util.List;

public class GameStat {
    private String name;
    private int hp;
    private int power;
    private char[][] map;
    private String room;
    private int monsterHp;
    private int monsterPower;
    private List<Integer> allMonster;
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
    public void setMonsterHp(int hp){
        this.monsterHp = hp;
    }
    public int getMonsterHp(){
        return monsterHp;
    }
    public void setMonsterPower(int power){
        this.monsterPower = power;
    }
    public int getMonsterPower(){
        return monsterHp;
    }
    public void setAllMonster(List<Integer> allMoster){
        this.allMonster = allMoster;
    }
    public List<Integer> getAllmonster(){
        return allMonster;
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
