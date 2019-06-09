import java.util.*;
class ZNormalization
{
	public static void display(ArrayList<Float> al)
	{
		int i=0;
		for (float d : al ) 
		{
			System.out.print(d+"  ");	
			i++;
			if(i%10==0)
				System.out.print("\n\t\t\t ");

		}
	}
	public static float getMean(ArrayList<Float> al)
	{
		float mean;
		float sum=0;
		for (int i=0; i<al.size();i++ ) 
		{
			sum+=al.get(i);
		}
		mean = sum/al.size();
		return mean;
	}	
	public static double getDeviation(ArrayList<Float> al, float mean)
	{
		float xi;	
		double dev;

		float sum=0;
		for (int i=0; i<al.size();i++ ) 
		{
			xi= al.get(i);
			sum+=Math.pow((xi-mean),2);
		}		
		dev = Math.pow((sum/al.size()),0.5);
		
		return dev;
	}	
	public static void normalize(ArrayList<Float> al, float mean,double dev)
	{
		float zscore;		 

		for(int i=0;i<al.size();i++)
		{

			zscore = (al.get(i) - mean)/(float)dev;			
			zscore = Math.round(zscore*100.0);
			zscore = zscore/100;
			al.set(i,zscore);			
		}	
		
	}	
	public static void calculation()
	{
		int ch;
		ArrayList <Float> al = new ArrayList <Float>();
		float mean,zscore;
		double dev;

		Scanner sc  = new Scanner(System.in);
		al.add(8f);
		al.add(10f);
		al.add(15f);
		al.add(20f);
		while(true)
		{
			System.out.print("\n ************ MENU ************");
			System.out.print("\n 1) Add Number \n 2) Display Data \n 3) Normalize Data \n 3> Exit ");
			System.out.print("\t\t Enter your choice : ");
			ch = sc.nextInt();
			if(ch>3)
				break;
			switch(ch)
			{
				case 1 :	
						System.out.print("\t Enter the data : ");
						al.add(sc.nextFloat());
						break;
				case 2 :	
						System.out.println("\n\n  ================    Data          =================== ");
						System.out.print("\t ");
						display(al);
						System.out.print("\n\n============================================================ ");
						System.out.print("\n");

						break;
				case 3 :	
						mean = getMean(al);
						dev  = getDeviation(al,mean);
						System.out.println("\n Mean = "+mean+"\t Deviation : "+dev);
						normalize(al,mean,dev);	
						break;

			}
			
		}	
	}	
	public static void main(String[] args) 
	{		
		calculation();
		System.out.print("\n\n\n");
	}
}