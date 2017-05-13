package GameEngine;

import java.util.ArrayList;
import java.util.List;



public class KeyboardManager{
	
    public List<Integer> keyCodes = new ArrayList<Integer>();
    

	
	public void updateKeysPressed(){
		//If window is unfocused then set keyIsPressed to false
		if(!Public.p.focused)
			keyCodes.clear();
	

	}
	
	
	public void keyPressed(){
		if(!keyCodes.contains(Public.p.keyCode))
			keyCodes.add(Public.p.keyCode);
	}
	

	public void keyReleased(){
		
		if(Public.pl != null){
        Public.pl.keysReleased();
		}
		
		
        keyCodes.remove((Object)Public.p.keyCode);
	}

	
}
