import java.util.*;
import java.io.*;
class DemoTnDWeight
{
	public static long sumTotalCountry(ArrayList<Long> al) 
	{
		long TotItems =0l;
		for (int i=0;i<al.size();i++ ) 
		{
			TotItems+=al.get(i);				
		}		
		return TotItems;
	}
	public static long sumTotalItems(ArrayList<ArrayList<Long>> data,int itemNum)
	{
		long TotItems=0;
		int country = data.size();
		for(int i=0;i<country;i++)
		{
			(data.get(i)).get(itemNum);
			TotItems+=(data.get(i)).get(itemNum);;
		}			
		return TotItems;
	}
	public static void showCount(float itemCnt)
	{
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\n\t\t Count is : "+itemCnt);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	public static int displayCountry(ArrayList<String> coutryNames)
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
		return cty;
	}
	public static int displayItems(ArrayList<String> itemNames)
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
		int cty = sc.nextInt();					
		return cty;
	}
	public static void Calculation(ArrayList<ArrayList<Long>> data,ArrayList<String> itemNames,ArrayList<String> coutryNames)
	{
			float itemCnt;
			Scanner sc= new Scanner(System.in);
			float t_weight,d_weight ;
			while(true)
			{
				System.out.println("\n ===================   MENU   ==================== ");
				System.out.print("\n\t\t 1) Total Coutry Items \n\t\t 2) Total Items \n\t\t 3) T weight \n\t\t 4) D weight");
				System.out.print("\t\t Enter the Choice : ");
				int choice = sc.nextInt();
				if(choice>4)
					break;
				switch(choice)
				{
					case 1:
							
							int cty = displayCountry(coutryNames);
							itemCnt = sumTotalCountry(data.get(cty-1));
							System.out.println("\n\t\t Total Items In "+coutryNames.get(cty-1)+" are :"+itemCnt);
							//showCount(itemCnt);
							break;
					case 2:
							cty = displayItems(itemNames);
							itemCnt = sumTotalItems(data,cty-1);
							System.out.println("\n\t\t Total "+itemNames.get(cty-1)+" in All Coutries are  :"+itemCnt);
							//showCount(itemCnt);
							break;
					case 3:
							/* D weight */
							int country = displayCountry(coutryNames);
							int item    =  displayItems(itemNames);
							itemCnt     = (data.get(country-1)).get(item-1);
							d_weight    = ( (float)itemCnt / sumTotalItems(data,0) *100);													
							d_weight    =  Math.round(d_weight*100)/100;
							showCount(d_weight);
							break;		
					case 4:
							/*  TV of india / Total TV in  all Coutries */
							itemCnt     = (data.get(country-1)).get(item-1);
							//d_weight = ( (float)itemCnt / sumTotalItems(data,0) *100);						
							t_weight =( (float)itemCnt / sumTotalCountry(data.get(0) ) *100);
							t_weight = Math.round(t_weight*100)/100;
							showCount(t_weight);
							break;		
					default :
							System.out.print("\n !!!!!!  !!!!  Enter the Valid Choice !!!!!!   !!!!!!  ");		
							break;
				}
				System.out.print("================================================================");
				System.out.print("================================================================");
			}	
			
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc= new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new FileReader("TData.csv"));
		float t_weight,d_weight ;

		ArrayList<Long> al = new ArrayList<Long>();
		ArrayList<ArrayList<Long>> data = new ArrayList<>(); 
		ArrayList<String> itemNames = new ArrayList<String>();
		ArrayList<String> coutryNames = new ArrayList<String>();
		
		int cnt=0,items;
		long itemCnt;

		String l;
		while( (l=bf.readLine())!=null)
		{
			String p[] = l.split(",");
			
			items =p.length-1;
			ArrayList<Long> a1 = new ArrayList<Long>();

			if(cnt==0)
			{
				
				System.out.println("\nItems ="+items);								
				System.out.println("\n\t"+p[0]+"\t\t"+p[1]+"\t\t"+p[2]+"\t\t"+p[3]+"\t\t"+p[4]);
				for(int i=1;i<=items;i++)
				{
					itemNames.add(p[i]);
				}	
				cnt++;
			}	
			else
			{
				System.out.println("\n\t"+p[0]+"\t\t"+p[1]+"\t\t"+p[2]+"\t\t"+p[3]+"\t\t"+p[4]);
				coutryNames.add(p[0]);
				for(int i=1;i<=items;i++)
				{
					a1.add(Long.parseLong(p[i]));
				}	
				data.add(a1);
			}	
			//System.out.print(a1);
		}
		Calculation(data,itemNames,coutryNames);
		System.out.println();		
	}
}
