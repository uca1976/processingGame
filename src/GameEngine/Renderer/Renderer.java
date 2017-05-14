package GameEngine.Renderer;




import java.io.File;
import java.util.Iterator;

import org.jbox2d.common.Vec2;

import GameEngine.Public;
import GameEngine.Entities.Entity;
import GameEngine.GUIs.GUI;
import GameEngine.GUIs.GUIElement;
import GameEngine.Objects.Object;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class Renderer {

//Special way of drawing images so that a certain color is seetrhrough(white)
public static PImage loadImage(String imgPath){
	PImage img = null;
	PImage newImg = null;
	boolean noTexture = false;
	int size = 20;
	//Idiocracy checking
	if(imgPath != ""){
		File f = new File(imgPath);
		if(!f.isDirectory()){
        if(f.exists()){
        	try{
		img = Public.p.loadImage(imgPath);
        	}catch(Exception e){
        		noTexture = true;
        	}
        }else{
        noTexture = true;
        }
		
        }else{
        noTexture = true;
        }
		
	}else{
	noTexture = true;
	  }
	
	
   
    if(!noTexture){
    	 newImg = Public.p.createImage(img.width, img.height, PConstants.ARGB);
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
    }else{
    	 newImg = Public.p.createImage(size*2, size*2, PConstants.ARGB);
    PGraphics pg = Public.p.createGraphics(newImg.width, newImg.height);
    pg.beginDraw();
    


    pg.translate(pg.width/2, pg.height/2);
    pg.rectMode(PConstants.CENTER);
    pg.fill(229,22,215);
    pg.rect(-size/2, -size/2,size,size);
    
    pg.fill(0,0,0);
    pg.rect(size/2, -size/2,size,size);
    
    
    pg.fill(229,22,215);
    pg.rect(size/2, size/2,size,size);
    
    pg.fill(0,0,0);
    pg.rect(-size/2, size/2,size,size);
    
    
	pg.fill(255,255,255);
	pg.textSize(30);
	pg.text("TEXTURE", -size+69, -size+40);
	pg.text("NOT", -size+69, -size+70);
	pg.text("FOUND", -size+69, -size+100);
	
	pg.endDraw();
	newImg = pg.get();
    }
	
	  return newImg;
}
	
@SuppressWarnings("static-access")
public void render(Entity e){

	Public.p.noStroke();

	Vec2 loc = Public.box2d.getBodyPixelCoord(e.body);
	Public.p.imageMode(PConstants.CENTER);
   Public.p.image(e.texture,loc.x-Public.p.width/2,loc.y-Public.p.height/2);

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
