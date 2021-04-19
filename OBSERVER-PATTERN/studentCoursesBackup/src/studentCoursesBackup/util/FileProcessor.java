package studentCoursesBackup.util;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;

public class FileProcessor
{
  private FileReader file_r = null;  
 private BufferedReader buffer_r =null;
  private String input_File=null;
  private File input_file=null;


public String readLine() 
{
	try
           {
             return getBufferedReader().readLine();
	   } 
          catch (IOException e) 
          {
            System.err.println("cannot read from input file, Please check. ");
	    e.printStackTrace();
	    System.exit(1);
	   
	  } 
           finally
           {
		    
	   }
           return null;
}

public FileProcessor(String str)
{
	this.input_File = str;
	try
         {
	   input_file = new File(input_File);
	    file_r = new FileReader(input_file);
	    buffer_r = new BufferedReader(file_r);

	    
	}catch(IOException e)
        {
  	    System.err.println(input_File +" not found!!");
	    e.printStackTrace();
	    System.exit(1);
	}
         finally
        { 
	}
    }
private BufferedReader getBufferedReader()
{
	return buffer_r;
}
}
