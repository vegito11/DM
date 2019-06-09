import java.io.*;
import java.util.*;
class readData
{
	String data="";
	readData(String fname) throws Exception
	{
		String s;
		
		BufferedReader br = new BufferedReader(new FileReader(fname));
		while((s=br.readLine())!=null)
		{
			data+=s.toLowerCase();			
		}	
	}
}