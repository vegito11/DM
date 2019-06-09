import java.util.*;
class Data
{
	int binsize=3;
	ArrayList<Integer> al = new ArrayList<Integer>();
	Scanner sc  = new Scanner(System.in);
	Data()
	{
		al.add(13);al.add(15);al.add(16);al.add(16);al.add(19);al.add(20);al.add(20);al.add(21);al.add(22);
		al.add(22);al.add(25);al.add(25);al.add(30);al.add(33);al.add(33);al.add(35);
		al.add(35);al.add(36);al.add(40);al.add(45);al.add(46);al.add(52);
		al.add(70);
	}
	public void add()
	{
		int num;
		System.out.print("\n Enter the Number :");
		num = sc.nextInt();		
		al.add(num);
	}
	public void setBinsize()
	{
		System.out.print("\n Enter the Bin Size :");
		binsize = sc.nextInt();
	}
	public void display()
	{
		System.out.print(" Data is : ");
		int cnt=0;
		for (int d : al) 
		{
			if(cnt%binsize==0 && cnt!=0)
				System.out.print("\t");
			System.out.print(d+"  ");
			cnt++;	
		}
	}
	public void showMeanBinning(int mean[])
	{
		int size = mean.length;
		int itr,j=-1;
		for(int i=0;i<al.size();)
		{
			j++;
			if(j>=size)
				break;
			for(itr=0;itr<binsize;itr++)	
			{
				al.set(i,mean[j]);

				i++;
				if(i>=al.size())
				{
					itr+=1;
					break;
				}	
			}
		}	
	}
	public void showMedianBinning(int mean[])
	{
		int size = mean.length;
		int itr,j=-1;
		for(int i=0;i<al.size();)
		{
			j++;
			if(j>=size)
				break;
			for(itr=0;itr<binsize;itr++)	
			{
				al.set(i,mean[j]);

				i++;
				if(i>=al.size())
				{
					itr+=1;
					break;
				}	
			}
		}	
	}

}
class Binning
{
	public static void calculation(Data d)
	{
		int ch;
		Scanner sc  = new Scanner(System.in);
		while(true)
		{
			System.out.print("\n ************ MENU ************");
			System.out.print("\n 1) Add Number \n 2) Set Bin size \n 3) do Binning \n 4) Display Data ");
			System.out.print("\t\t Enter your choice : ");
			ch = sc.nextInt();
			if(ch>4)
				break;
			switch(ch)
			{
				case 1 :	
						d.add();
						break;
				case 2 :	
						d.setBinsize();
						break;
				case 3 :	
						binning(d);
						break;
				default:
						d.display();
						break;		

			}
			
		}	

	}
	public static void binning(Data d)
	{
		int ch,n,itr=0,size=d.al.size(),bin=d.binsize;
		int sum=0;
		double m = Math.ceil(size/(float)bin);
		n = (int)m;
		Scanner sc  = new Scanner(System.in);
		while(true)
		{
			System.out.print("\n ************ Binning ************");
			System.out.print("\n\t\t 1) Binning by mean \n\t\t 2) Binning by median\n\t\t 3) Binning by Boundary \n\t\t 4) Exit");
			System.out.print("\t\t Enter your choice : ");
			ch = sc.nextInt();
			Collections.sort(d.al);
			if(ch>3)
				break;
			switch(ch)
			{
				case 1 :	/* Binning by Mean */
						int mean[] = new int[n];
						int j=-1;
						for(int i=0;i<size;)
						{
							j++;sum=0;							
							for(itr=0;itr<bin;itr++)	
							{
								sum+=d.al.get(i);
								//System.out.print(sum+" ");
								i++;
								if(i>=size)
								{
									itr+=1;
									break;
								}	
							}	
							mean[j]=sum/itr;														
						}
						/*
						System.out.print("\n\t Means are : ");
						for(int i=0; i<n; i++) 
						{
								System.out.print(mean[i]+" ");
						}
						*/
						d.showMeanBinning(mean);
						d.display();
						break;
				case 2 :	/* Binning by Median */
						int median[] = new int[n];
						j=-1;
						for(int i=0;i<size;)
						{
							j++;sum=0;							
							if(j<=n-2)
							for(itr=0;itr<bin;itr++)	
							{
								if(bin%2!=0)	
								{
									if(itr==((bin-1)/2))
										median[j]=d.al.get(i);
									i++;	
								}	
								else
								{
									if(itr==((bin-1)/2))
										median[j]=d.al.get(i);
									i++;	

								}	
							}	
							else
							{
								int c = size-i;
								for(itr=0;itr<c;itr++)		
								{
									if(c/2==itr)		
										median[j]=d.al.get(i);	
									i++;
								}	
							}	
						}
						d.showMeanBinning(median);
						d.display();

						break;
				case 3 :	/* Binning by Boundary */
						int max,min,repl;						
						j=-1;
						for(int i=0;i<size;)
						{
							j++;
							if(j<=n-2)
							{	
								max = d.al.get(i+bin-1);
								min = d.al.get(i);							
									
								for(itr=0;itr<bin;itr++)	
								{
									
									repl = Math.abs(min-d.al.get(i));
									//System.out.println(repl);
									if(repl>Math.abs(max-d.al.get(i)))
									{	
										repl = max;
										//System.out.println("max = "+repl);
									}	
									else 
										repl = min;
									d.al.set(i,repl);
									i++;
								}
							}	
							else
							{
								max = d.al.get(size-1);
								min = d.al.get(i);							
								for(itr=0;i<size;itr++)	
								{
									
									repl = Math.abs(min-d.al.get(i));
									//System.out.println(repl);
									if(repl>Math.abs(max-d.al.get(i)))
									{	
										repl = max;
										//System.out.println("max = "+repl);
									}	
									else 
										repl = min;
									d.al.set(i,repl);
									i++;
								}
							}														
						}
						d.display();
						break;
				default:
						break;		

			}
			
		}	
	}

	public static void main(String[] args) 
	{
		Scanner sc  = new Scanner(System.in);
		Data d = new Data();
		calculation(d);
		System.out.print("\n");
	}
}