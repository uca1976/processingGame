package GameEngine.GUIs;


import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import GameEngine.Public;
import processing.core.PVector;

public class GUIButton extends GUIElement{
    private int w,h;
    private String text;
    private Color buttonColor;
    private Color textColor;
    private Method buttonPressed;
    private Method buttonReleased;
    private Object c;
    private int id;
    private int textSize;
    private boolean isSeethrough;
    private boolean hasBorder = true;
  
	public GUIButton(int id,Object c,Method buttonPressed,Method buttonReleased ,PVector loc,int heightOffset,int widthOffset,String text,int textSize,boolean hasBorder,boolean isSeethrough,Color buttonColor,Color textColor) {
		super(loc);
		this.buttonPressed = buttonPressed;
		this.buttonReleased = buttonReleased;
		this.c =c;
		
		this.textSize = textSize;
		this.id=id;
	    this.text =text;
	    this.hasBorder = hasBorder;
	    this.buttonColor = buttonColor;
	    this.textColor = textColor;
	    this.isSeethrough = isSeethrough;
	    
	    this.w=widthOffset;
	    this.h=heightOffset;
        loc.x-=1;
	}



    
	@Override
	public void render(){
    	
    	  if(hasBorder){
	        Public.p.stroke(0);
	        }else{
	        Public.p.noStroke();
	        }
        
        if(isSeethrough){
        	Public.p.noFill();
        }else{
    	    Public.p.fill(buttonColor.getRGB());
        }
    	Public.p.rect(loc.x-w/2, loc.y-h/2, w, h);
	    Public.p.fill(textColor.getRGB());
	    Public.p.textSize(textSize);
		Public.p.text(text, loc.x-w/2+(w/12.8700f), loc.y-h/2+(h/9.7560f) ,w,h);
		
	
		Public.p.fill(255);
		if(buttonPressed != null){
		if(Public.p.mousePressed){
		if(overRect(loc.x-w/2,loc.y-h/2,w,h)){
			//Try to use the method that has been given to you
    		try {
				buttonPressed.invoke(c,id);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
    		
    	  }
		 }else{
		if(overRect(loc.x-w/2,loc.y-h/2,w,h)){
			//Try to use the method that has been given to you
		    try {
				buttonReleased.invoke(c,id);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		    
		    
		   }
		 }
		}
		
	}
    
  
	
    private boolean overRect(float x, float y, int width, int height)  {
    	  if (Public.mX >= x && Public.mX <= x+width && 
    			  Public.mY >= y && Public.mY <= y+height) {
    	    return true;
    	  } else {
    	    return false;
    	  }
    	}

}


