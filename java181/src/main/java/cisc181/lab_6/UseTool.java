package cisc181.lab_6;

import java.util.Random;

public class UseTool {
    protected Game181H game;

    public UseTool(Game181H game){
        this.game = game;
    }

    public boolean validUseToolAction(Tool pTool){
        //Check if item is coin
        if(pTool.getToolType() != Tool.ITEM.COIN){
            // If not a coin check if the toolbox has a matching tool and return result
            return game.getCurrentTeam().getToolBox().hasTool(pTool.getToolType(), pTool.getToolStrength());
        }else{
            // Return false if tool is coin
            return false;
        }
    }

    public void exchangeTool(Tool exchangedTool, ToolBox fromBox, ToolBox toBox){
        // Check if fromBox has the tool to exchange
        if(fromBox.hasTool(exchangedTool.getToolType(), exchangedTool.getToolStrength())){
            // Remove tool from fromBox
            fromBox.removeTool(exchangedTool.getToolType(), exchangedTool.getToolStrength());
            // Add tool to toBox
            fromBox.addTool(exchangedTool);
        }
    }

    private void performHide(boolean appliedBool, boolean applyAll, TeamH team){
        if(applyAll){ // If all pieces are to be changed
            // Loop through pieces on team and apply bool
            for (Piece piece : team.getTeamPieces()){
                piece.setHidden(appliedBool);
            }
        }else{ // If all pieces are not to be changed, do a random one
            int randPiece; // Index to hold random piece index
            // Get a random number between 0 and last list index inclusive
            randPiece = (int)(Math.random() * team.getTeamPieces().size());
            // Apply bool
            team.getTeamPieces().get(randPiece).setHidden(appliedBool);
        }
    }

    private void spawnRandomHen(){
        PieceBlueHen newPiece = new PieceBlueHen("Eggbert",game.getCurrentTeam().getTeamColor(),0,0); // Create new blue hen on current team
        BoardSpace toSpace = game.getBoard().findRandomEmptySpace(); // Find space to put hen
        game.getCurrentTeam().getTeamPieces().add(newPiece); // Add piece to current teams array
        toSpace.setPiece(newPiece); // Set piece to exist in random space
    }

    public void performToolAction(Tool usedTool) {
        // Check if tool is usable
        if (validUseToolAction(usedTool)) {
            if (usedTool.getToolStrength() == Tool.STRENGTH.SILVER) {
                if (usedTool.getToolType() == Tool.ITEM.HEN_EGG) {
                    // Spawn one random hen for current team
                    spawnRandomHen();
                }
                if (usedTool.getToolType() == Tool.ITEM.CLOAK) {
                    // Hide one of current team pieces
                    performHide(true, false, game.getCurrentTeam());
                }

                if (usedTool.getToolType() == Tool.ITEM.GLASSES) {
                    // Unhide one of opponent pieces
                    performHide(false, false, game.getOpponentTeam());
                }
            }

            if (usedTool.getToolStrength() == Tool.STRENGTH.GOLD) {
                if (usedTool.getToolType() == Tool.ITEM.HEN_EGG) {
                    // Spawn 2 random hen eggs
                    spawnRandomHen();
                    spawnRandomHen();
                }
                if (usedTool.getToolType() == Tool.ITEM.GLASSES) {
                    // Unhide all opponent pieces
                    performHide(false, true, game.getOpponentTeam());
                }

            }
            //Remove tool after use
            game.getCurrentTeam().getToolBox().removeTool(usedTool.getToolType(), usedTool.getToolStrength());
            // Add to game toolbox
            game.gameToolBox.addTool(usedTool);
            game.changeTurn();
        }else{
            System.out.println("Tried to use unusable tool");
        }
    }

}
