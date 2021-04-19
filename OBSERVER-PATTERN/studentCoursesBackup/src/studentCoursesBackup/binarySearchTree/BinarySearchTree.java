package studentCoursesBackup.binarySearchTree;

import studentCoursesBackup.binarySearchTree.TreeInterface;
import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree implements TreeInterface
{
    /*
      I have taken this implementation of BST from the book:
      Data Structures & Algorithms in Java(second edition) by 
      Robert Lafore, p406-410. I use code from the there and 
      modify according to the requirement of assignment.
     */

    private Node root; 
    private Node treeOrig = null;
    /**
     *constructor
     **/
    public BinarySearchTree(){
	root = null;
    }
     public Node getTreeOrig() {
		return treeOrig;
	}
    //___________________TreeInterface____________________

   

    public Node find(int index){
	Node parent = root;
	if(root==null){
		return null;
	}
	
	
	while(parent.getNodeIndex()!=index){
	    if(index<parent.getNodeIndex()){
		parent = parent.getLeft();
	    }else{
		parent = parent.getRight();
	    }
	    if(parent==null){
		return null;
	    }
	}
	return parent;
} 

    
	public void insertNode(Node newNode){
	int index = newNode.getNodeIndex();
	if(find(index)==null){
	    if(root == null){
		root = newNode;
	    }else{
		Node current = root;
		Node parent;
		while(true){
			
		    parent = current;
		    if(index<current.getNodeIndex()){
			current = current.getLeft();
			if(current == null){
			    parent.setLeft(newNode);
			    break;
			}
		    }else{
			current = current.getRight();
			
			if(current == null){
			    parent.setRight(newNode);
			    break;
			}
		    }
		}
	    }
	}
    } 

    
    

    //returns a string of all nodes in acsending order
   
     public String printNodes(){
	 String result="";
	
	    
	    Stack<Node> store = new Stack<Node>();
	    Node parent = root;
	    while(!store.isEmpty() || (parent!= null))
	    {
	  
		if(parent !=null)
		{
		    store.push((Node) parent);
		    parent = parent.getLeft();
		}else
		{
		    Node storeNode = store.pop();
		    ArrayList<String> courseList = storeNode.getAllCourses();
		    
		    int StoreIndex = storeNode.getNodeIndex();
		    String x = "";
		    if(StoreIndex<10)
		    {
		    	x = x +"00";
		    }else if(StoreIndex<100)
		    {
		    	x = x +"0";
		    }
		    result = result + x   + StoreIndex + ": " ;
		
		
		    if(!courseList.isEmpty()){
		    	int j = 0;
		    	while(j<courseList.size()-1){
			
			   result = result + courseList.get(j) ;
			   j++;
			}
			
			result = result + courseList.get(courseList.size()-1);
		    }
		    result = result + "\n";    
		    parent = storeNode.getRight();
		     
		   }
		
	    }
	
	return result;
    }
}
     