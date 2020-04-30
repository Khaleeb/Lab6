package cisc181.lab_6;

import java.util.Collections;

public abstract class GameH {
    protected Board board;
    protected TeamH teamA;
    protected TeamH teamB;
    protected ToolBox gameToolBox;
    protected String turn; // holds the name ofthe team that has the next turn

    public GameH(int rows, int cols,TeamH teamA, TeamH teamB){
        this.teamA = teamA;
        this.teamB = teamB;
        this.turn = teamA.getTeamName();
        this.gameToolBox = new ToolBox(true);
        // give each team a silver coin from toolbox
        teamA.getToolBox().addTool(this.gameToolBox.removeTool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
        teamB.getToolBox().addTool(this.gameToolBox.removeTool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
        initializeGameBoard(rows,cols);
    }

    private void initializeGameBoard(int rows, int cols){
        // create a board object
        this.board = new Board(rows,cols);

        // place team A pieces on board
        for (Piece piece: teamA.getTeamPieces()) {
            BoardSpace emptySpace = this.board.findRandomEmptySpace();
            emptySpace.setPiece(piece);
        }
        // place team B pieces on board
        for (Piece piece: teamB.getTeamPieces()) {
            BoardSpace emptySpace = this.board.findRandomEmptySpace();
            emptySpace.setPiece(piece);
        }
    }

    public ToolBox getGameToolBox() {
        return gameToolBox;
    }

    public Board getBoard() {
        return board;
    }
    public TeamH getCurrentTeam(){
        return teamA.getTeamName().equals(turn)? teamA : teamB;
    }
    public TeamH getOpponentTeam(){
        return teamA.getTeamName().equals(turn)? teamB : teamA;
    }
    public boolean isTurn(TeamH team) {
        return team.getTeamName().equals(turn);
    }
    public void changeTurn() {
        this.turn = getOpponentTeam().getTeamName();
    }

    public abstract boolean isAWinner();
    public abstract TeamH getWinner();
    public abstract boolean isGameEnded();

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game ToolBox:\n").append(gameToolBox.toString());
        retString.append(String.join("", Collections.nCopies(50, "*")))
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nGame Board:\n")
                .append("\n" + getBoard().toString())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

    public String strHiddenBoard() {
        Piece curPiece;
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col : ");
        for (int col = 0; col < getBoard().getSpaces()[0].length; col++) {
            boardString.append(col + " ");
        }
        boardString.append("\n");
        for (int row = 0; row < getBoard().getSpaces().length; row++) {
            boardString.append("Row : " + row + " ");
            for (int col = 0; col < getBoard().getSpaces()[row].length; col++) {
                curPiece = getBoard().getSpaces()[row][col].getPiece();
                if (curPiece == null) {
                    boardString.append("------" + " ");
                }
                // if the Piece is hidden and it belongs to the other
                // team - don&#39;t show it on the board
                else if (curPiece.isHidden() &&
                getOpponentTeam().getTeamPieces().contains(curPiece)){
                    boardString.append("------" + " ");
                }
else {
                    boardString.append(getBoard().getSpaces()[row][col].toString() + " ");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
