package breakthru;

public class Fleet {

    private String name;
    private Ship[] ships;

    public Fleet(int numShips){
        ships = new Ship[numShips];
    }

    public void addShip(Ship ship){

    }

    public String getName(){
        return this.name;
    }

    public Ship[] getShips(){
        return this.ships;
    }
}
