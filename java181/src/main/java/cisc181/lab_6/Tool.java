package cisc181.lab_6;

public class Tool {

    // Tool type
    public enum ITEM {CLOAK, GLASSES, COIN, HEN_EGG}
    // Tool Strength
    public enum STRENGTH {GOLD, SILVER}

    private ITEM toolType;
    private STRENGTH toolStrength;

    // Constructor
    public Tool(ITEM toolType, STRENGTH toolStrength) {
        this.toolType = toolType;
        this.toolStrength = toolStrength;
    }

    // Returns tool type
    public ITEM getToolType() {
        return toolType;
    }

    // Returns tool strength
    public STRENGTH getToolStrength() {
        return toolStrength;
    }

    public String getDescription() {
        String toolString = "";
        switch (this.toolType) {
            case HEN_EGG:
                toolString = toolStrength.equals(STRENGTH.GOLD) ?
                        "Spawn two blue hens for your team randomly" :
                        "Spawn one blue hen for your team randomly";
                break;
            case GLASSES:
                toolString = toolStrength.equals(STRENGTH.GOLD) ?
                        "Unhide all of the other team's pieces" :
                        "Unhide one of the other team's pieces";
                break;
            case CLOAK:
                toolString = toolStrength.equals(STRENGTH.SILVER) ?
                        "Hide one of your own team's pieces" :
                        "Unidentified tool";
                break;
            case COIN:
                toolString = toolStrength.equals(STRENGTH.GOLD) ?
                        "Trade for any tool in the game" :
                        "Buy any tool from the game's toolbox";
                break;
            default:
                // unidentified
                toolString = "Unidentified tool";
                break;
        }
        return  toolString;
    }

    public String toString(){
        return this.toolStrength + " " + this.toolType;
    }
}