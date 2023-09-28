package breakthru;

public class Board {

    private final Cell[][] board;

    public Board(int numRows, int numColumns){
        board = new Cell[numRows][numColumns];
    }

    // width in columns
    public int getWidth(){
        return this.board[0].length;
    }

    // height in rows
    public int getHeight(){
        return this.board.length;
    }

    public void addCell(Cell cell){
        board[cell.getRow()][cell.getColumn()] = cell;
    }

    public Cell getCell(int row, int column){
        return this.board[row][column];
    }

}
