package studentCoursesBackup.util;
import java.io.FileWriter;
import java.io.BufferedWriter;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.FileDisplayInterface;
import java.io.IOException;
import studentCoursesBackup.myTree.Node;
public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{   private String text;
    private String output_File = null;
    private FileWriter file_w = null;
    private BufferedWriter buffered_w = null;

     public String getResults(){
	return this.text;
    }


     public void storeNewResult(String result)
    {
	this.text += result;
    }

    public Results(String str){
     
	text = "";
       this.output_File = str;
    }
    
    
    public void writeToStdout(String str) {
	System.out.println(str);
    }

    
    public void writeToFile(){
	    try {
	    file_w = new FileWriter(output_File);
	    buffered_w = new BufferedWriter(file_w);
	    buffered_w.write(this.getResults());

            }catch (IOException e) {
			System.err.println("The given output file not found, please check!");
			e.printStackTrace();
			System.exit(1);
            }
            finally{

	    try{
		buffered_w.close();
		file_w.close();
        }
           catch (IOException e) {
			System.err.println("The given output file not found, please check!");
			e.printStackTrace();
			System.exit(1);
      }
      }
	   
    }

    
   
    
   
}
