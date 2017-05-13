package GameEngine.Entities;



import org.jbox2d.common.Vec2;

import GameEngine.Public;






public class Player extends Entity{


	private short jumping = 0;
	private static float density = 0.8f;
	private static float friction = 0.35f;
	private static float restitution = 0.24f;
public Player(Vec2 startLoc,double speed,String TexturePath){
    super(startLoc,speed, TexturePath,density,friction,restitution);
    name ="Player";

    
}



public void move(int w){
	//Update jumping variable
	jumping = Public.km.keyCodes.contains((int)' ') || Public.km.keyCodes.contains((int)'w') || Public.km.keyCodes.contains((int)'W') ? (short)1:(short)0;
	w*=(100*speed)-(jumping*((speed-0.7f)*100));
    body.applyForceToCenter(new Vec2(w,0));


}
public void keysReleased(){
	if(jumping != 1)
	body.setLinearVelocity(new Vec2(body.getLinearVelocity().x/1.3f,body.getLinearVelocity().y/1.3f));
}

public void jump(){
    
	if(-Public.box2d.getBodyPixelCoord(body).y+Public.p.height/2 < -123f)
	      body.applyForceToCenter(new Vec2(0,4000));	
	

}

}
