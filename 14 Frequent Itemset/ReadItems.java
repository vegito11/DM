import java.util.*;
import java.io.*;
class ReadItems
{
	double minsup;
	int total;
	HashMap<String,Integer> items = new HashMap<String,Integer>();
	ArrayList<String> transactions= new ArrayList<String>();
	ArrayList<String> itemset = new ArrayList<String>();
	ArrayList<ArrayList<String>> frequent = new ArrayList<ArrayList<String>>();

	ReadItems(String fname) throws Exception
	{
		BufferedReader bf  = new BufferedReader(new FileReader(fname));
		String line;
		int cnt=-1,freq;
		while((line = bf.readLine())!=null)
		{
			String sp[] = line.split(",");
			cnt++;
			if(cnt==0)
				continue;
			String s="";
			for(int i=1;i<sp.length;i++)
			{
				if(sp[i].isEmpty())
					continue;
				String tmp = sp[i].toLowerCase().trim();
				s = s+tmp+" ";

				if(items.containsKey(tmp))
				{
					freq = items.get(tmp);
					freq=freq+1;
					items.put(tmp,freq);
				}
				else
				{
					items.put(tmp,1);
					ArrayList<String> al =  new ArrayList<String>();
					al.add(tmp);
					frequent.add(al);
				}					
			}
			System.out.print(" Transactions "+cnt+" : ");
			transactions.add(s);
			System.out.println(s);					
			total = cnt;
		}	
		System.out.println("\n============================================================================");
		System.out.println(items);	
		//System.out.println("\n Total :"+total);	
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter the Minimum Support(%) : ");
		float tmp = sc.nextInt()/100.0f;
		//System.out.println(tmp);
		minsup = Math.floor(total*(tmp));		

	}
	public void itemSet()
	{
		Set key = items.keySet();
		Iterator i = key.iterator();		
		while(i.hasNext())
		{
			String name = (String)i.next();
			items.get(name);
			if(items.get(name)<minsup)
			{
				ArrayList<String> al =  new ArrayList<String>();
				al.add(name);
				frequent.remove(al);
			}	
			//System.out.println(name+"\t\t\t"+h.get(name));
		}	
		System.out.println("\n Frequent Items : "+frequent);		
	}
// /*
	public void nextItemSet(int cluster)
	{
			cluster = cluster-1;
			String i1,i2;			
			String s;
			for(int i=0;i<frequent.size()-1;i++)
			{				
				i1 = frequent.get(i).get(0);								
				for(int j=i+1;j<frequent.size()-cluster+1;j++)
				{
				//	System.out.print(" [ "+i1);
					s=i1;
					for (int k=j;k<j+cluster && k<frequent.size();k++) 
					{		
							i2 = frequent.get(k).get(0);
					//		System.out.print(", "+i2);
							s = s+" "+i2;
					}
					//System.out.println(" ] ");	
					itemset.add(s);
				}				
			}	
	}
	public static boolean containItems(String all,String s)
	{		
		String item[]  = s.split(" ");
		String tmp;
		//System.out.print("\n All :"+all+" \t S = "+s);
		for(int i=0;i<item.length;i++)
		{
			tmp = item[i]+" ";
			if(all.indexOf(tmp)!=-1)
			{
				//System.out.print("\n\t Item :"+tmp+" is at "+all.indexOf(item[i]));
				//System.out.print(" "+i+all.contains(item[i])+" \t");
				continue;
			}	
			else
			{
				return false;				
			}	

		}	
		return true;
	}
	public int calculateSupport(String s)
	{
		String all;
		int cnt=0;
		for (int j=0; j<transactions.size(); j++) 
		{
			all = transactions.get(j);
			if(containItems(all,s))
			{
				cnt++;
				//System.out.print(" \t\t v =  "+cnt);
			}	
		}
		//System.out.print("\n Cnt = "+cnt);
		return cnt;
	}

	public void frequentItems()
	{
		String all,s;		
		int cnt=0;		
		for(int i=0;i<itemset.size();)
		{
			s = itemset.get(i);	
			cnt=0;
			for (int j=0; j<transactions.size(); j++) 
			{
				all = transactions.get(j);
				if(containItems(all,s))
					cnt++;
			}
			//System.out.println("\n Cnt :"+cnt);
			if(cnt<minsup)
			{	
				itemset.remove(s);
			}
			else
			{
				System.out.print("\n\t"+s+" \t  :  "+cnt);
				i++;
			}	

		}	
	}

//	*/
	public static void main(String[] args) throws Exception
	{
	}
}