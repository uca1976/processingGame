package GameEngine;

import GameEngine.Entities.Player;
import processing.core.PApplet;
import shiffman.box2d.Box2DProcessing;

public class Public {
	
    public static PApplet p;
	
	public static int HEIGHT;
	public static int WIDTH;
	
	//Physics
	public static Box2DProcessing box2d;
	
	//Stuff
	public static float mX = 0;
	public static float mY = 0;
	
    //KeyboardManager
	public static KeyboardManager km;
	
	//The time(used by the sky and otehr stuff)
	public static int MaxDayTime = (24*60*60*60)/50;
	public static int DayTime =MaxDayTime/2+MaxDayTime/4;
	
	//Main player
	public static Player pl = null;
}
