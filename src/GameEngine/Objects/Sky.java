package GameEngine.Objects;

import org.jbox2d.common.Vec2;

import GameEngine.Public;
import GameEngine.Objects.Object;
import processing.core.PApplet;
import processing.core.PConstants;

public class Sky extends Object{

	public Sky(){
		super("", new Vec2(0, 0));
	}


	
	@Override
	public void draw(){
		Public.p.rectMode(PConstants.CENTER);
		if(Public.DayTime <Public.MaxDayTime/2+1){
		Public.p.fill(PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 158, 31),PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 231, 13),PApplet.map(Public.DayTime, 0, Public.MaxDayTime/2, 255, 145));
		}else{
		Public.p.fill(PApplet.map(Public.DayTime, Public.MaxDayTime/2, Public.MaxDayTime, 31, 158),PApplet.map(Public.DayTime, Public.MaxDayTime/2, Public.MaxDayTime, 13, 231),PApplet.map(Public.DayTime, Public.MaxDayTime/2, Public.MaxDayTime, 145, 255));
		}
		Public.p.rect(loc.x,loc.y,Public.HEIGHT+1,Public.WIDTH+1);
		
	}
}
