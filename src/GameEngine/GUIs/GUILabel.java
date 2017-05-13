package GameEngine.GUIs;

import GameEngine.Public;
import processing.core.PVector;

public class GUILabel extends GUIElement{

	
	private String label = "";
	private int size =1;
	public GUILabel(PVector loc,String label,int size) {
		super(loc);
		this.label = label;
		this.size = size;
		loc.x-=4;
	}

	public void setLabel(String label){
		this.label = label;
	}
	
	@Override
	public void render(){
		Public.p.fill(0);
		Public.p.textSize(size);
		Public.p.text(label, loc.x-Public.p.textWidth(label)/2, loc.y);
	}
	
	
}
