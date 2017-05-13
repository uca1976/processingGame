package game.GUIs;

import processing.core.PVector;

import java.awt.Color;
import java.lang.reflect.Method;

import GameEngine.GUIs.GUI;
import GameEngine.GUIs.GUIButton;
import GameEngine.GUIs.GUILabel;
import game.Referance;

public class MainGUI extends GUI{
    private GUIButton startButton;
    private GUILabel  gameLabel;
    private boolean buttonState = false;
    public boolean isActivated = true;
  
   
    
    
	public MainGUI(){
   //Referance.WIDTH/7,Referance.HEIGHT/14
   //Prepare to pass methods
     Method buttonPressed=null;
     Method buttonReleased=null;
	try {
		buttonPressed = this.getClass().getMethod("buttonPressed", int.class);
		buttonReleased = this.getClass().getMethod("buttonReleased", int.class);
	} catch (NoSuchMethodException | SecurityException e) {
	
		e.printStackTrace();
	}
	//Create button and pass methods
     startButton = new GUIButton(1,this,buttonPressed,buttonReleased, new PVector(0,0), 40, 101, "START",27, true, false, new Color(255,255,255), new Color(0,255,0));	
     gameLabel = new GUILabel(new PVector(0,-100),Referance.gameName.toUpperCase(),70);
     elements.add(startButton);
     elements.add(gameLabel);
	}
	
	




public void buttonPressed(int id){
	if(id == 1){
		buttonState = true;
	}
}

public void buttonReleased(int id){
	if(id == 1){
		if(buttonState){
			 isActivated =false;
		}
		buttonState = false;
	}
}

}
