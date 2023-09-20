package breakthru;

public class Player {
    private final String name;
    private final Fleet fleet;
    private boolean win;

    public Player(String name, Fleet fleet){
        this.name = name;
        this.fleet = fleet;
    }
    public String getName(){
        return this.name;
    }
    public Fleet getFleet(){
        return this.fleet;
    }
}
