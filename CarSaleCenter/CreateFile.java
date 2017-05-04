package CarSaleCenter;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class CreateFile {
public static void main(String[] args) {
	try(DataOutputStream stufile=new DataOutputStream(new FileOutputStream("D:/Car.dat"));)
	{
		System.out.println("Student Data file have been created ");
	}catch(Exception e)
	{
		System.out.println("Fail in Creating Student data file ");
	}
}
}
