import java.util.*;
import java.io.*;
import static java.lang.System.out; 
class CalInfoGain
{
  public static double calLog(double yes,double no)
  {
  	double entropy;
  	double cnt=yes+no;
  	if(yes==0 || no==0)
  		return 0;
  	double yx= (double)yes/cnt;
  	double nx= (double)no/cnt;
  	
  	entropy = -( (yx)* Math.log(yx)/Math.log(2) ) - ( (nx)* Math.log(nx)/Math.log(2) ) ;
  	//System.out.println("\n entropy = "+entropy);
  	return entropy;
  	//entropy = Math.log(x)/Math.log(2);
  }
  
  public static void Info(ArrayList<String> age,ArrayList<String> result)
  {
  	int cnt=age.size();
  	double cnt30=0,cnt35=0,cnt40=0,yes30=0,no30=0,yes35=0,no35=0,yes40=0,no40=0,Answer=0;
  	for (int i=0;i<cnt;i++) 
  	{
  		String s = age.get(i).toString();
  		
  		if(s.equals("<=30"))				
  		{
  			cnt30++;
  			if((result.get(i).toString().equals("yes")))
  				yes30++;
  			else
  				no30++;
  		}	
  		else if(s.equals("31-40"))				
  		{
  			cnt35++;
  			if(result.get(i).toString().equals("yes"))
  				yes35++;
  			else
  				no35++;
  		}	
  		else if(s.equals(">40"))				
  		{
  			cnt40++;
  			if(result.get(i).toString().equals("yes"))
  				yes40++;
  			else
  				no40++;
  		}	
  	}
  	Answer = ( ( (double)(cnt30/cnt) * calLog(yes30,no30) ) +((cnt35/cnt) * calLog(yes35,no35)) 
            + ( (double)(cnt40/cnt) * calLog(yes40,no40)) );
  	System.out.println("\n Information Gain of Age : "+Answer);
  }

  public static void infoIncome(ArrayList<String> income,ArrayList<String> result)
  {
    int cnt=income.size();
    double cntHigh=0,cntLow=0,cntMedium=0,yesHigh=0,noHigh=0,yesLow=0,noLow=0,yesMedium=0,noMedium=0,Answer=0;
    for (int i=0;i<cnt;i++) 
    {
      String s = income.get(i).toString();
      
      if(s.equals("high"))        
      {
        cntHigh++;
        if((result.get(i).toString().equals("yes")))
          yesHigh++;
        else
          noHigh++;
      } 
      else if(s.equals("low"))        
      {
        cntLow++;
        if(result.get(i).toString().equals("yes"))
          yesLow++;
        else
          noLow++;
      } 
      else if(s.equals("medium"))        
      {
        cntMedium++;
        if(result.get(i).toString().equals("yes"))
          yesMedium++;
        else
          noMedium++;
      } 
    }
    Answer = ( ( (double)(cntHigh/cnt) * calLog(yesHigh,noHigh) ) +((cntLow/cnt) * calLog(yesLow,noLow)) 
            + ( (double)(cntMedium/cnt) * calLog(yesMedium,noMedium)) );
    System.out.println("\n Information Gain of Income : "+Answer);
  }
  public static void infoStudent(ArrayList<String> student,ArrayList<String> result)
  {
    int cnt=student.size();
    double cntYes=0,cntNo=0,yesYes=0,noYes=0,yesNo=0,noNo=0,Answer=0;
    for (int i=0;i<cnt;i++) 
    {
      String s = student.get(i).toString();
      
      if(s.equals("yes"))        
      {
        cntYes++;
        if((result.get(i).toString().equals("yes")))
          yesYes++;
        else
          noYes++;
      } 
      else if(s.equals("no"))        
      {
        cntNo++;
        if(result.get(i).toString().equals("yes"))
          yesNo++;
        else
          noNo++;
      } 
    }
    Answer = (((double)(cntYes/cnt) * calLog(yesYes,noYes) ) +((cntNo/cnt) * calLog(yesNo,noNo))) ;
            
    System.out.println("\n Information Gain of Student : "+Answer);
  }
  public static void infoCreadit(ArrayList<String> creadit_rating,ArrayList<String> result)
  {
    int cnt=creadit_rating.size();
    double cntfair=0,cntExcellent=0,yesfair=0,nofair=0,yesExcellent=0,noExcellent=0,Answer=0;
    for (int i=0;i<cnt;i++) 
    {
      String s = creadit_rating.get(i).toString();
      
      if(s.equals("fair"))        
      {
        cntfair++;
        if((result.get(i).toString().equals("yes")))
          yesfair++;
        else
          nofair++;
      } 
      else if(s.equals("excellent"))        
      {
        cntExcellent++;
        if(result.get(i).toString().equals("yes"))
          yesExcellent++;
        else
          noExcellent++;
      } 
    }
    Answer=(((double)(cntfair/cnt)*calLog(yesfair,nofair))+((cntExcellent/cnt)*calLog(yesExcellent,noExcellent)));
            
    System.out.println("\n Information Gain of Creadit Rating  : "+Answer);
  }
    public static void main(String... args) throws Exception
   {
	   int i=0,cnt=0;
       ArrayList<String> age = new ArrayList<String>();
       ArrayList<String> income = new ArrayList<String>();
       ArrayList<String> student = new ArrayList<String>();
	   ArrayList<String> creadit_rating = new ArrayList<String>();
	   ArrayList<String> result = new ArrayList<String>();
	        
	   String[] records = new String[1000];
	   String line;
       Scanner sr=new Scanner(System.in);
	   BufferedReader br = new BufferedReader(new FileReader("info.csv")) ;
	   while ((line = br.readLine()) != null)
	   {
	        records = line.split(",");
	        if(i==0)
	        {
		     System.out.println(records[0]+"\t\t"+records[1]+"\t\t"+records[2]+"\t\t"+records[3]+"\t\t"+records[4]);
             System.out.print("------------------------------------------------------------------------------\n");
             i++;
            }      
            else
            { 
  			  System.out.println(records[0]+" \t\t "+records[1]+" \t\t "+records[2]+" \t\t "+records[3]+" \t\t "+records[4]);
              age.add(records[0]);
              income.add(records[1]);
              student.add(records[2]);
              creadit_rating.add(records[3]);

              result.add(records[4]);
             cnt++;
            } 
       }
       System.out.print("------------------------------------------------------------------------------\n");
	
     Info(age,result);  
     infoIncome(income,result); 
     infoStudent(student,result); 
	 infoCreadit(creadit_rating,result);	
	 out.println("\n");
   }
}
