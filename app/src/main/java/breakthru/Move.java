package breakthru;

public class Move {

    /**
     * method that moves a ship from a to b
     * it checks board boundaries and availability of the cell
     * it also checks if a player wants to move diagonally, which is not allowed
     * @param currentCell is the current cell
     * @param newCell      is the new cell
     *
     */
    public static void moveShip(Cell currentCell, Cell newCell) {
        if (newCell.getRow() >= 0 && newCell.getRow() < App.board.getHeight() && newCell.getColumn() >= 0 && newCell.getColumn() < App.board.getWidth()) {
            if (newCell.getStatus() == null) {
                if (newCell.getRow() == currentCell.getRow() || newCell.getColumn() == currentCell.getColumn()) {
                    if (!shipConflict(currentCell, newCell.getRow() , newCell.getColumn())) {
                        newCell.updateStatus(currentCell.getStatus());
                        currentCell.updateStatus(null);
                    }
                }
            }else{
                takeOver(currentCell, newCell);
            }
        }
    }

    /**
     * method that checks if a ship moves through another ship
     * it checks in what way the ships moves, right, left, up and, down.
     * it also checks each previous position if the status of the cell was not null (containing a conflicted ship)
     * @param currentCell is the current cell
     * @param newRow      is the new row location of the ship
     * @param newColumn   is the new column location of the ship
     * @return conflict is a boolean which is true when there is a conflict and false when there isn't
     */
    public static boolean shipConflict(Cell currentCell, int newRow, int newColumn) {
        boolean conflict = false;

        if (newRow > currentCell.getRow()) {
            for (int row = currentCell.getRow() + 1; row < newRow; row++) {
                if (App.board.getCell(row, newColumn).getStatus() != null) {
                    conflict = true;
                    break;
                }
            }
        }

        else if (newColumn > currentCell.getColumn()) {
            for (int column = currentCell.getColumn() + 1; column < newColumn; column++) {
                if (App.board.getCell(newRow, column).getStatus() != null) {
                    conflict = true;
                    break;
                }
            }
        }

        else if (newRow < currentCell.getRow()) {
            for (int row = currentCell.getRow() - 1; row > newRow - 1; row--) {
                if (App.board.getCell(row, newColumn).getStatus() != null) {
                    conflict = true;
                    break;
                }
            }
        }

        else {
            for (int column = currentCell.getColumn() - 1; column > newColumn - 1; column--) {
                if (App.board.getCell(newRow, column).getStatus() != null) {
                    conflict = true;
                    break;
                }
            }
        }
        return conflict;
    }

    /**
     * method that allows a player to capture a ship
     * it checks if a player is capturing a flagship or a normal ship
     * @param currentCell is the current cell
     * @param newCell is the new location of the ship
     */
    public static void takeOver(Cell currentCell, Cell newCell) {

        if (!newCell.getStatus().getType().equals(currentCell.getStatus().getType()) && validCapture(currentCell, newCell)) {
            if (newCell.getStatus().getType().equals("FLAGSHIP")) {

                System.out.println("Someone won.");

            } else {
                // newCell.getStatus().getFleet().removeShip(newCell.getStatus());
                System.out.println("we take over.");
                newCell.updateStatus(currentCell.getStatus());
                currentCell.updateStatus(null);

            }
        } else {
            System.out.println("YOU CAN'T TAKE OVER");
        }
    }

    /**
     * method that checks if a capture move is valid
     * @param currentCell is the current cell
     * @param newCell is the new location of the ship
     * @return returns a false or true statement based on the valid move
     */
    public static boolean validCapture(Cell currentCell, Cell newCell){
        if(newCell.getRow() == (currentCell.getRow() - 1) && newCell.getColumn() == (currentCell.getColumn()-1)){
            return true;
        }else if(newCell.getRow() == (currentCell.getRow() - 1) && newCell.getColumn() == (currentCell.getColumn()+1)){
            return true;
        }else if(newCell.getRow() == (currentCell.getRow() + 1) && newCell.getColumn() == (currentCell.getColumn()-1)){
            return true;
        }else return newCell.getRow() == (currentCell.getRow() + 1) && newCell.getColumn() == (currentCell.getColumn() + 1);
    }
}