import java.util.*;
import java.io.*;
class TnDWeight
{
	public static void Calculation(TDRead t) throws Exception
	{
			long itemCnt,itemx;
			int cty,country,item;
			Scanner sc= new Scanner(System.in);
			float t_weight,d_weight ;
			while(true)
			{
				System.out.println("\n ===================   MENU   ==================== ");
				System.out.print("\n\t\t 1) Total Item's Count In Coutry \n\t\t 2) OverAll Count of Item  \n\t\t") ;
				System.out.print(" 3) T weight \n\t\t 4) D weight \n\t\t 5) All");
				System.out.print("\t\t Enter the Choice : ");
				int choice = sc.nextInt();
				if(choice>5)
					break;
				switch(choice)
				{
					case 1:
							
							cty     = t.displayCountry(t.coutryNames);
							itemCnt = t.TotalItemInCountry(t.data.get(cty));
							System.out.println("\n\t\t Total Items In "+t.coutryNames.get(cty)+" are :"+itemCnt);
							break;
					case 2:
							cty = t.displayItems(t.itemNames);
							itemCnt = t.Item1Sum(t.data,cty);
							System.out.println("\n\t\t Total "+t.itemNames.get(cty)+" in All Coutries are  :"+itemCnt);	
							break;
					case 3:
							/* D weight */
							country    =  t.displayCountry(t.coutryNames);
							item       =  t.displayItems(t.itemNames);
							itemx      =  (t.data.get(country)).get(item);
							System.out.println("\t\t"+t.coutryNames.get(country)+" Have "+itemx+" "+t.itemNames.get(item)+"'s");
							d_weight   =  ((float)itemx / t.Item1Sum(t.data,item));
							d_weight   =  Math.round(d_weight*10000)/100;
							System.out.println("\n\t\t D weight is : "+d_weight+" % ");
							
							break;		
					case 4:
							/*  TV of india / Total Item in India */
							country  =  t.displayCountry(t.coutryNames);
							item     =  t.displayItems(t.itemNames);
							itemx    =  (t.data.get(country)).get(item);
							System.out.println("\t\t"+t.coutryNames.get(country)+" Have "+itemx+" "+t.itemNames.get(item)+"'s");
							t_weight =  ((float)itemx/t.TotalItemInCountry(t.data.get(country)) );
							t_weight =  Math.round(t_weight*10000)/100;
							System.out.println("\n\t\t T weight is : "+t_weight+"%");
							break;		
					case 5:
							Thread.sleep(300);
							System.out.println("\n----------------------------------------------------------");
							
							for(int i=0;i<t.coutryNames.size();i++)
							{
								System.out.print("   in "+t.coutryNames.get(i)+" :"+t.TotalItemInCountry(t.data.get(i)));
							}
							Thread.sleep(400);	
							System.out.println("\n----------------------------------------------------------");
							
							for(int i=0;i<t.itemNames.size();i++)
							{
								System.out.print("\t Total  "+t.itemNames.get(i)+" :"+t.Item1Sum(t.data,i));
							}							
							
							System.out.println("\n----------------------------------------------------------");
							Thread.sleep(400);
							System.out.println("=============== T Weight ===================");
							System.out.print("\t");
							for(int i=0;i<t.itemNames.size();i++)
								System.out.print("     "+t.itemNames.get(i)+"  ");
							System.out.println();
							
							for(int i=0;i<t.coutryNames.size();i++)
							{
								System.out.print(t.coutryNames.get(i)+"  ");
								for(int j=0;j<t.itemNames.size();j++)
								{
									Long cnt = (t.data.get(i)).get(j);
									Double ans1 = (double)(cnt)/t.TotalItemInCountry(t.data.get(i))*100;
									ans1 = Math.round(ans1*100)/100.0;
									System.out.print("    "+ans1+"%  ");
									Thread.sleep(50);
								}	
								System.out.println();						
							}
							
							Thread.sleep(400);

							System.out.println("\n----------------------------------------------------------");
							System.out.println("=============== D Weight ===================");
							System.out.print("\t");
							for(int i=0;i<t.itemNames.size();i++)
								System.out.print("    "+t.itemNames.get(i)+"  ");
							System.out.println();
							
							for(int i=0;i<t.coutryNames.size();i++)
							{								
								System.out.print(t.coutryNames.get(i)+"  ");
								for(int j=0;j<t.itemNames.size();j++)
								{
									Long cnt1 = (t.data.get(i)).get(j);
									Double ans = (double)(cnt1)/t.Item1Sum(t.data,j)*100;
									ans = Math.round(ans*100)/100.0;
									System.out.print("   "+ans+"%  ");
									Thread.sleep(S50);
								}	
								System.out.println();						
							}

							break;
					default :
							System.out.print("\n !!!!!!  !!!!  Enter the Valid Choice !!!!!!   !!!!!!  ");		
							break;
				}
				System.out.print("================================================================");
				System.out.print("================================================================");
			}	
			
	}
	public static void main(String[] args) throws IOException,Exception
	{
		Scanner sc= new Scanner(System.in);
		String fname = "TData.csv";
		TDRead t = new TDRead(fname);		
		Calculation(t);
		System.out.println();		
	}
}


/**
	D Weight is global calculated
	d = item1 / All item1 in all country
	t = item1 / All items in that country
*/
