package game;

import GameEngine.Entities.Player;
import GameEngine.GameEngine;
import GameEngine.KeyboardManager;
import GameEngine.Renderer.Renderer;
import GameEngine.Objects.Ground;
import GameEngine.Objects.Sky;
import game.GUIs.EndGUI;
import game.GUIs.MainGUI;
import game.GUIs.PauseGUI;
import org.jbox2d.common.Vec2;
import processing.core.PApplet;

public class Main extends PApplet{

private Sky sky;
private Ground g;
private Player p;
private MainGUI m;
private GameEngine e;
private Renderer r;
private EndGUI eg;
private PauseGUI pg;
private KeyboardManager km;
private boolean end = false;

public static void main(String[] args) {
	PApplet.main("game.Main");
	}

	//Functions

	//Init method(loads stuff in memory and does other stuff)
	public void init(){
		
        //GameEngine
		e = new GameEngine(this,Referance.HEIGHT,Referance.WIDTH);
        
		//KeyboardManager
		km = e.keyboardmanager;
		
		//Renderer
		r = new Renderer();

		//Sky
		sky = new Sky(Referance.SunTexturePath,Referance.MoonTexturePath);
		
		//Ground
		g= new Ground(Referance.GroundTexturePath);		

		//Player
		p = new Player(new Vec2(Referance.PlayerStartX,Referance.PlayerStartY),Referance.playerSpeed,Referance.PlayerTexturePath);
        
		//Give the player and the sky to the engine so that it can change variables so that we don't have to
		e.setMainPlayer(p);

		

	    //"Testing area"

     	//Main GUI
        m = new MainGUI();

        //End GUI
        eg = new EndGUI();

        //Pause GUI
        pg = new PauseGUI();

	}



	//setting stuff
	public void settings(){
            //Set size
			size(Referance.WIDTH,Referance.HEIGHT);
			


	}


	    //start && init
	    public void setup() {

          //Other settings
	        frameRate(Referance.MAX_FRAMERATE);
            surface.setResizable(false);
            surface.setTitle(Referance.WINDOW_TITLE);

          //Init
            init();
	    }


	    //Main loop
	    public void draw() {
              
	        //Clear last frame
	    	background(255);
	    	
	    	translate(Referance.HEIGHT/2,Referance.WIDTH/2);
	        
	    	
            //Main menu
	    	if(!m.isActivated){
	    		
	    	//END MENU
	   	    if(!eg.isActivated){
	   	    	 
            //Pause menu
	   	    if(!pg.isActivated){
	   	    	
            ///this is the actual game code
	   	    	
	            //Update physics, window size, etc...
	       	    e.tick();
	   	    	
	    	// move/do stuff

	    for(int keyCurrentlyPressed : km.keyCodes)
	   		  
              //A
	          if(keyCurrentlyPressed == 'a' || keyCurrentlyPressed == 'A')  p.move(-1);
	    	  //D
	          else if(keyCurrentlyPressed == 'd' || keyCurrentlyPressed == 'D')  p.move(1);
	          //W or ' '
	          else if(keyCurrentlyPressed == ' ' || keyCurrentlyPressed == 'W' || keyCurrentlyPressed == 'w') p.jump();
	          //Exit menu
	          else if(keyCurrentlyPressed == 'x' || keyCurrentlyPressed == 'X') eg.isActivated = true;
	          //Pause menu
	          else if(keyCurrentlyPressed == 'e' ||keyCurrentlyPressed == 'E'){
		         pg.isActivated=true;
		           delay(160);
	         }

	    //Game
		renderGame();
		
	    }else{
	    
	    //Game
	    renderGame();

	    //Pause GUI
	    r.render(pg);

	    for(int keyCurrentlyPressed:km.keyCodes)
	    	//Escape
	    	if(keyCurrentlyPressed == 'e'||keyCurrentlyPressed=='E'){
				pg.isActivated=false;
				 delay(160);
	    	}

	    
	    }
	     }else{
	    	 
	     //End
	     r.render(eg);
	     if(end){
		delay(7300);
        
	     stop();
	     exit();
	     }else{
	    	 end = true;
	     }
	     

         

	     }

	   	    
	   	    
	     }else{
	    	 
    	 //Start
	     r.render(m);

	     }
	    	
	  }



	    private void renderGame(){
	    	 //Game rendering 
	    	  r.render(sky);
			  r.render(p);
			  r.render(g);
	    }

	    
	    //Keys

		public void keyPressed(){
		km.keyPressed();
		}
		

		public void keyReleased(){
		km.keyReleased();
		}


}
