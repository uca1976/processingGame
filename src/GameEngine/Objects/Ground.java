package GameEngine.Objects;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import GameEngine.Public;
import processing.core.PConstants;


public class Ground extends Object{
    public Body body;
	public Ground(String texturePath) {
		super(texturePath, new Vec2(0, Public.p.height) );
		
		//Body def
    	BodyDef bd = new BodyDef();
    	bd.type = BodyType.STATIC;
    	bd.position.set(Public.box2d.coordPixelsToWorld(loc));
    	//Create body
        body = Public.box2d.createBody(bd);
    	//Creat Shape
        PolygonShape ps = new PolygonShape();
        ps.setAsBox(Public.box2d.scalarPixelsToWorld(Public.p.width*100),Public.box2d.scalarPixelsToWorld(-texture.height));
        //Fixture
        FixtureDef fd = new FixtureDef();
        fd.shape = ps;
        fd.density = 1f;
        fd.friction = 0.3f;
        fd.restitution = 0.15f;
        body.createFixture(fd);
        
	}
	
  @Override
   public void draw(){
	   Public.p.imageMode(PConstants.CENTER);
	   for(int i=0;i<40;i++){
	   Public.p.image(texture, texture.width*i-10000, (Public.p.height/2-texture.height/4.5f));
	   }
   }
   
}
