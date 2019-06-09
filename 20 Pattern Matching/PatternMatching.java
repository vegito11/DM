import java.io.*;
import java.util.*;
	
class PatternMatching
{

	public static void textMinning(String data)
	{
		int ch,i,pos,count;
		String s;
		StringBuilder sb ;
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" \n\n=============  Choose Operation  =================");
			System.out.print("\n\t\t 1) Check Pattern Present Or NOT ");
			System.out.print("\n\t\t 2) Check Palindrome Present Or NOT ");
			System.out.print("\n\t\t 3) Check Number of time String is Present ");
			System.out.print("\n\t\t 4) Exit ");

			System.out.print("\t\t Enter your Choice : ");
			//System.out.println(data);
			ch = sc.nextInt();
			sc.nextLine();
			if(ch>3)
				break;
			switch(ch)	
			{
				case 1:
						System.out.print("\n Enter the Pattern To be Matched : ");
						s = sc.nextLine();
						s.toLowerCase();	
						if(data.indexOf(s)!=-1)
						{
							i = data.indexOf(s);
							System.out.println(" Pattern is at "+ i+" index in Data ");
						}	
						else
						{
							System.out.println(" !!!! Pattern Not Found In Given Data !!");
						}	

						break;	
				case 2:
						System.out.print("\n Enter the Pattern To be Matched : ");
						s = sc.nextLine();
						sb = new StringBuilder(s);
						s = sb.reverse().toString(	);
						if(data.indexOf(s)!=-1)
						{
							i = data.indexOf(s);
							//System.out.println(" Pattern is at "+ i+" index in Data ");
							System.out.println(" Pattern is present in Document ");
						}	
						else
						{
							System.out.println(" !!!! Pattern Not Found In Given Data !!");
						}	

						break;	
				case 3:
						count =0;
						System.out.print("\n Enter the Pattern To be Matched : ");
						int flg=0;
						pos=0;
						s = sc.nextLine();
						while(pos<data.length())
						{
							//System.out.println(" Pos : "+data.indexOf(s,(pos+1)));
							if(( pos = data.indexOf(s,(pos+1)) ) != -1)
							{								
								if(flg!=1)
									System.out.print(" \n Pattern is at : ");	
								System.out.print(pos+" ");
								flg=1;
								cnt++;
							}
							else
								break;	
	
						}	
						if(flg==1)
							break;
						else
						{
							System.out.println(" !!!! Pattern Not Found In Given Data !!");
						}	
						
						break;	
				case 4:
						break;	
			}

		}	
	}

	public static void main(String[] args) throws Exception 
	{
		readData r  = new readData("Information.txt");
		Scanner sc = new Scanner(System.in);
		textMinning(r.data);
	
	}
}