package cisc181.lab_6;
import java.util.*;

public class PlayGameH {
    private Game181H game181H;

    public PlayGameH (Game181H game181H) {
        this.game181H = game181H;
    }

    private char getValidActionType(Scanner sc) {
        boolean acceptableInput = false;
        System.out.println(game181H.getCurrentTeam());
        System.out.println("Type a character and hit enter to perform an action");
        System.out.println(" Type 'M' to move");
        System.out.println(" Type 'R' to recruit");
        System.out.println(" Type 'A' to attack");
        System.out.println(" Type 'T' to use a Tool");
        System.out.print("ENTER: ");
        char userInput = sc.nextLine().charAt(0);
        while (acceptableInput==false){
            if (userInput == 'A' || userInput == 'R' || userInput == 'M' || userInput == 'T'){
                acceptableInput = true;
            }
            else {
                System.out.println("Not valid input");
                userInput = sc.nextLine().charAt(0);
            }
        }
        return userInput;
    }


    // Returns tool being used
    private Tool getValidTool(Scanner sc) {
        boolean acceptableInput = false;
        Tool.STRENGTH toolS = null;
        Tool.ITEM toolI = null;
        System.out.printf("Tool Strength: ");
        String tStrength = sc.nextLine().toUpperCase();
        while(!acceptableInput){
            switch(tStrength) {
                case "GOLD":
                    toolS = Tool.STRENGTH.GOLD;
                    acceptableInput = true;
                    break;
                case "SILVER":
                    toolS = Tool.STRENGTH.SILVER;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Strength");
            }
        }
        System.out.printf("Tool Type: ");
        String tType = sc.nextLine().toUpperCase();
        acceptableInput = false;
        while (!acceptableInput) {
            switch (tType) {
                case "COIN":
                    toolI = Tool.ITEM.COIN;
                    acceptableInput = true;
                    break;
                case "GLASSES":
                    toolI = Tool.ITEM.GLASSES;
                    acceptableInput = true;
                    break;
                case "CLOAK":
                    toolI = Tool.ITEM.CLOAK;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Item");
            }
        }



        Tool tool = new Tool(toolI, toolS);
        if (this.game181H.getCurrentTeam().getToolBox().hasTool(tool.getToolType(), tool.getToolStrength())){
            return tool;
        } else {
            System.out.println("Tool not in Team's toolbox");
            tool = getValidTool(sc);
            return tool;
        }
    }


    // Returns tool being purchased with GOLD COIN
    private Tool getValidToolGOLD(Scanner sc) {
        boolean acceptableInput = false;
        Tool.STRENGTH toolS = null;
        Tool.ITEM toolI = null;
        System.out.printf("Tool Strength: ");
        String tStrength = sc.nextLine().toUpperCase();
        while(!acceptableInput){
            switch(tStrength) {
                case "GOLD":
                    toolS = Tool.STRENGTH.GOLD;
                    acceptableInput = true;
                    break;
                case "SILVER":
                    toolS = Tool.STRENGTH.SILVER;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Strength");
            }
        }
        System.out.printf("Tool Type: ");
        String tType = sc.nextLine().toUpperCase();
        acceptableInput = false;
        while (!acceptableInput) {
            switch (tType) {
                case "COIN":
                    toolI = Tool.ITEM.COIN;
                    acceptableInput = true;
                    break;
                case "GLASSES":
                    toolI = Tool.ITEM.GLASSES;
                    acceptableInput = true;
                    break;
                case "CLOAK":
                    toolI = Tool.ITEM.CLOAK;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Item");
            }
        }



        Tool tool = new Tool(toolI, toolS);
        if (this.game181H.getOpponentTeam().getToolBox().hasTool(tool.getToolType(), tool.getToolStrength()) || this.game181H.getGameToolBox().hasTool(tool.getToolType(), tool.getToolStrength())){
            return tool;
        } else {
            System.out.println("Tool not available");
            tool = getValidTool(sc);
            return tool;
        }
    }


    // Returns tool being purchased with SILVER COIN
    private Tool getValidToolSILVER(Scanner sc) {
        boolean acceptableInput = false;
        Tool.STRENGTH toolS = null;
        Tool.ITEM toolI = null;
        System.out.printf("Tool Strength: ");
        String tStrength = sc.nextLine().toUpperCase();
        while(!acceptableInput){
            switch(tStrength) {
                case "GOLD":
                    toolS = Tool.STRENGTH.GOLD;
                    acceptableInput = true;
                    break;
                case "SILVER":
                    toolS = Tool.STRENGTH.SILVER;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Strength");
            }
        }
        System.out.printf("Tool Type: ");
        String tType = sc.nextLine().toUpperCase();
        acceptableInput = false;
        while (!acceptableInput) {
            switch (tType) {
                case "COIN":
                    toolI = Tool.ITEM.COIN;
                    acceptableInput = true;
                    break;
                case "GLASSES":
                    toolI = Tool.ITEM.GLASSES;
                    acceptableInput = true;
                    break;
                case "CLOAK":
                    toolI = Tool.ITEM.CLOAK;
                    acceptableInput = true;
                    break;
                default:
                    System.out.println("Not a valid tool Item");
            }
        }



        Tool tool = new Tool(toolI, toolS);
        if (this.game181H.getGameToolBox().hasTool(tool.getToolType(), tool.getToolStrength())){
            return tool;
        } else {
            System.out.println("Tool not available");
            tool = getValidTool(sc);
            return tool;
        }
    }



    private void nextPlayersAction(){
        Scanner sc = new Scanner(System.in);
        boolean acceptable = false;
        while (acceptable == false){
            char action = getValidActionType(sc);

            if(action == 'M' || action == 'R' || action == 'A'){
                System.out.println("Enter row and column of current piece ");
                int fromRow = sc.nextInt();
                int fromCol = sc.nextInt();
                System.out.println("Enter row and column you would like to perform the action on");
                int actionRow = sc.nextInt();
                int actionCol = sc.nextInt();
                if (action == 'A') {
                    ActionAttack attack = new ActionAttack(game181H, fromRow, fromCol, actionRow, actionCol);
                    if (attack.validAction()) {
                        attack.performAction();
                        acceptable = true;
                    } else {
                        System.out.println("Action not valid");
                    }
                } else if (action == 'M') {
                    System.out.println("You want to move");
                    ActionMove move = new ActionMove(game181H, fromRow, fromCol, actionRow, actionCol);
                    if (move.validAction()) {
                        move.performAction();
                        acceptable = true;
                    } else {
                        System.out.println("Action not valid");
                    }
                } else if (action == 'R') {
                    ActionRecruit recruit = new ActionRecruit(game181H, fromRow, fromCol, actionRow, actionCol);
                    if (recruit.validAction()) {
                        recruit.performAction();
                        acceptable = true;
                    } else {
                        System.out.println("Action not valid");
                    }
                }
            } else if (action == 'T') {
                System.out.println(this.game181H.getCurrentTeam().getToolBox().toString());
                Tool tAction = this.getValidTool(sc);

                if (tAction.getToolType() == Tool.ITEM.COIN && tAction.getToolStrength() == Tool.STRENGTH.GOLD) {
                    // gold coin used
                    System.out.println("Purchasable tools: " + this.game181H.getGameToolBox().toString() + this.game181H.getOpponentTeam().getToolBox().toString());
                    Tool tPurchase = this.getValidToolGOLD(sc);
                    PurchaseTool purchaseTool = new PurchaseTool(game181H);
                    if(purchaseTool.validToolPurchase(tAction,tPurchase)){
                        purchaseTool.performToolPurchase(tAction, tPurchase);
                        acceptable = true;
                    }
                } else if (tAction.getToolType() == Tool.ITEM.COIN && tAction.getToolStrength() == Tool.STRENGTH.SILVER) {
                    // silver coin used
                    System.out.println("Purchasable tools: " + this.game181H.getGameToolBox().toString());
                    Tool tPurchase = this.getValidToolSILVER(sc);
                    PurchaseTool purchaseTool = new PurchaseTool(game181H);
                    if(purchaseTool.validToolPurchase(tAction,tPurchase)){
                        purchaseTool.performToolPurchase(tAction, tPurchase);
                        acceptable = true;
                    }
                } else {
                    UseTool toolUse = new UseTool(this.game181H);
                    if(toolUse.validUseToolAction(tAction)){
                        toolUse.performToolAction(tAction);
                        acceptable = true;
                    } else {
                        System.out.println("Action not valid");
                    }
                }
                
            } else {
                System.out.println("Action not valid");
            }
        }
    }

    public void playOurGame() {
        nextPlayersAction();
        System.out.println(game181H);
        while (game181H.isGameEnded() == false) {
            nextPlayersAction();
            System.out.println(game181H);
        }
        System.out.println(game181H.getWinner());
    }

    public static void main(String[] args) {

        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);

        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);

        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);

        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        TeamH teamA = new TeamH("A", "Red",piecesTeamA);
        TeamH teamB = new TeamH("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181H ourGame = new Game181H(4, 4,teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame();

    }
}
