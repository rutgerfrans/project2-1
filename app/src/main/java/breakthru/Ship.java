package breakthru;

public class Ship {
    
    private String type;
    private Fleet fleet;

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
