package cisc181.lab_6;

public class PurchaseTool {
    protected Game181H game;

    public PurchaseTool(Game181H game){
        this.game = game;
    }

    public boolean validToolPurchase(Tool coin, Tool tool){
        // Check if coin is actually a coin and based on strength see if the tool is in the needed spot

        if(coin.getToolType() == Tool.ITEM.COIN){
            if(coin.getToolStrength() == Tool.STRENGTH.SILVER){
                return game.getGameToolBox().hasTool(tool.getToolType(), tool.getToolStrength());
            }

            if(coin.getToolStrength() == Tool.STRENGTH.GOLD){
                return game.getGameToolBox().hasTool(tool.getToolType(), tool.getToolStrength()) || game.getOpponentTeam().getToolBox().hasTool(tool.getToolType(), tool.getToolStrength());
            }
        }
        // Return false otherwise
        return false;
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

    public void performToolPurchase(Tool coin, Tool tool){
        // Check if tool purchase is valid
        if(validToolPurchase(coin, tool)) {
            // Remove coin being used from current teams toolbox
            game.getCurrentTeam().getToolBox().removeTool(coin.getToolType(),coin.getToolStrength());

            // Take from game box if coin is silver
            if(coin.getToolStrength() == Tool.STRENGTH.SILVER){
                game.getGameToolBox().removeTool(tool.getToolType(),tool.getToolStrength());
                game.getCurrentTeam().getToolBox().addTool(tool);

                // Take from opponent if possible or game box otherwise
            }else if(coin.getToolStrength() == Tool.STRENGTH.GOLD){
                if(game.getOpponentTeam().getToolBox().hasTool(tool.getToolType(), tool.getToolStrength())){
                    game.getOpponentTeam().getToolBox().removeTool(tool.getToolType(),tool.getToolStrength());
                    game.getCurrentTeam().getToolBox().addTool(tool);
                }else{
                    game.getGameToolBox().removeTool(tool.getToolType(),tool.getToolStrength());
                    game.getCurrentTeam().getToolBox().addTool(tool);
                }
            }
            // Change turn
            game.changeTurn();
        }
    }
}
