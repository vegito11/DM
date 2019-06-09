import java.util.*;
import java.io.*;
import static java.lang.System.out; 
class InfoGain
{
  public static double calLogEachAtr(ArrayList<Integer> al)
  {
	     int n = al.size();
	     int count = calProb(al);
	     double entropy=0;
	     double yx;
	     for(int i=0;i<n;i++)
	     {
	          yx = (double)al.get(i)/count;
	          if(al.get(i)==0)
	          	return entropy;
	          entropy -= ( (yx)* Math.log(yx)/Math.log(2) );
	     }     
	    // System.out.println(entropy);
	     return entropy;
  }
  public static int calProb(ArrayList<Integer> al)
  {
	    int sum=0;
	    for (int i=0; i<al.size();i++ ) 
	    {
	    		sum+=al.get(i);
	    }	
	    return sum;
  }
  public static double calInfoGainEachAttribute(HashMap<String,ArrayList<Integer>> h ,ReadGainData r)
  {
	    int type = h.size();
	    double entropy,infoGain=0;
	    double ratio;
	    int total = r.total_row;
	    int typecnt=0;
	    Set  key = h.keySet();
	    Iterator itr = key.iterator();
	     while(itr.hasNext())
	     {
	               String s = (String)itr.next();
	               ArrayList<Integer> al = h.get(s);
	               typecnt = calProb(al);
	               entropy = calLogEachAtr(al);
	               ratio = ((double)typecnt/total);
	               //System.out.println("ratio :" +ratio);
	               infoGain -=  ratio * entropy ;
	               
	     }
	     
  		return infoGain;	
  }
  

  public static void main(String... args) throws Exception
  {
      ReadGainData r =  new ReadGainData("info.csv");
      String attri[] = r.attributes.split(",");
      double gain=0;
      for (int i=0;i<r.attributFreq.size() ;i++ ) 
      {
     		 gain = -calInfoGainEachAttribute(r.attributFreq.get(i),r); 		
     		 System.out.println("\n Information Gain of "+attri[i]+" : "+gain);     		 
      }
      System.out.println();
     
  }
}
