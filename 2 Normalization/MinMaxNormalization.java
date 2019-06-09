import java.util.*;
class MinMaxNormalization
{
	public static void display(ArrayList<Float> al)
	{
		int i=0;
		for (float d : al ) 
		{
			System.out.print(d+"  ");	
			i++;
			if(i%10==0)
				System.out.print("\n\t\t\t ");

		}
	}

	public static void main(String[] args) 
	{
		long newMax,newMin;
		ArrayList <Float> al = new ArrayList <Float>();
		float max,min,value;
		Scanner sc = new Scanner(System.in);
		
		al.add(56000f);al.add(345613f);al.add(560340f);al.add(3456f);al.add(83450f);al.add(33413f);al.add(892421f);
		al.add(34981f);al.add(986712f);al.add(74685f);al.add(567110f);al.add(450912f);al.add(123442f);al.add(494212f);

		Collections.sort(al);
		System.out.print("\n Before Normallization : ");
		display(al);
		max = al.get(al.size()-1);
		min = al.get(0);


		System.out.print("\n\n\t\t\t =========  Enter the new Range ============ ");
		System.out.print("\n\n\t\t\t Enter the Starting Point : ");
		newMax = sc.nextLong();
		System.out.print("\n\n\t\t\t Enter the Ending Point   : ");
		newMin = sc.nextLong();
		System.out.print("\n\n\t\t\t =========================================== ");

		for(int i=0;i<al.size();i++)
		{

			value = al.get(i);

			value = ( ( value - min ) / ( max - min )  )  *( newMax - newMin ) + newMin ;
			value = Math.round(value*100.0);
			value = value/100;
			al.set(i,value);			
		}	
		System.out.print("\n\n After Normallization : ");
		display(al);
		System.out.print("\n\n\t\t\t =========================================== ");
		System.out.print("\n\n\n");
	}
}