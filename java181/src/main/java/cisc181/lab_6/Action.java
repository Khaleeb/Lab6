package cisc181.lab_6;

// class to represent actions that the players can make during their turns
public abstract class Action {
    private Game181H game;
    private int rowF, colF, rowT, colT;

    // 5 parameter constructor
    public Action(Game181H game, int rowF, int colF, int rowT, int colT){
        this.game = game;
        this.rowF = rowF;
        this.colF = colF;
        this.rowT = rowT;
        this.colT = colT;
    }

    // returns true if from space is valid
    public boolean fromSpaceValid(){
        return(this.game.getBoard().inBounds(this.rowF,this.colF) && this.game.getCurrentTeam().getTeamPieces().contains(this.game.getBoard().getSpaces()[this.rowF][this.colF].getPiece()));
    }

    // Returns true if to space is valid
    public boolean toSpaceValid(boolean empty){
        if(empty){
            return (this.game.getBoard().inBounds(this.rowT, this.colT) && this.game.getBoard().getSpaces()[this.rowT][this.colT].isEmpty());
        } else {
            return (this.game.getBoard().inBounds(this.rowT, this.colT) && this.game.getOpponentTeam().getTeamPieces().contains(this.game.getBoard().getSpaces()[this.rowT][this.colT].getPiece()));
        }
    }

    // Returns true if path is valid
    public boolean validActionPath(){
        return(this.game.getBoard().getSpaces()[this.rowF][this.colF].getPiece().validPath(this.rowF, this.colF, this.rowT, this.colT));
    }

    // Abstract method, returns if action is valid
    public abstract boolean validAction();

    // Abstract method, performs action
    public abstract void performAction();
}
