package GameEngine.Objects;

import org.jbox2d.common.Vec2;

import GameEngine.Renderer.Renderer;
import processing.core.PImage;

public class Object {
Vec2 loc;
public static PImage texture;
public static boolean noTexture=false;
public Object(String texturePath,Vec2 loc){
	
this.loc =loc;

//Texture
   if(texturePath != "")
		texture = Renderer.loadImage(texturePath);
	

}

public void draw(){
	
}

}
