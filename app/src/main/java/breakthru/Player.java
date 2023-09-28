package breakthru;

public class Player {
    private final String name;
    private final String type;
    private Cell lastShipMoved;
    private int moveCounter = 2;
    private boolean win;

    public Player(String name, String type){
        this.name = name;
        this.type = type;
    }
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getMoveCounter(){
        return this.moveCounter;
    }
    public void setMoveCounter(int moveCounter){
        this.moveCounter = moveCounter;
    }
    public void setLastShipMoved(Cell cell){
        this.lastShipMoved = cell;
    }
    public Cell getLastShipMoved(){
        return this.lastShipMoved;
    }
}
