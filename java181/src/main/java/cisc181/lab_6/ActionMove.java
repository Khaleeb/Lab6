package cisc181.lab_6;

public class ActionMove extends Action {

    public ActionMove(Game181H game,int fromSpaceRow,int fromSpaceCol,int toSpaceRow,int toSpaceCol){
        super(game,fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    public boolean validAction(){
        if(fromSpaceValid() == true && toSpaceValid(true) == true && validActionPath() == true) {
            return true;
        }
        return false;
    }

    public void performAction() {
        Piece temp = game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece();
        game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(temp);
        game.changeTurn();
    }


}
