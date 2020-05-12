package cisc181.lab_6;

import java.util.ArrayList;

public class ToolBox {

    private ArrayList<Tool> toolSet;
    public static final int MAX_NUM_TOOLS = 12;

    public ToolBox(boolean gameBox){
        toolSet = new ArrayList<>();
        if(gameBox){
            setUpToolBox();
        }
    }

    private void setUpToolBox(){
        int index = 0;
        // create one of each type of tool
        toolSet.add( new Tool(Tool.ITEM.CLOAK,Tool.STRENGTH.SILVER));
        toolSet.add( new Tool(Tool.ITEM.GLASSES,Tool.STRENGTH.GOLD));
        toolSet.add( new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER));
        toolSet.add( new Tool(Tool.ITEM.COIN,Tool.STRENGTH.GOLD));
        toolSet.add(  new Tool(Tool.ITEM.COIN,Tool.STRENGTH.GOLD));
        toolSet.add(  new Tool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
        toolSet.add(  new Tool(Tool.ITEM.COIN,Tool.STRENGTH.SILVER));
        toolSet.add(  new Tool(Tool.ITEM.HEN_EGG, Tool.STRENGTH.GOLD));
        toolSet.add(  new Tool(Tool.ITEM.HEN_EGG, Tool.STRENGTH.SILVER));
    }

    public boolean hasTool(Tool.ITEM item, Tool.STRENGTH strength) {
        for (Tool t: toolSet){
            if(t.getToolType().equals(item) && t.getToolStrength().equals(strength)){
                return true;
            }
        }
        return false;
    }

    public Tool removeTool(Tool.ITEM item, Tool.STRENGTH strength){
        for (int i = 0; i < toolSet.size(); i++){
            if(toolSet.get(i).getToolType().equals(item) &&
                    toolSet.get(i).getToolStrength().equals(strength)){
                return toolSet.remove(i);
            }
        }
        return null;
    }

    public void addTool(Tool newTool){
        toolSet.add(newTool);
    }

    public Tool getTool(int index){
        return (index >= 0 && index < MAX_NUM_TOOLS) ? this.toolSet.get(index) : null;
    }

    public String toString(){
        StringBuilder toolBoxString = new StringBuilder();
        int count = 0;
        for(Tool aTool : toolSet){
            if (aTool != null) {
                toolBoxString.append(aTool.toString())
                        .append(" : " + aTool.getDescription() + "\n");
            }
        }
        return toolBoxString.toString();
    }
}
