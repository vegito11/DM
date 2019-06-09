class Confidance
{
	public static void calConfidance(ReadItems r)
	{
		String i1,i2;
		float confidance;
		int k;
		for(int i=0;i<r.itemset.size();i++)
		{
			String s[] = r.itemset.get(i).split(" ");
			for (int j=0; j<s.length;j++ ) 
			{
				i1 = s[j];    // Items First...last
				i2="";
				k=(j+1)%s.length;
				//System.out.print(" k = "+k);
				while(k!=j)
				{
					i2=i2+s[k]+" ";
					k=(k+1)%s.length;
					//System.out.print(" k1 = "+k);
				}	
				confidance = (r.calculateSupport(r.itemset.get(i))/r.calculateSupport(i1))*100;
				System.out.println(i1+"  => "+ i2+" \t Confidance  = "+confidance );

				confidance = (r.calculateSupport(r.itemset.get(i))/r.calculateSupport(i2))*100;
				System.out.println(i2+"  => "+ i1+" \t Confidance  = "+confidance );
			}
		}	
	}
	public static void main(String[] args) throws Exception
	{
		ReadItems r = new ReadItems("Itemset.csv");
		System.out.println("\n============================================================================");
		System.out.println("Support :"+r.minsup);
		r.itemSet();		
		System.out.println("\n============================================================================");						
		r.nextItemSet(2);
		System.out.println("\n **************  Frequent ItemSet Is as Follows ************** ");
		r.frequentItems();
		System.out.println("\n============================================================================");		
		calConfidance(r);
		System.out.println();	
	
	}

}

