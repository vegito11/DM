import java.util.*;
class Calculator
{
	ArrayList<Float> al = new ArrayList<Float>();	
	Calculator()
	{
		al.add(13f);al.add(15f);al.add(16f);al.add(16f);al.add(19f);al.add(20f);al.add(20f);al.add(21f);al.add(22f);
		al.add(22f);al.add(25f);al.add(25f);al.add(25f);al.add(25f);al.add(30f);al.add(33f);al.add(33f);al.add(35f);
		Display(al);	
	}
	public static float Mean(ArrayList<Float> al)
	{
		int n = al.size();
		float sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=al.get(i);
		}	
		return Math.round((sum)/n);
	}
	public static void Display(ArrayList<Float> al)
	{
		int n = al.size();
		Collections.sort(al);
		System.out.print("\n ArrayList Data is :\t");
		for(int i=0;i<n;i++)
		{
			int num = (int)Math.round(al.get(i));
			System.out.print(num+"  ");			
		}	
	
	}
	public static float Mode(ArrayList<Float> al)
	{
		int n = al.size();
		float mode,prev,newN;
		int cnt=0,max=1;
		Collections.sort(al);
		mode = al.get(0);
		newN=mode;
		cnt++;
		for(int i=0;i<n-1;i++)
		{			
			if(newN==al.get(i+1))			
			{
				cnt++;
			}	
			else
			{				
				if(cnt>max)
				{	
					mode=newN;
					max=cnt;
				}	

				cnt=1;
				newN = al.get(i+1);
			}	
		}
		if(cnt>max)	
			mode=newN;

		return mode;
	}
	public static float Median(ArrayList<Float> al)
	{
		int n = al.size();
		float median;
		Collections.sort(al);
		if(n%2==0)
		{
			int i=(n/2);
			median = (al.get(i)+al.get(i))/2;
		}	
		else
		{
			median = al.get((n+1)/2);
		}	
		return median;
	}
	public static float Q1(ArrayList<Float> al)
	{
		int n=al.size();
		int i=(int)(n*0.25);
		return al.get(i);
	}
	public static float Q3(ArrayList<Float> al)
	{
		int n=al.size();
		int i=(int)(n*0.75);
		return al.get(i);
	}

}
class FiveNumSummary
{
	public static void main(String[] args) 
	{		
		Calculator c = new Calculator();
		float mean,median,mode,q1,q3,min,max;
		Scanner sc  = new Scanner(System.in);
		mean   = c.Mean(c.al);
		median = c.Median(c.al);
		mode   = c.Mode(c.al);
		Collections.sort(c.al);
		q1     = c.Q1(c.al);
		q3     = c.Q3(c.al);
		min=c.al.get(0);
		max=c.al.get(c.al.size()-1);
		System.out.print("\n\n ===============================================\n");
		System.out.print("\n Minimum is  : "+min);
		System.out.print("\n Q1 is       : "+q1);
		System.out.print("\n Mode is     : "+mode);
		System.out.print("\n Q3 is       : "+q3);		
		System.out.print("\n Maximum is  : "+max);
		System.out.print("\n\n ===============================================\n");
		System.out.print("\n");
		System.out.print("\n Mean is     : "+mean);
		System.out.print("\n Median is   : "+median);
		System.out.println("\n");	
	}
}