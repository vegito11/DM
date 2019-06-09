import java.io.*;
import java.util.*;
class CubeOp
{
	public static void display(String data[][])
	{
		for (int i=0;i<data.length ;i++ ){
			for (int j=0;j<3 ;j++)
			{
				System.out.print(data[i][j]+" \t ");	
			}
			System.out.println();	
			
		}
	}

	public  static void queries(String data[][])
	{
		
		Scanner sc = new Scanner(System.in);
		int opt=0;
		ArrayList<String> al = new ArrayList<String>();
		LinkedHashSet<String> output = new LinkedHashSet<String>();
		System.out.println("\n ========================    Operations ======================================");
		System.out.println("\t\t 1) Enter city to find the State ");
		System.out.println("\t\t 2) Enter state to find the Country ");
		System.out.print("\t Enter your Choice : ");
		opt=sc.nextInt();
		if(opt==1)
		{
			System.out.print("Enter the number of inputs:");
			int s=sc.nextInt();
			for(int i=0;i<s;i++)
			{
				System.out.print("\n Input "+i+" : ");
				String inp=sc.next();
				al.add(inp);
			}
			while(al.size()!=0)
			{
				for (int i=0;i<data.length ;i++ )
				{

					if(data[i][2].equals(al.get(0)))
					{
						
						output.add(data[i][1]);
						
			
						
					}

				}
				al.remove(0);	
			}
		}	
		else if(opt==2)
		{
			System.out.print("Enter the number of inputs: ");
			int s=sc.nextInt();
			for(int i=0;i<s;i++)
			{
				System.out.print("\n Input "+i+" : ");
				String inp=sc.next();
				al.add(inp);
			}

			while(al.size()!=0)
			{
				for (int i=0;i<data.length ;i++ )
				{
					if(data[i][1].equals(al.get(0)))
					{	output.add(data[i][0]);
						
					}

				}
				al.remove(0);	
			}

		}
		System.out.println(output);

	}
	public static void main(String[] args) {
		String csv_file="cubeD.csv";
		BufferedReader br=null;
		String line="";
		String data[][]=new String[11][3];
		Scanner sc=new Scanner(System.in);
		try
		{
			br=new BufferedReader(new FileReader(csv_file));
			int n=0;
			int p=0;
			while((line=br.readLine())!=null)
			{
				p=0;
				String ar[]=line.split(",");
				for(String x: ar)
				{
					
					data[n][p]=x;
					p++;
				}
				n++;
				
			}
		}


		catch(Exception e)
		{
			System.out.println(e);
		}
		int opt=0;

		while(true)
		{
			System.out.print("\n ************ MENU ************");
			System.out.print("\n\t\t 1) Display Data  \n\t\t 2) Do Operation \n\t\t 3) Exit ");
			System.out.print("\t\t Enter your choice : ");
			opt = sc.nextInt();
			if(opt>2)
				break;
			switch(opt)
			{
				case 1 :	
						display(data);
						break;
				case 2 :	
						queries(data);
						break;
				default:
						System.out.println(" \n !!!Please Enter the Valid Choice !!!!");
						break;		

			}
		}	
	}
}