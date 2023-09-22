package breakthru;

public class Move {

    /**
     * method that moves a ship from a to b
     * it checks board boundaries and availability of the cell
     * it also checks if a player wants to move diagonally, which is not allowed
     * TODO make sure a ship doesnt move through another ship
     * @param currentCell is the current cell
     * @param newRow      is the new row location of the ship
     * @param newColumn   is the new column location of the ship
     *
     */
    public static void moveShip(Cell currentCell, int newRow, int newColumn) {
        Cell newCell = App.board.getCell(newRow, newColumn);
        if (newRow >= 0 && newRow < App.board.getHeight() && newColumn >= 0 && newColumn < App.board.getWidth()) {
            if (newCell.getStatus() == null) {
                if (newRow == currentCell.getRow() || newColumn == currentCell.getColumn()) {
                    if (!shipConflict(currentCell, newRow, newColumn)) {
                        newCell.updateStatus(currentCell.getStatus());
                        currentCell.updateStatus(null);
                    }
                }
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
}