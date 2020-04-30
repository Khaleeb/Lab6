package cisc181.lab_6;

public class ActionAttack extends Action {

   // constructor
    public ActionAttack(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    // Check to see if this is valid Attack Action
    public boolean validAction() {

        // check if from space valid
        if(fromSpaceValid()) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromSpaceRow][fromSpaceCol].getPiece();
            // check to see if this piece has implemented the Attacker interface
            if (Attacker.class.isAssignableFrom(fromPiece.getClass())) {
                // if to space is valid - should NOT be empty so pass false to the method
                if (toSpaceValid(false)) {
                    return validActionPath();
                }
            } else {
                System.out.println("The piece on first space can't attack.");
                return false;
            }
        }
        return false;
    }

   // this method calls the Piece's attack method

    private void attack(){
        // Get the piece that is in the fromSpace
        Piece attPiece = game.getBoard()
                .getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        // check to see which type of Piece we have
        // we can't call the attack method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Attacker Interface
        // so we will cast the Piece to its subclass type so we can call attack
        if(attPiece instanceof PieceBlueHen){
            // cast and call BlueHen's attack method
             ((PieceBlueHen) attPiece)
                    .attack(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
        else if(attPiece instanceof PiecePenguin){
            // cast and call Penguin's attack method
            ((PiecePenguin) attPiece)
                    .attack(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
    }


    public void performAction() {
        if(validAction()){
            attack();
            // Remove piece at attacked position
            game.board.getSpaces()[toSpaceRow][toSpaceCol].removePiece();
            // Set new position to have attacking piece
            game.board.getSpaces()[toSpaceRow][toSpaceCol].setPiece(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece());
            // Remove piece from old position
            game.board.getSpaces()[fromSpaceRow][fromSpaceCol].removePiece();
            // Change turn
            game.changeTurn();
        }else{
            System.out.println("Invalid Attack");
        }
      // FIX ME
    }
}
