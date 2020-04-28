package cisc181.lab_6;

public class Board {

    // rows start start at top of board with row 0
    //columns start at left side of board with column 0
    private BoardSpace[][] spaces; // 2 Dimensional Array of spaces
    private int numRows;
    private int numColumns;

    public Board(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.spaces = new BoardSpace[numRows][numColumns];
        setUpEmptyBoard();    }

    public BoardSpace[][] getSpaces() {
        return spaces;
    }
    public int getNumRows() {
        return numRows;
    }
    public int getNumColumns() {
        return numColumns;
    }

    public void setUpEmptyBoard(){
        // set up all spots on board - alternate colors with black and white
        // by default a space is empty
        boolean black = true;
        for(int row = 0; row < spaces.length; row++) {
            for (int col = 0; col < spaces[row].length; col++) {
                black = !black;
                spaces[row][col] = new BoardSpace(row,col,(black ? "Black" : "White"));;
                //System.out.println(spaces[row][col].getPiece().toString());
            }
        }
    }

    public BoardSpace findRandomEmptySpace(){
        // find a random empty space on the board
        boolean valid = false;
        int randomRow = -1;
        int randomColumn = -1;
        while (!valid){
            randomRow =  (int)(Math.random()*this.numRows);
            randomColumn = (int)(Math.random()*this.numColumns);
            if(spaces[randomRow][randomColumn].isEmpty()){
                //  spot currently doesn't have a piece on it
                valid = true;
            }
        }
        return spaces[randomRow][randomColumn];
    }

    public boolean inBounds(int row, int column){
        return row >= 0 && row < numRows && column >= 0 && column < numColumns;
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
