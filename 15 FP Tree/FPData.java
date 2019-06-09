import java.util.*;
import java.util.Map;
import java.io.*;
class FPData
{
	HashMap<String,Integer> itemFreq = new HashMap<String,Integer>();	
	ArrayList<ArrayList<String>> transaction = new ArrayList<ArrayList<String>>();
	ArrayList<String> item_sorted ;
	FPData(String fname) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		String l;
		BufferedReader bf = new BufferedReader(new FileReader(fname));
		while((l=bf.readLine())!=null)
		{
			String val[] = l.split(",");			

			if(cnt==0)
			{
				cnt++;
				continue;
			}
			

			else
			{
				ArrayList<String> al = new ArrayList<String>();
				for(int i=1;i<val.length;i++)
				{
					if(val[i].isEmpty())
						continue;
					else if(!itemFreq.containsKey(val[i]))
					{
						itemFreq.put(val[i],1);
					}	
					else 
					{
						itemFreq.put(val[i],itemFreq.get(val[i])+1);
					}	
					al.add(val[i]);
				}
				transaction.add(al)	;
			}	
		}

		bf.close();
		item_sorted = getSortedNames();		
	}
	public ArrayList sortTran(ArrayList<String> toSort, ArrayList<String> sorted)
	{
		ArrayList<String> sort  = new ArrayList<String>();
		for(int i=0;i<sorted.size();i++)
		{
			 if(toSort.contains(sorted.get(i)))
			 	sort.add(sorted.get(i))	;
		}	
		return sort;
	}
	public void sortTransaction()
	{
		ArrayList<String> sort  = new ArrayList<String>();
		for(int i=0;i<transaction.size();i++)
		{
			ArrayList<String> current  = transaction.get(i);
			sort = sortTran(current,item_sorted);
			transaction.set(i,sort);
		}	
	}
	public ArrayList getSortedNames()
	{
		List<Map.Entry<String,Integer>> list = sortMap(itemFreq) ;
		ArrayList<String> al = new ArrayList<String>();
		
		for(Map.Entry<String,Integer> items : list)
		{			
			al.add(items.getKey());
		}
		//System.out.println(" ArrayList :"+al);
		return al;
	}
	public static List sortMap(HashMap<String,Integer> itemFreq)
	{
		Map<String,Integer> sort_itemFreqs = new TreeMap<String,Integer>(itemFreq);
		List<Map.Entry<String,Integer>> list  = new LinkedList<Map.Entry<String,Integer>>(itemFreq.entrySet());

		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
			public int compare(Map.Entry <String , Integer> o1, Map.Entry < String , Integer> o2)
			{
				return -(o1.getValue().compareTo(o2.getValue()));
			}
		});
				
			return list;
	}
	public void disTransaction()
	{
		System.out.println("\n============  Transaction Sorted =============");
		for(int i=0;i<transaction.size();i++)
		{
			System.out.println(transaction.get(i));			
		}	
	}
	public static void main(String[] args)  throws Exception
	{
		FPData f = new FPData("fpdata.csv");		
		f.sortTransaction();
		f.disTransaction();		
		System.out.println();
	}
}

