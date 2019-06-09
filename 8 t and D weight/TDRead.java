import java.io.*;
import java.util.*;

public class TDRead
{		
	ArrayList<ArrayList<Long>> data = new ArrayList<>(); 
	ArrayList<String> itemNames = new ArrayList<String>();
	ArrayList<String> coutryNames = new ArrayList<String>();
	int itemcnt=0,countrycnt=0,cnt=0;
	String l;

	TDRead(String fname) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader(fname));
		while( (l=bf.readLine())!=null)
		{
			String p[] = l.split(",");
			
			itemcnt = p.length-1;
			ArrayList<Long> a1 = new ArrayList<Long>();

			if(cnt==0)
			{
				
				for(int i=1;i<p.length;i++)
				{
					itemNames.add(p[i]);
				}	
				cnt++;
			}	
			else
			{				
				coutryNames.add(p[0]);
				for(int i=1;i<p.length;i++)
				{
					a1.add(Long.parseLong(p[i]));
				}	
				data.add(a1);
			}				
		}

	}
	public  long TotalItemInCountry(ArrayList<Long> cntryItems) 
	{
		long TotItems =0l;
		for (int i=0;i<cntryItems.size();i++ ) 
		{
			TotItems+=cntryItems.get(i);				
		}		
		return TotItems;
	}
	public  long Item1Sum(ArrayList<ArrayList<Long>> data,int itemNum)
	{
		long TotItems=0;
		int country = data.size();
		for(int i=0;i<country;i++)
		{
			(data.get(i)).get(itemNum); 		// In each country that Item
			TotItems+=(data.get(i)).get(itemNum);;
		}			
		return TotItems;
	}
	public  int displayCountry(ArrayList<String> coutryNames)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t\t  ******** Coutry Code ******** ");
		int lim=0;
		lim++;
		for (String coutry : coutryNames ) 
		{
			System.out.print("\n\t\t\t\t "+lim+")"+coutry);	
			lim++;
		}
		System.out.print("\t\t Enter the Coutry Code  : ");	
		int cty = sc.nextInt();					
		return cty-1;
	}
	public  int displayItems(ArrayList<String> itemNames)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t\t  ******** Item Code ******** ");
		int lim=0;
		lim++;
		for (String items : itemNames ) 
		{
			System.out.print("\n\t\t\t\t "+lim+")"+items);	
			lim++;
		}
		System.out.print("\t\t Enter the Item Code  : ");	
		int item = sc.nextInt();					
		return item-1;
	}

	public static void main(String[] args) throws IOException
	{		
			
		System.out.println();
		TDRead t = new TDRead("TData.csv"); 						
		//t.data.get(t.displayCountry());
		//t.TotalItemInCountry(t.data.get(t.displayCountry(t.coutryNames)));
		System.out.println(t.TotalItemInCountry(t.data.get(t.displayCountry(t.coutryNames))));
		System.out.println();
	}

}