package cisc181.lab_6;

public class BoardSpace {
    private int row;  // index of row
    private int column;  //index of column
    private String spaceColor; // color  of space
    private Piece piece;
    private boolean empty;

    public BoardSpace(int row, int column, String color){
        // each spot on the board has a row and column and by default is empty
        this.row = row;
        this.column = column;
        this.spaceColor = color;
        // default empty space - no piece
        this.empty = true;
    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public Piece getPiece(){
        return piece;
    }
    public String getSpaceColor(){
        return spaceColor;
    }
    public boolean isEmpty(){
        return empty;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        this.empty = false;
    }
    public Piece removePiece(){
        Piece currPiece = this.piece;
        this.piece = null;
        this.empty = true;
        return currPiece;
    }

    public String toString(){
        return (isEmpty() ? "------" : piece.toString());
    }
}
