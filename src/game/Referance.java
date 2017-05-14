package game;
import java.io.File;
import java.net.URISyntaxException;





//"Control Panel/Panoul de control"
public class Referance {	

private static String jarLocation = jarLoc();

public static String gameName = "Game";


	//Frame(Window)
public static int HEIGHT = 420;
public static int WIDTH = 420;
public static int MAX_FRAMERATE = 60;
public static String WINDOW_TITLE =gameName;

    //Sky
public static String SunTexturePath = jarLocation+"\\res\\Objects\\Sky\\sun.jpg";
public static String MoonTexturePath = jarLocation+"\\res\\Objects\\Sky\\moon.png";

    //Ground
public static String GroundTexturePath = jarLocation+"\\res\\Objects\\Grass\\grass.jpg";
  
   //Player
public static String PlayerTexturePath =jarLocation+"\\res\\Entities\\Player\\Texture.png";
public static float PlayerStartY = 0;
public static float PlayerStartX = 0;
public static double playerSpeed = 6.7;



  //Credits
public static String[] credits = {"Developer:Udrea Dan Mihai\n","Libraries/Extensions:Processing 3.0(graphics),jbox2d(physics engine)"};



private static String jarLoc(){
	File jarLoc = null;
	try {
		jarLoc=new File(Referance.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
	return jarLoc.getParent();
}



}

