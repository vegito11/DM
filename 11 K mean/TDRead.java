import java.io.*;
import java.util.*;

public class TDRead
{		
	int cnt=0;
	/*  All Points */
	ArrayList<Point> pnts = new ArrayList<Point>();
	String l;
	/* Clusters  */
	ArrayList<ArrayList<Point>> cluster = new ArrayList<ArrayList<Point>>();
	TDRead(String fname) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter the Number of Cluster : ");
		Point.no_of_cluster = sc.nextInt();

		BufferedReader bf = new BufferedReader(new FileReader(fname));
		while((l=bf.readLine())!=null)
		{
			String val[] = l.split(",");			

			if(cnt==0)
			{
				cnt++;
				continue;
			}	
			Point p = new Point();				
			for(int i=0;i<val.length;i++)
			{
				p.add(Float.parseFloat(val[i]));
			}								
			pnts.add(p)	;					
		}
		Point.count=pnts.size()	;
		this.randMean();
	}
	public void randMean()
	{
		for(int i=0;i<Point.no_of_cluster;i++)
		{
			Point pm = pnts.get(i+1);
			Point.means.add(pm);
			ArrayList<Point> p = new ArrayList<Point>();
			cluster.add(p);
		}	
	}
	public void displayPoints()
	{
		
		for (int i=0; i<pnts.size();i++ ) 
		{
			System.out.print(" Point :"+(i+1)+" : [");
			pnts.get(i).displayData();	
			System.out.print("]");
			System.out.println("\n");
		}		
	}
	public void displayMeans()
	{		
		for (int i=0;i<Point.no_of_cluster ;i++ ) 
		{
			System.out.print(" Mean "+(i+1)+" : ");	
			Point.means.get(i).displayData();
			System.out.println();
		}
	}
	public void displayCluster()
	{		
		for (int i=0;i<cluster.size() ;i++ ) 
		{
			
			System.out.print(" Cluster "+(i+1)+" : ");	
			for(int j=0;j<cluster.get(i).size();j++)
			{
				System.out.print("[");
				cluster.get(i).get(j).displayData();
				System.out.print("] ");
			}	
			System.out.println();
		}
	}
	public void updateMean()
	{
		for(int i=0;i<cluster.size();i++)
		{
			ArrayList<Point> pz = cluster.get(i);
			Point sum ;
			sum = pz.get(0);			
			for (int j=1;j<pz.size() ;j++ ) 
			{
					sum = sum.adding(pz.get(j));
			}

			for(int j=0;j<sum.pt.size();j++)
			{
				float f = sum.pt.get(j)/pz.size();
				//System.out.println(" Size : "+pz.size());
				sum.pt.set(j,f);
			}	
			Point.means.set(i,sum);
		}	
	}
	public void emptyCluster()
	{
		for(int i=0;i<cluster.size();i++)
		{
			cluster.get(i).clear();
		}	
	}
	public void addToCluster(Point p)
	{
		int num=0;
		double min = Double.MAX_VALUE;
		for(int i=0;i<Point.means.size();i++)
		{			 
			double dif	=  p.differ(Point.means.get(i));
			if(min>=dif)
			{
				min=dif;
				num=i;
			}	
		}
		//System.out.println("NUm :"+num);
		cluster.get(num).add(p);
	}
}