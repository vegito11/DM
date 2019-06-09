class FrequentItems
{
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
		//System.out.println(r.itemset);
		//r.test();
		System.out.println();	
	
	}

}