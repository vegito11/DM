import java.util.*;
import java.io.*;
class Classifier
{
	public static void getData(String s[],String atr[])
	{
		System.out.println(" \n Enter the :");
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<atr.length-1;i++ )
		{
			System.out.print("  "+i+" ) "+atr[i]+" : ");
			s[i-1]  = sc.nextLine().toLowerCase().trim();
		}
		
	}
	public static void displayAttr(String s[],String atr[])
	{
		for(int i=1; i<atr.length-1;i++ )
		{
			System.out.print("  "+i+" ) "+atr[i]+" : "+s[i-1]);			
		}

	}
	public static void display(String s[])
	{
		for(int i=0; i<s.length-1;i++ )
		{
			System.out.print("  "+i+" ) "+s[i]);			
		}

	}
	public static float calResulProb(ReadPLayData r,String s[],int trgcol)
	{
		float resulProb=0,tmp;
		resulProb = r.trgprob.get(trgcol);
		for (int i=0; i<s.length-2;i++ ) 
		{
			//System.out.println(s[i]+" : "+ r.calAtrProb(i,s[i],trgcol));	
			tmp = r.calAtrProb(i,s[i],trgcol);
			if(tmp==-1)
				tmp=0;
			resulProb *= tmp;	
		}		
		return resulProb;
	}
	public static void decision(ReadPLayData r,String s[])
	{
		float prob;
		for(int i=0;i<r.target.size();i++)
		{
			prob = calResulProb(r,s,i);	
			System.out.println(" Probability  "+r.target.get(i)+" =  "+ prob);
		}	
	}
	public static void main(String[] args) throws Exception
	{
		ReadPLayData r = new ReadPLayData("playData.csv");
		String atr[]   =  r.attributes.split(",");
		String s[] = new String[r.columns];
		getData(s,atr);
		System.out.println("\n===========================================================================");
		displayAttr(s,atr);
		System.out.println("\n===========================================================================");		
		decision(r,s);
		System.out.println();
	}
}
//Overcast	Hot	Normal	FALSE	Yes