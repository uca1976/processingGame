package GameEngine;



import GameEngine.Entities.Player;
import processing.core.PApplet;
import shiffman.box2d.Box2DProcessing;

public class GameEngine {
public KeyboardManager keyboardmanager;
public GameEngine(PApplet p,int h,int w){
	Public.HEIGHT= h;
	Public.WIDTH = w;
	Public.km = new KeyboardManager();
	keyboardmanager = Public.km;
	Public.p = p;

	
	Public.box2d = new Box2DProcessing(p);
	Public.box2d.createWorld();

}

public void setMainPlayer(Player p){
	Public.pl =p;
}




public void step(boolean usePhysics){
	//Update physics
	if(usePhysics)
	{
	Public.box2d.step();
	}
	
	//Update daytime
	Public.DayTime++;
	if(Public.DayTime >Public.MaxDayTime-1)Public.DayTime =0;
	
	Public.HEIGHT = Public.p.height;
	Public.WIDTH = Public.p.width;
	
	Public.km.updateKeysPressed();
    
	Public.mX = Public.p.mouseX-Public.WIDTH/2;
    Public.mY = Public.p.mouseY-Public.HEIGHT/2;
	
}

}
