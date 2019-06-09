import java.util.*;
import java.io.*;

public class Point
{
	ArrayList<Float> pt ;	
	static int count,no_of_cluster;
	static ArrayList<Point> means = new ArrayList<Point>();
	Point()
	{
		pt = new ArrayList<Float>();
	}
	public void add(Float val)
	{
		pt.add(val);
	}
	public void displayData()
	{
		for(int i=0;i<pt.size();i++)
		{
			System.out.print(pt.get(i));
			if(i<pt.size()-1)
				System.out.print(",");
		}

	}
	public double differ(Point p)
	{
		double sum=0;
		for(int i=0;i<pt.size();i++)
		{
			sum = sum+Math.pow( (double)( pt.get(i) - p.pt.get(i) ) ,2);
		}	
		float x =(float)Math.pow(sum,2);
		//System.out.println("x :"+(float)x);
		return x;

	}	
	public Point adding(Point p2)
	{
		Point psum = new Point();
		for(int i=0;i<pt.size();i++)
		{
			psum.add(pt.get(i)+p2.pt.get(i));
		}	
		return psum;
	}
	public static void setMean(int i,Point mean)
	{
		means.set(i,mean);
	}

}