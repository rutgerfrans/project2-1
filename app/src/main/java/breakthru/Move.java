package breakthru;

public class Move {

    /**
     * method that moves a ship from a to b
     * it checks board boundaries and availability of the cell
     * it also checks if a player wants to move diagonally, which is not allowed
     * TODO make sure a ship doesnt move through another ship
     * @param currentCell is the current cell
     * @param newRow is the new row location of the ship
     * @param newColumn is the new column location of the ship
     *
     */
    public static void moveShip(Cell currentCell, int newRow, int newColumn){
        Cell newCell = App.board.getCell(newRow, newColumn);

        if(newRow >= 0 && newRow < App.board.getHeight() && newColumn >=0 && newColumn < App.board.getWidth()){

            if(App.board.getCell(newRow,newColumn).getStatus() == null){
                if(newRow == currentCell.getRow() || newColumn == currentCell.getColumn()){
                    newCell.updateStatus(currentCell.getStatus());
                    currentCell.updateStatus(null);
                }
            }
        }
    }
}
