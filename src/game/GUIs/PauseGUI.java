package game.GUIs;

import GameEngine.Public;
import GameEngine.GUIs.GUI;
import GameEngine.GUIs.GUILabel;
import processing.core.PConstants;
import processing.core.PVector;

public class PauseGUI extends GUI {
    public boolean isActivated = false;
	GUILabel label;
	
	public PauseGUI(){
		label = new GUILabel(new PVector(5,0),"PAUSED",60);
		elements.add(label);
	}
     @Override
     public void render(){
    	 Public.p.rectMode(PConstants.CENTER);
    	 Public.p.noStroke();
    	 Public.p.fill(220,60);
    	 Public.p.rect(0,0,Public.WIDTH,Public.HEIGHT);
     }
}
