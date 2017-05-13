package game.GUIs;

import GameEngine.GUIs.GUI;
import GameEngine.GUIs.GUILabel;
import game.Referance;
import processing.core.PVector;

public class EndGUI extends GUI{
    public boolean isActivated = false;
	private GUILabel endLabel;
    private int n =0;
	public EndGUI(){
		String label="";
		for(String credit : Referance.credits ){
			//if(credit.contains(":"))credit="\n"+credit;
			label+=credit.replaceAll(",", "\n").replaceAll(":", ":\n")+'\n';
		}
        for(char c:label.toCharArray())
        	if(c == '\n')n++;
        n++;
        endLabel = new GUILabel(new PVector((n/7)*10,-(n*10+1)),label,18);
		elements.add(endLabel);
	}





}
