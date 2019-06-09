import java.util.*;
import java.io.*;
class Tree
{
	 int count=0;
	 boolean havechild=false;
	 String itemName;
	 ArrayList<Tree> childs = ArrayList<Tree>
	 int no_of_child=0;
	 public addToTree(Tree t,ArrayList<String> roots,ArrayList<String> transaction)
	 {
	 	String start = transaction.get(0)
	 	if(!roots.contains(start))
	 	{
	 		Tree ch = new Tree();
	 		ch.itemName = start;
	 		t.no_of_child+=1;
	 		t.count+=1;
	 		t.havechild=true;
	 		t.child.add(ch);
	 		
	 		for(int i=1;i<transaction.size();i++)
	 		{
	 			
	 		}	
	 	}	
	 }	
}