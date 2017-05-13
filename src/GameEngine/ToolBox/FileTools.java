package GameEngine.ToolBox;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileTools {
	public String location(){
	File jarLoc = null;
	try {
		jarLoc=new File(FileTools.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
	return jarLoc.getParent();
	}

	public boolean fileExists(String filePath){
		File f =new File(filePath);
		if(f.exists()&& !f.isDirectory()){
		return true;
		}
		return false;
	}
	
	public Object[] readFile(String filePath){
		File f =new File(filePath);
		Object[] file = null;
	  if(f.exists()){
		if(f.isFile()){
			if(f.canRead()){	
			 
			try {
				file = Files.readAllLines(Paths.get(filePath)).toArray();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		  
			}else{
				System.err.println("The file specifed can not be readed.");
				System.exit(1);
			}
			
		}else{
			System.err.println("The path specified dosen't contain a file.");
			System.exit(1);
		}
		
	  }else{
		  System.err.println("The path specified dosen't exist!");
		  System.exit(1);
	  }
	  
		return file;
	}
	
	
	public <T> void writeToFile(String filePath,T text){
		File f = new File(filePath);
		
		if(f.exists()){
		
		if(f.isFile()){	
			
		if(f.canRead()){
			
		if(f.canWrite()){	
			Object[] file = null;
			try {
				file = Files.readAllLines(Paths.get(filePath)).toArray();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
			
		try{
		    PrintWriter writer = new PrintWriter(filePath, "UTF-8");
		    
		    for(Object line : file){
		    	writer.println((String) line);
		    }
		    writer.println(text);
		    writer.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
			
			
		
		}else{
			System.err.println("The file can not be writed to.");
			System.exit(1);
		}
		
		}
		
		}else{
			System.err.println("The path specified dosen't contain a file.");
			System.exit(1);
		}
		
	}else{
		  System.err.println("The path specified dosen't exist!");
		  System.exit(1);
	  }
		
	}
	
	public void createFile(String filePath){
	
		try{
		    PrintWriter writer = new PrintWriter(filePath, "UTF-8");
		    writer.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
	
		
	}
	
	
	public <T> void overwriteFile(String filePath,T text){
		
		File f =new File(filePath);
	
	  if(f.exists()){
		if(f.isFile()){
			if(f.canWrite()){	
			 
				try{
				    PrintWriter writer = new PrintWriter(filePath, "UTF-8");
				    writer.println(text);
				    writer.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
		  
			}else{
				System.err.println("The file specifed can not be writed to.");
				System.exit(1);
			}
			
		}else{
			System.err.println("The path specified dosen't contain a file.");
			System.exit(1);
		}
		
	  }else{
		  System.err.println("The path specified dosen't exist!");
		  System.exit(1);
	  }
	  
		
		
	}
	
	
	
	
	
}
