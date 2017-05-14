package GameEngine.Entities;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import GameEngine.Public;
import GameEngine.Renderer.Renderer;
import processing.core.PApplet;
import processing.core.PImage;



public class Entity {
protected static double speed;
public static Vec2 startLoc = new Vec2(0,0);
public static PImage texture;
protected static PApplet p;
public static Body body;
protected static String name = "";
public static boolean noTexture = false;

@SuppressWarnings("static-access")

public Entity(Vec2 startLoc,double speed ,String TexturePath,float density,float friction,float restitution){

	

	    this.texture = Renderer.loadImage(TexturePath);



    	//Body def
    	BodyDef bd = new BodyDef();
    	bd.type = BodyType.DYNAMIC;
    	bd.position.set(Public.box2d.coordPixelsToWorld(PApplet.map(startLoc.x, 0, Public.WIDTH, 0, Public.p.width)+Public.p.width/2,PApplet.map(startLoc.y, 0, Public.HEIGHT, 0, Public.p.height)+Public.p.height/2));
    	//Create body
        body = Public.box2d.createBody(bd);
    	//Creat Shape
        PolygonShape ps = new PolygonShape();
        ps.setAsBox(Public.box2d.scalarPixelsToWorld(texture.width),Public.box2d.scalarPixelsToWorld(texture.height));
        //Fixture
        FixtureDef fd = new FixtureDef();
        fd.shape = ps;
        fd.setDensity(density);
        fd.setFriction(friction);
        fd.setRestitution(restitution);
        body.createFixture(fd);
 
 
	
	
	
	
	//Speed
	if(speed != 0){
	this.speed = speed;
	}else{
System.out.println("Speed of entity is too low using default speed of 1!");
	this.speed = 1;
	}
	
	


	
	
	
}




}
