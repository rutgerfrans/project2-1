package breakthru;

public class Ship {
    
    private final String type;
    private final Fleet fleet;

    public Ship(String type, Fleet fleet){
        this.type = type;
        this.fleet = fleet;
    }

    public String getType(){
        return this.type;
    }

    public Fleet getFleet(){
        return this.fleet;
    }

}
