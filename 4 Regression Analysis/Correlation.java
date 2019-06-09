import java.io.*;
import java.util.*;
class Correlation
{
	public static void main(String[] args) throws IOException 
	{
		
		double r;
		String fname = "Data.csv";
		CsvRead c = new CsvRead(fname);
		double up = (c.tot_record*c.Sumxy)-(c.Sumx*c.Sumy);
		double down = ((c.tot_record*c.Sumx_sqr)-(Math.pow(c.Sumx,2)))*((c.tot_record*c.Sumy_sqr)-(Math.pow(c.Sumy,2)));
		down = Math.round(Math.pow(down,(0.5)));		
		r=(up/down);		
		r=Math.round(r * 100.0) / 100.0;
		System.out.print("\n Coffiencent of Correlation is : "+r);
		System.out.println("\n");
	}
}