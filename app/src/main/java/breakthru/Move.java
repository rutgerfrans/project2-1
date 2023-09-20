package breakthru;

public class Move {

    private Ship selectedShip;
    private Cell [] availableCells;

    public Move(Ship selectedShip, Cell[] availableCells) {
        this.selectedShip = selectedShip;
        this.availableCells = availableCells;
    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    public void setSelectedShip(Ship selectedShip) {
        this.selectedShip = selectedShip;
    }

    public Cell[] getAvailableCells() {
        return availableCells;
    }

    public void setAvailableCells(Cell[] availableCells) {
        this.availableCells = availableCells;
    }
}
