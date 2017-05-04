package CarSaleCenter;
import java.io.*;
public class SetAndGetData {

 public String getData()
 {
	 String str="";
	 try(DataInputStream input=new DataInputStream(new FileInputStream("D:/Car.dat"));)
		{
			for(int i=0;i<6;i++)
			{
				str+=input.readUTF()+",";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 return str;
 }
 
 public void setData(String str[])
 {
	 
	 try(DataOutputStream out=new DataOutputStream(new FileOutputStream("D:/Car.dat",true));)
		{
		 for(int i=0;i<str.length;i++)
		 {
			 out.writeUTF(str[i]);
		 }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	 
 }
 
 public String getModel()
	{
		String str="";
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/Car.dat"));)
		{
			while(true)
			{	
				in.readUTF();
				in.readUTF();
				str+=in.readUTF()+",";
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("end file for last ID");
			
		}
		return str;
	}
 
 
 public String SearchID(String id)
	{
		boolean isExist=false;
		String stuData="";
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/Car.dat"));)
		{
			while(true)
			{	
				
				if(id.equals(in.readUTF()))
				{
					isExist=true;
					stuData=id+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+",";
				}
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("end file for search ID");
		}
		
		return stuData;
	}
 
 
 public int getLastID()
	{
		int id=0;
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/Car.dat"));)
		{
			while(true)
			{	id=Integer.parseInt(in.readUTF());
				String str="";
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				in.readUTF();
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("end file for last ID");
			
		}
		return id;
	}
	
 public String SearchModel(String nrc)
	{
		boolean isExist=false;
		String stuData="";
		String stuDataReturn="";
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/Car.dat"));)
		{
			while(true)
			{	
				stuData+=in.readUTF()+",";
				stuData+=in.readUTF()+",";
				String Nrc=in.readUTF();
				if(nrc.equals(Nrc))
				{
					stuData+=Nrc+",";
					isExist=true;
				}
				stuData+=in.readUTF()+",";
				stuData+=in.readUTF()+",";
				stuData+=in.readUTF()+",";
				stuData+=in.readUTF()+",";
				
				
				if(isExist)
				{
					stuDataReturn=stuData;
					isExist=false;
				}
				else{
					stuData="";
						
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("end file for search nrc");
		}
		
		return stuDataReturn;
	}
 
}
