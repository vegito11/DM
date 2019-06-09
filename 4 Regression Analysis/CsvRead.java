import java.io.*;
import java.util.*;

public class CsvRead
{
	int i=0,j=0;
	Double Sumx=0.0,Sumy=0.0,Sumx_sqr=0.0,Sumy_sqr=0.0,Sumxy=0.0;
	ArrayList<Double> x    = new ArrayList<Double>();
	ArrayList<Double> y    = new ArrayList<Double>();
	ArrayList<Double> xsqr = new ArrayList<Double>();
	ArrayList<Double> ysqr = new ArrayList<Double>();
	ArrayList<Double> xy   = new ArrayList<Double>();
	int tot_record=0;

	CsvRead(String fname) throws IOException
	{
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(fname));
		int i=0,cnt=0;		
		while((line=reader.readLine())!=null)
		{
			if(line.compareTo(",")==0)
				break;
			
			String s[] = line.split(",");
			if(i==0)
			{
				i++;
				continue;
			}	
			x.add(Double.parseDouble(s[0]));		
			y.add(Double.parseDouble(s[1]));
			cnt++;							
		}	
		tot_record = cnt;
		updateXY();
		//System.out.println("\n rec = "+tot_record);
	}

	public static void main(String[] args) throws IOException
	{		
			
		System.out.println();
		CsvRead csv = new CsvRead("Data.csv"); 						
		csv.printXY();
		System.out.println();
	}

	public void printXY()
	{
		System.out.println("\t X"+"\t Y"+"\t X2"+"\t Y2"+" \t XY");
		System.out.println("------------------------------------------------------");
		for (int i=0;i<x.size();i++) 
		{
			System.out.println("\t"+x.get(i)+"\t"+y.get(i)+"\t"+xsqr.get(i)+"\t"+ysqr.get(i)+"\t"+xy.get(i));
		}
		System.out.println("------------------------------------------------------");
		System.out.println("\t"+Sumx+"\t"+Sumy+"\t"+Sumx_sqr+"\t"+Sumy_sqr+"\t"+Sumxy);
		System.out.println();
	}

	public void updateXY()
	{		
		Double tmpx,tmpy;
		for (int i=0;i<x.size();i++) 
		{
			tmpx= x.get(i);
			tmpy= y.get(i);
			xsqr.add(tmpx*tmpx);
			ysqr.add(tmpy*tmpy);
			xy.add(tmpx*tmpy);				
			Sumx+=tmpx;
			Sumy+=tmpy;
			Sumx_sqr+=xsqr.get(i);
			Sumy_sqr+=ysqr.get(i);
			Sumxy+=xy.get(i);

		}	

	}
}