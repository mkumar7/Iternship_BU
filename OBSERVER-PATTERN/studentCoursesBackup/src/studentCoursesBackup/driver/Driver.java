package studentCoursesBackup.driver;

import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;

public class Driver 
{

    public static void main(String[] args) 
    {

	    TreeBuilder myTreeBuilder = new TreeBuilder(args[0],args[1]);
	    Results output1 = new Results(args[2]);
	    Results output2 = new Results(args[3]);
	    Results output3 = new Results(args[4]);

	    //______________MAIN TREE___________________________
	    output1.writeToStdout("initiating studentCoursesBackup");
	    output1.writeToStdout(myTreeBuilder.getErrorMsg());
	    output1.storeNewResult(myTreeBuilder.getTree(0).printNodes());
	    output1.writeToFile();
	    output1.writeToStdout("master tree complete");
	    //_________________NODE1______________________________
	    output2.storeNewResult(myTreeBuilder.getTree(1).printNodes());
	    output2.writeToFile();
	    output2.writeToStdout("backup tree 1 complete");
	    //__________________NODE2_______________________________
	    output3.storeNewResult(myTreeBuilder.getTree(2).printNodes());
	    output3.writeToFile();
	    output3.writeToStdout("backup tree 2 complete");
	}
}
	    
	

