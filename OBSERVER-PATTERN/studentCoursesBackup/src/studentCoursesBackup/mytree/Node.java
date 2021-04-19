package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.myTree.SubjectInterface;
import studentCoursesBackup.myTree.ObserverInterface;

public class Node implements SubjectInterface, ObserverInterface, Cloneable
{ 
    private ArrayList<String> courseList;
    private Node left;
    private int bNo; 
    private Node right;
    private ArrayList<ObserverInterface> Listeners;
    /**
     *Constructor for specific node
     **/
    public Node(int bNoIn){
    Listeners = new ArrayList<>();
    right = null;
    left = null;
    bNo = bNoIn;
    courseList = new ArrayList<>();
    
    
     }
    
    /**
     *inserts Course for a specific node
     **/
    public void insert(String sIn){
    if(!courseList.contains(sIn)){
        courseList.add(sIn);
    }
    }

    /**
     *deletes a course from a specific node
     **/
    public void delete(String sIn){
    while(courseList.contains(sIn)){
        courseList.remove(courseList.indexOf(sIn));
    }
    }

    /**
     *gets all course list for a node
     **/
    public ArrayList<String> getAllCourses(){
    return courseList;
    }

    //------------Prototype Pattern Implementation------------------
    
    public Node clone(){
    
    Node parent = new Node(this.getNodeIndex());
    parent.left = this.left;
    parent.right = this.right;
    parent.Listeners = this.Listeners;
    parent.courseList = this.courseList;

    return parent;
    }    
    
    //-------------------Observer Interface--------------------------

    public void update(ObserverInterface oIn, String sIn){
    Node parent = (Node) oIn ;
    parent.delete(sIn);
    
    }

    //-------------------Subject Interface---------------------------

    public void registerObserver(ObserverInterface oIn)
    {
      this.Listeners.add(oIn);
    }
    public void deleteCourse(String sIn){
      while(courseList.contains(sIn)){
      courseList.remove(courseList.indexOf(sIn));
     }
    }
    
    public void removeObserver(ObserverInterface oIn)
    {
        int index = this.Listeners.indexOf(oIn);
        this.Listeners.remove(index);
    
    }

    //updates state of all Observers
    public void notifyAll(String sIn)
    {
    while(!Listeners.isEmpty())
    {
        for(ObserverInterface parent : Listeners){
        update(parent,sIn);
        }
    }
    }
     /**
     *get method for left child
     **/
    public Node getLeft(){
    return left;
    }

    /**
     *sets left child
     **/
    public void setLeft(Node left){
    this.left = left;
    }

    /**
     *gets the index of the node
     **/
    public int getNodeIndex(){
    return this.bNo;
    }

    /**
     *gets the right child of the node
     **/
    public Node getRight(){
    return right;
    }

    /**
     *setter for right child
     **/
    public void setRight(Node right){
    this.right = right;
    }

   
}