package breakthru;

public class Fleet {

    private String type;
    private final Ship[] ships;

    public Fleet(int numShips){
        ships = new Ship[numShips];
    }

    public void addShip(Ship ship){

    }

    public String getType(){
        return this.type;
    }

    public Ship[] getShips(){
        return this.ships;
    }
}
