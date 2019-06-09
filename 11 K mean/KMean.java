import java.util.*;
import java.io.*;
class Kmean
{

	public static void main(String[] args) throws Exception
	{
		int flg=0;
		ArrayList<Point> m2 = new ArrayList<Point>();
		Scanner sc = new Scanner(System.in);
		TDRead t = new TDRead("Data.csv"); 						
		System.out.println("\n ==================   Points ======================== ");
		t.displayPoints();		
		System.out.println("\n ==================   MEAN  ==============================");
		t.displayMeans();
//		System.out.println("\n ===============  Display Cluster ========================");
//		t.displayCluster();
		while(true)
		{
			t.emptyCluster();
			for(int i=0;i<t.pnts.size();i++)
			{
				t.addToCluster(t.pnts.get(i));
			}	
			System.out.println("\n ===================  Clusters  ===========================");
			t.displayCluster();
			m2 =  new ArrayList<Point>(Point.means);
			//System.out.println("\n ===================  M2 Mean  ===========================");
			//t.displayMeans();
			t.updateMean();
			System.out.println("\n ===================  Updated Mean  ===========================");
			t.displayMeans();

			for(int i=0;i<Point.means.size();i++)
			{
				
				double d = m2.get(i).differ(Point.means.get(i));
				if(d<=0.001)
				{
					flg=1;
				}	
			//	System.out.print("\n m2 :");
			//	m2.get(i).displayData();
			//	System.out.print("\n Stat :");
			//	Point.means.get(i).displayData();
			//	System.out.println("d = "+d);
			}	
			if(flg==1)
			break;
		}	
	}
}