package cisc181.lab_6;

// class to represent actions that the players can make during their turns
public abstract class Action {
    protected Game181H game;
    protected int fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol;

    // 5 parameter constructor
    public Action(Game181H game, int rowF, int colF, int rowT, int colT){
        this.game = game;
        this.fromSpaceRow = rowF;
        this.fromSpaceCol = colF;
        this.toSpaceRow = rowT;
        this.toSpaceCol = colT;
    }

    // returns true if from space is valid
    public boolean fromSpaceValid(){
        return(this.game.getBoard().inBounds(this.fromSpaceRow,this.fromSpaceCol) && this.game.getCurrentTeam().getTeamPieces().contains(this.game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece()));
    }

    // Returns true if to space is valid
    public boolean toSpaceValid(boolean empty){
        if(empty){
            return (this.game.getBoard().inBounds(toSpaceRow, toSpaceCol) && this.game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].isEmpty());
        } else {
            return (this.game.getBoard().inBounds(toSpaceRow, toSpaceCol) && this.game.getOpponentTeam().getTeamPieces().contains(this.game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece()));
        }
    }

    // Returns true if path is valid
    public boolean validActionPath(){
        return(this.game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece().validPath(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol));
    }

    // Abstract method, returns if action is valid
    public abstract boolean validAction();

    // Abstract method, performs action
    public abstract void performAction();
}
