/*
c  = ( [Ex2] * [Ey] - [Ex.Exy ] / ( n[Ex2]- (Ex)2 )  
m  = ( [ nExy ] - [  Ex.Ey ] / ( n[Ex2]- (Ex)2 )	 
*/
import java.io.*;
import java.util.*;
strictfp class Regression
{
	
	public static double calculateC(CsvRead cs)
	{
		double c;		
		c = ((cs.Sumx_sqr)*(cs.Sumy)-(cs.Sumx*cs.Sumxy))/(cs.tot_record*(cs.Sumx_sqr)-(cs.Sumx*cs.Sumx));		
		return Math.round(c*100);
	}
	public static double calculateY(CsvRead cs)
	{
		double m;		
		m = ((cs.tot_record)*(cs.Sumxy)-(cs.Sumx*cs.Sumy))/(cs.tot_record*(cs.Sumx_sqr)-(cs.Sumx*cs.Sumx));		
		return Math.round(m*100);
	}
	public static void Calculation(Double m,Double c)
	{
		String line;
		Scanner sc  = new Scanner(System.in);
		//int n = '\n';
		System.out.println("\n Press 'Enter' if want to Quit");
		while(true)
		{
			System.out.print(" Enter x :");
			line = sc.nextLine();
			
			double y=0,x;
			
			if(line.compareTo("\n")==-1)
			{				
				break;
			}
			else
			{				
				x = Double.parseDouble(line);
				line="";
				y = m*x+c;
			}	
			System.out.println(" Predicated Price is : "+y);
			System.out.println("\n------------------------------------------\n");

		}	

	}
	public static void main(String[] args) throws IOException 
	{
		int i=0,j=0;		
		double c,y,m;
		String fileName = "Data.csv";
		CsvRead cs = new CsvRead(fileName);
		//cs.printXY();		
		m = calculateY(cs)/100;
		System.out.print("\n Slope = "+m);	
		c = calculateC(cs)/100;
		System.out.println("\t Y-intercept  = "+c);	
		Calculation(m,c);
		System.out.println();
		
	}
}