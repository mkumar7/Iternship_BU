package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.binarySearchTree.BinarySearchTree;
import studentCoursesBackup.binarySearchTree.TreeInterface;
public class TreeBuilder 
{
    private TreeInterface Node;
    private TreeInterface Node1;
    private TreeInterface Node2;
    private FileProcessor inputFile;
    private FileProcessor deleteFile;
    private boolean errorFlag;
    private String line; 
    private String errorMsg;
    
   

    private void Expand(int nodeIndex)
    {
        Node MainNode = Node.find(nodeIndex);
	String List = findCourse(line);
	 if(isCourseValid(List)){
	    if(MainNode==null)
	    {
		
		Node  master = new Node(nodeIndex);
		master.insert(List);
		
		Node branch1=null;
		Node branch2=null;

		if(master instanceof Cloneable){
		    branch1 = master.clone();
		    branch2 = master.clone();
		    master.registerObserver(branch1);
		    master.registerObserver(branch2);
		}
		Node.insertNode(master);
		Node1.insertNode(branch1);
		Node2.insertNode(branch2);
	    }
	     
	    else
	    {
		MainNode.insert(List);
	
		Node backup = Node1.find(nodeIndex);
		backup.insert(List);
		
		backup = Node2.find(nodeIndex);
		backup.insert(List);
	    }  
	     
	    
	}
	}	   

	 private int getbNo(String sIn){
	
	return convertToInt(sIn.substring(0,3));
    }


    public TreeBuilder(String inputFileName, String deleteFileName){
	//---------initialization of trees----------
	Node = new BinarySearchTree();
	Node1 = new BinarySearchTree();
	Node2 = new BinarySearchTree();
	//------------------------------------------
	
	inputFile = new FileProcessor(inputFileName);
	deleteFile = new FileProcessor(deleteFileName);

	    //----------insert operation----------------
	    line = inputFile.readLine();
	    while(line!=null){
		if(!isFormatValid(line)){
			System.err.println("Invalid format for input text file!");
				System.exit(1);
		   
		}
		int Index = getbNo(line);
		Expand(Index);
		line = inputFile.readLine();
	    }
	    
	    //----------delete operation----------------
	    line = deleteFile.readLine();
	    while(line!=null)
	    {
		if(!isFormatValid(line))
		{
			System.err.println("Invalid format for delete text file!");
						System.exit(1);
		  
		}
		
		     line = deleteFile.readLine();
	     }
	    }

     private String findCourse(String sIn){
	
		return String.valueOf(sIn.charAt(sIn.length()-1));
    }


    public TreeInterface getTree(int flag){
	TreeInterface x = new BinarySearchTree();
	switch(flag){
		case 0:
		  x = Node;
		  break;
		case 1:
		  x = Node1;
		  break;
		case 2:
		  x = Node2;
		  break;
		default:
		  break;
	}
      return x;
  }
  

     //function to check if an input line is valid
 
    private boolean isFormatValid(String sIn){
	if(sIn.length() > 6){
	    return false;
	}
	if(sIn.trim().length()==0){
	    return false;
	}
	String z = sIn.substring(0,4);
	String no ="0123456789";
	int i =0;
	int j = 0;
	do{
		int k = 0;
	    while(k<no.length()){
		if(z.charAt(j)==no.charAt(k)){
		    i++;
		}
		  k++;
	    }
	    j++;
	}
	while(j<z.length());
	if(i<3){
	    return false;
	}
	return true;
    }
    
    
    //Converts the string input to an Int
    
    private int convertToInt(String sIn){
	int x=0;
	int i = 0;
	while(i<sIn.length()){
	    x = x*10+sIn.charAt(i)-'0';
	    i++;
	}
	return x;
    }

    
   private void trimTrees(int nodeIndex){
	Node MainNode = Node.find(nodeIndex);
	String courseToDelete = findCourse(line);
	if(MainNode!=null && isCourseValid(courseToDelete)){

	    MainNode.deleteCourse(courseToDelete);
	    MainNode.notifyAll(courseToDelete);
	}
    }

    //finds if a course given is valid
     
    private boolean isCourseValid(String sIn){
	String num = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int j = 0;
	while(j<num.length()){
	    String y = String.valueOf(num.charAt(j));
	    if(y.equals(sIn)){
		return true;
	    }
	    j++;
	}
	  errorFlag = true;
	  return false;

    }

    public String getErrorMsg(){
	return errorMsg;
    }
 }

   