package CarSaleCenter;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;

public class GetAdnSetData {
	public String getData()
	{
		String stuData="";
		try(DataInputStream input=new DataInputStream(new FileInputStream("D:/StudentData.dat"));)
		{
			for(int i=0;i<6;i++)
			{
				stuData+=input.readUTF()+",";
			}
			input.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Fail in DataInputStream of GetAndSetSutdentData class");
		}
		
		return stuData;
		
	}
	
	public void setStudentData(String []stuData) throws FileNotFoundException, IOException
	{
		try(DataOutputStream output=new DataOutputStream(new FileOutputStream("D:/StudentData.dat",true));)
		{
			for(int i=0;i<10;i++)
			{
				output.writeUTF(stuData[i]);
			}
			output.close();
		}
		catch(Exception e)
		{
			System.out.println("Fail in DataoutStream of GetAndSetSudentData Class");
		}
		
		
	}
	
	
	
	
	public int getLastID()
	{
		int id=0;
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/StudentData.dat"));)
		{
			while(true)
			{	id=Integer.parseInt(in.readUTF());
				String str="";
			
			}
			
		}
		catch(Exception e)
		{
			System.out.println("end file for last ID");
			
		}
		return id;
	}
	
	
	public boolean isAlradyExist(String nrc)
	{
		boolean isExist=false;
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/StudentData.dat"));)
		{
			while(true)
			{	
				in.readUTF();
				in.readUTF();
				if(nrc.equals(in.readUTF()))
				{
					isExist=true;
					return isExist;
				}
				in.readUTF();
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
			System.out.println("end file for already exits");
		}
		
		return isExist;
	}
	
	public String SearchID(String id)
	{
		boolean isExist=false;
		String stuData="";
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/StudentData.dat"));)
		{
			while(true)
			{	
				
				if(id.equals(in.readUTF()))
				{
					isExist=true;
					stuData=id+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+","+in.readUTF()+",";
				}
				in.readUTF();
				in.readUTF();
				in.readUTF();
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
	
	
	public String SearchNRC(String nrc)
	{
		boolean isExist=false;
		String stuData="";
		String stuDataReturn="";
		try(DataInputStream in=new DataInputStream(new FileInputStream("D:/StudentData.dat"));)
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
