package GameEngine.Objects;

import org.jbox2d.common.Vec2;

import GameEngine.Public;
import GameEngine.Objects.Object;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Sky extends Object{
    private PImage sun;
    private PImage moon;
    private float r,g,b;
    private float x,y;
 
	public Sky(String SunTexturePath,String MoonTexturePath){
		super("", new Vec2(0, 0));
		sun = Public.p.loadImage(SunTexturePath);
		moon = Public.p.loadImage(MoonTexturePath);
	
	}
 
	

	
	@Override
	public void draw(){
		Public.p.rectMode(PConstants.CENTER);
		Public.p.rect(loc.x,loc.y,Public.HEIGHT+1,Public.WIDTH+1);
		if(Public.DayTime <Public.MaxDayTime/2){
			
			if(Public.DayTime <= Public.MaxDayTime/4f){
				//Sun last part
				x = PApplet.map(Public.DayTime,0,Public.MaxDayTime/4,0,Public.WIDTH/2+sun.pixelWidth/2+1);
				Public.p.imageMode(PConstants.CENTER);
			
				
				y = (float)-(Math.sqrt(Math.pow(Public.HEIGHT/2+sun.pixelWidth+35,2)-Math.pow(x, 2)));
				
				if(y>-(Public.HEIGHT/2+1))
				  Public.p.image(sun,x,y) ;
				else
				  Public.p.image(sun, x, -Public.HEIGHT/2);
				
				
			}else{
			    //Moon first part
			    x = PApplet.map(Public.DayTime,Public.MaxDayTime/4,Public.MaxDayTime/2-1,-Public.WIDTH/2,0);
				Public.p.imageMode(PConstants.CENTER);
		        
			
				y = (float)-(Math.sqrt(Math.pow(Public.HEIGHT/2+moon.pixelWidth+35,2)-Math.pow(x, 2)));
				if(y>-(Public.HEIGHT/2+1))
				  Public.p.image(moon,x,y) ;
				else
				  Public.p.image(moon, x, -Public.HEIGHT/2);
				
			}
			
			 r =PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 158, 31);
		     g =PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 231, 13);
			 b =PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 255, 145);
			
		Public.p.fill(r,g,b);
		
		}else{
			
			
			if(Public.DayTime-Public.MaxDayTime/2 <= Public.MaxDayTime/4f){
				//Moon last part
			    x = PApplet.map(Public.DayTime-Public.MaxDayTime/2,0,Public.MaxDayTime/4,0,Public.WIDTH/2+moon.pixelWidth/2+1);
				Public.p.imageMode(PConstants.CENTER);
				
			
				y = (float)-(Math.sqrt(Math.pow(Public.HEIGHT/2+moon.pixelWidth+35,2)-Math.pow(x, 2)));
				
				if(y>-(Public.HEIGHT/2+1))
				  Public.p.image(moon,x,y) ;
				else
				  Public.p.image(moon, x, -Public.HEIGHT/2);
			}else{
				//Sun first part
			    x = PApplet.map(Public.DayTime-Public.MaxDayTime/2,Public.MaxDayTime/4,Public.MaxDayTime/2-1,-Public.WIDTH/2,0);
			    Public.p.imageMode(PConstants.CENTER);
			    
			  
				y = (float)-(Math.sqrt(Math.pow(Public.HEIGHT/2+sun.pixelWidth+35,2)-Math.pow(x, 2)));
				
				if(y>-(Public.HEIGHT/2+1))
				  Public.p.image(sun,x,y) ;
				else
				  Public.p.image(sun, x, -Public.HEIGHT/2);
		
			}
			
			 r =PApplet.map(Public.DayTime-Public.MaxDayTime/2, 0, Public.MaxDayTime/2, 31, 158);
			 g =PApplet.map(Public.DayTime-Public.MaxDayTime/2, 0, Public.MaxDayTime/2, 13, 231);
			 b =PApplet.map(Public.DayTime-Public.MaxDayTime/2, 0, Public.MaxDayTime/2, 145, 255);
			
		Public.p.fill(r,g,b);
			
	
			}

	  }
		
	
}
