package CarSaleCenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetAndGetDataForUpdate {
	public void setStudentDataArray(String [][]stuData) throws FileNotFoundException, IOException
	{
		try(DataOutputStream output=new DataOutputStream(new FileOutputStream("D:/Car.dat"));)
		{
			for(int i=0;i<stuData.length;i++)
			{
				for(int j=0;j<7;j++)
				{
				output.writeUTF(stuData[i][j]);
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Fail in DataoutStream of GetAndSetSudentData Class");
		}
		
	}


	public static String getStudentDataArray() throws FileNotFoundException, IOException
	{
		
		String str="";
		try(DataInputStream input=new DataInputStream(new FileInputStream("D:/Car.dat")))
		{
			
			while(true)
			{
				for(int j=0;j<7;j++)
				{
					str+=input.readUTF()+",";
				}
				str=str+"!";
			}
			
			}
		catch(Exception e)
		{
			System.out.println("1end file error");
		}
		
		return str;
	}
}
