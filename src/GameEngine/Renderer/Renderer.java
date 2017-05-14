package GameEngine.Renderer;




import java.util.Iterator;

import org.jbox2d.common.Vec2;

import GameEngine.Public;
import GameEngine.Entities.Entity;
import GameEngine.GUIs.GUI;
import GameEngine.GUIs.GUIElement;
import GameEngine.Objects.Object;
import processing.core.PConstants;
import processing.core.PImage;

public class Renderer {

//Special way of drawing images so that a certain color is seetrhrough(white)
public static PImage loadImage(String imgPath){
	PImage img = Public.p.loadImage(imgPath);
    PImage newImg = Public.p.createImage(img.width, img.height, PConstants.ARGB);
    
	for(int x = 0; x < img.width; x++ ){
		  for(int y = 0; y < img.height; y++ ){
		   int i = ( ( y * img.width ) + x );
		    if(img.pixels[i] == Public.p.color(255, 255, 255)){
		      newImg.pixels[i] = Public.p.color(0, 0, 0, 0);
		    }else {
		      newImg.pixels[i] = img.pixels[i];
		    }
		  }
		
      }
	
	  return newImg;
}
	
@SuppressWarnings("static-access")
public void render(Entity e){

	Public.p.noStroke();


if(!e.noTexture){

	Vec2 loc = Public.box2d.getBodyPixelCoord(e.body);
	Public.p.imageMode(PConstants.CENTER);
   Public.p.image(e.texture,loc.x-Public.p.width/2,loc.y-Public.p.height/2);

}else{
	
	Vec2 loc = e.startLoc;
	int size =70;
   //scale
   // Public.p.scale(2,1);
	
	Public.p.fill(229,22,215);
    Public.p.rect(loc.x, loc.y-size,size,size);
    
	Public.p.fill(0,0,0);
    Public.p.rect(loc.x-size, loc.y-size,size,size);
    
    
	Public.p.fill(229,22,215);
    Public.p.rect(loc.x-size, loc.y,size,size);
    
	Public.p.fill(0,0,0);
    Public.p.rect(loc.x, loc.y,size,size);
    
    
    
	Public.p.fill(255,255,255);
	Public.p.textSize(30);
	Public.p.text("TEXTURE", loc.x-size+69, loc.y-size+40);
	Public.p.text("NOT", loc.x-size+69, loc.y-size+70);
	Public.p.text("FOUND", loc.x-size+69, loc.y-size+100);
}




 }

public void render(Object o){
	o.draw();
}

public void render(GUIElement e){
	e.render();
}

public void render(GUI g){
	g.render();
	
	Iterator<GUIElement> i = g.elements.iterator();
	while(i.hasNext()){
		GUIElement e =(GUIElement)i.next();
		e.render();
	}
	
}


}
