package breakthru;

public class Move {

    public static void moveShip(Player player, Cell currentCell, Cell newCell) {
        if (!isValidMove(player, currentCell, newCell)) {
            return;
        }

        if (isCorrectFleet(player, currentCell)) {
            if (isWithinBoardBounds(newCell) && isNewCellFree(newCell)) {
                if (isMovingInStraightLine(currentCell, newCell) && !shipConflict(currentCell, newCell.getRow(), newCell.getColumn())) {
                    updateCellsAndPlayer(player, currentCell, newCell);
                }
            } else {
                takeOver(currentCell, newCell);
            }
        } else {
            System.out.println("Not your ship, you can't move it.");
        }
    }

    private static boolean isValidMove(Player player, Cell currentCell, Cell newCell) {
        return currentCell != player.getLastShipMoved() && player.getMoveCounter() > 0;
    }

    private static boolean isCorrectFleet(Player player, Cell currentCell) {
        return currentCell.getStatus().getType().equals(player.getType());
    }

    private static boolean isWithinBoardBounds(Cell newCell) {
        int boardHeight = App.board.getHeight();
        int boardWidth = App.board.getWidth();
        return newCell.getRow() >= 0 && newCell.getRow() < boardHeight && newCell.getColumn() >= 0 && newCell.getColumn() < boardWidth;
    }

    private static boolean isNewCellFree(Cell newCell) {
        return newCell.getStatus() == null;
    }

    private static boolean isMovingInStraightLine(Cell currentCell, Cell newCell) {
        return newCell.getRow() == currentCell.getRow() || newCell.getColumn() == currentCell.getColumn();
    }

    private static void updateCellsAndPlayer(Player player, Cell currentCell, Cell newCell) {
        newCell.updateStatus(currentCell.getStatus());
        currentCell.updateStatus(null);
        player.setLastShipMoved(newCell);

        if (newCell.getStatus().getType().equals("Flag")) {
            player.setMoveCounter(0);
        } else {
            player.setMoveCounter(player.getMoveCounter() - 1);
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

                System.out.println("Silver won.");

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