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
        System.out.println(" Type 'B' to bunker");
        System.out.println(" Type 'T' to use a Tool");
        System.out.print("ENTER: ");
        String input = sc.nextLine(); // Due to some quirkiness with ide's this just skips sometimes???
        char userInput;
        if(input.length() >= 1){userInput = input.charAt(0);}else{ // Safety for when it skips
            userInput = '\23';
        }
        while (acceptableInput==false){
            if (userInput == 'A' || userInput == 'R' || userInput == 'M' || userInput == 'T' || userInput == 'B'){
                acceptableInput = true;
            }
            else {
                if(userInput != '\23') {
                    System.out.println("Not valid input");
                }
                input = sc.nextLine();
                if(input.length() >= 1){userInput = input.charAt(0);}else{
                    userInput = 'f';
                }
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
                case "HEN_EGG":
                    toolI = Tool.ITEM.HEN_EGG;
                    acceptableInput = true;
                    break;
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



    private void nextPlayersAction(Scanner sc){
        boolean acceptable = false;
        while (acceptable == false){
            char action = getValidActionType(sc);

            if(action == 'M' || action == 'R' || action == 'A'){
                System.out.println("Enter row and column of current piece ");
                int fromRow = sc.nextInt();
                int fromCol = sc.nextInt();
                System.out.println("Enter row and column you would like to perform the action on (ignore for bunker)");
                int actionRow = sc.nextInt();
                int actionCol = sc.nextInt();
                System.out.println(fromRow + " " +fromCol + " " +actionRow + " " +actionCol + " " +action);
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
                } else if (action == 'B') {
                    ActionBunker bunker = new ActionBunker(game181H, fromRow, fromCol, actionRow, actionCol);
                    if (bunker.validAction()) {
                        bunker.performAction();
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

    public void playOurGame(Scanner sc) {
        nextPlayersAction(sc);
        System.out.println(game181H);
        while (game181H.isGameEnded() == false) {
            nextPlayersAction(sc);
            System.out.println(game181H);
        }
        System.out.println("Winning team is : " + game181H.getWinner());
    }

    public static void main(String[] args) {
        // Scanner
        Scanner sc = new Scanner(System.in);

        // Create Array for teams
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        ArrayList<Piece> piecesTeamB = new ArrayList<>();

        // Setup Teams
        String A_color = "Red";

        setupTeam("A",piecesTeamA, sc,A_color);

        System.out.println("Selection Done");

        String B_color = "Green";

        setupTeam("B",piecesTeamB, sc,B_color);

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        TeamH teamA = new TeamH("A", "Red",piecesTeamA);
        TeamH teamB = new TeamH("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181H ourGame = new Game181H(7, 7,teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame(sc);

    }

    public static void setupTeam(String teamAB, ArrayList Team, Scanner sc,String color){
        // Get team color
        System.out.println("Team Setup for team " + teamAB);
        // Start setting up piece selection
        int points = 12;
        Team.add(new PieceHeadDean("Dean",color));
        int input;
        while(points > 0){
            System.out.println("You have " + points + " points, select a piece to add to your team.");
            System.out.println("1. Shark Bait (1)");
            System.out.println("2. Penguin (2)");
            System.out.println("3. Blue Hen (3)");
            System.out.println("4. Department Dean (4)");
            System.out.print("Select: ");
            while(!sc.hasNextLine()){}
            input = sc.nextInt();
            if(input == 1){
                Team.add(new PieceSharkBait("Bait",color));
                points -= 1;
            }else if((input == 2) && (points >= 2)){
                Team.add(new PiecePenguin("Peng",color,0,0));
                points -= 2;
            }else if((input == 3) && (points >= 3)){
                Team.add(new PieceBlueHen("BHen",color,0,0));
                points -= 3;
            }else if((input == 4) && (points >= 4)){
                Team.add(new PieceDepartmentDean("Dept",color));
                points -= 4;
            }
        }


        return;
    }
}
