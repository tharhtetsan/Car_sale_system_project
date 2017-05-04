package CarSaleCenter;

import java.io.*;
import javax.imageio.stream.FileImageInputStream;

public class ResetPassword {
public static void main(String[] args) {
	try(DataOutputStream out=new DataOutputStream(new FileOutputStream("D:/CarSaleData.dat"));)
	{
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	try(DataInputStream input=new DataInputStream(new FileInputStream("D:/CarSaleData.dat"));)
	{
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
