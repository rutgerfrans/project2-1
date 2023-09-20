package breakthru;

public class Cell{
    
    private int row;
    private int column;
    private Ship status;

    public Cell(int row, int column, Ship status){
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }
    public Ship getStatus(){
        return this.status;
    }
    public void updateStatus(Ship status){
        this.status = status;
    }
}
