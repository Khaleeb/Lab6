package cisc181.lab_6;
//Represents an action the user can take where they move their move
public class ActionMove extends Action {
    //constructor
    public ActionMove(Game181H game,int fromSpaceRow,int fromSpaceCol,int toSpaceRow,int toSpaceCol){
        super(game,fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }
    //checks that the action is valid
    public boolean validAction(){
        Piece fromPiece = game.getBoard().getSpaces()
                [fromSpaceRow][fromSpaceCol].getPiece();

        if(fromPiece instanceof PieceDepartmentDean){
            if(((PieceDepartmentDean) fromPiece).isBunkered){
                return false;
            }
        }

        if(fromSpaceValid() == true && toSpaceValid(true) == true && validActionPath() == true) {
            return true;
        }
        return false;
    }
    //checks that the action is performable
    public void performAction() {
        Piece temp = game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece();
        game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(temp);
        game.changeTurn();
    }


}
