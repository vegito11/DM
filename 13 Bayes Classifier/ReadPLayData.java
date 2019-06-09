import java.io.*;
import java.util.*;
class ReadPLayData
{
	/*
		Each ArrayList Will Contain the hashMap of Each Attribute
		Each HashMap Will Have Attriubte type like Hot,Mild,Cool String
		and It's Value Count in ArrayList like YES:3,NO: 5
	*/
	ArrayList<HashMap<String,ArrayList<Integer>>> attributFreq=new ArrayList<HashMap<String,ArrayList<Integer>>>();
	ArrayList<String> target = new ArrayList<String>();
	ArrayList<Integer> trgcnt = new ArrayList<Integer>();
	ArrayList<Float> trgprob = new ArrayList<Float>();
	String attributes;
	int columns,total_row;
	/*  Here Columns are n+1 bcz first colums is sr No */
	ReadPLayData(String fname) throws Exception
	{
		BufferedReader bf  = new BufferedReader(new FileReader(fname));
		String line;
		int ind,cnt=-1,freq;
		findTarget(bf);
		bf.close();
		bf  = new BufferedReader(new FileReader(fname));
		System.out.print(" \ntarget : "+target);
		System.out.println(" \n target  Count : "+trgcnt);
		CalTargetProbability();
		//System.out.println(" \n target  Probability : "+trgprob);
		System.out.println(" \n Attriubtes : "+attributes);
		while((line = bf.readLine())!=null)
		{
			String sp[] = line.split(",");
			String trgVal = sp[columns-1].toLowerCase();
			cnt++;
			if(cnt==0)
				continue;
			else if(cnt==1)
			{
				for(int i=1;i<sp.length-1;i++)
				{	
					ArrayList<Integer> al = new ArrayList<Integer>();
					HashMap<String,ArrayList<Integer>> h= new HashMap<String,ArrayList<Integer>>();
					for(int m=0;m<target.size();m++)
					{
						al.add(0);
					}	
					al.set(1,0);
					h.put(sp[i].toLowerCase(),al);
					/*
							New HAshMap Added Here
					*/
					attributFreq.add(h);
					
				}	

			}	

			/* For each Attribute Value*/
			for(int i=1;i<sp.length-1;i++)
			{
											
				/*  TMP Here is Attribute type like HOT or COOL*/
				String tmp = sp[i].toLowerCase().trim();
				//System.out.println(" i : "+i+"  "+attributFreq.size());
				HashMap<String,ArrayList<Integer>> h = attributFreq.get(i-1);
				
				/*  
						already contain that attribute
						Rainy NO
				*/
				if(h.containsKey(tmp))
				{
					ArrayList<Integer> al = h.get(tmp);					
					ind = target.indexOf(trgVal);	
					//System.out.println(al);
					//System.out.println(line);
					//System.out.println(" target : "+al.size()+" ind = "+ind+" cnt :"+cnt+" "+tmp);
					freq = al.get(ind)+1;
					al.set(ind,freq);
					h.put(tmp,al);
					attributFreq.set(i-1,h);
				}



				/*  If already not contain that type */
				else
				{
					
					ArrayList<Integer> al =  new ArrayList<Integer>();
					for(int k=0;k<target.size();k++)
					{
						al.add(0);
					}	
					ind = target.indexOf(trgVal);	
					freq = al.get(ind)+1;
					al.set(ind,freq);

					h.put(tmp,al);
					attributFreq.set(i-1,h);
				}					
			}
		}
		displayAttribute();
		calAtrProb(0,"rainy",1);
	}
	public float calAtrProb(int col,String s,int trgcol)
	{
		HashMap<String,ArrayList<Integer>> h = attributFreq.get(col);		
		ArrayList<Integer> atr = h.get(s);
		if(atr==null)
			return -1;
		float prob;
		float cnt,tot;
		tot = trgcnt.get(trgcol);
		cnt = atr.get(trgcol);
		prob = cnt/tot;
		//System.out.println(cnt+" / "+tot);		
		//System.out.print("------------------------------------------------------------------");
		//System.out.println("-------------------------------------------------------------------");
		//System.out.println("\n");	
		return prob;
	}
	public void CalTargetProbability()
	{
		for(int i=0;i<trgcnt.size();i++)
		{
			trgprob.add(trgcnt.get(i)/(float)total_row);
		}		
	}
	public void displayAttribute()
	{
		for(int i=0;i<attributFreq.size();i++)
		{
			HashMap<String,ArrayList<Integer>> h = attributFreq.get(i);
			Set  key = h.keySet();
			Iterator itr = key.iterator();
			while(itr.hasNext())
			{
				String s = (String)itr.next();
				System.out.print("\n Type : "+s+" \t\t Counts : "+h.get(s));				
			}
			System.out.println(" ");	
		}	
	}
	public void findTarget(BufferedReader bf) throws Exception
	{
		String line,trg;
		int cnt=-1;
		while((line = bf.readLine())!=null)
		{
			String sp[] = line.split(",");
			columns = sp.length;
			trg = sp[columns-1].toLowerCase().trim();
			cnt++;

			if(cnt==0)
			{
				attributes  = line.toLowerCase().trim();
				continue;
			}	
			
			if(!target.contains(trg))
			{
				target.add(trg);
				trgcnt.add(1);
			}	
			else
			{
				int ind =  target.indexOf(trg);
				trgcnt.set(ind,trgcnt.get(ind)+1);	

			}	
			
		}
		total_row = cnt;
	}

}