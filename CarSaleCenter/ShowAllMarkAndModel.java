package CarSaleCenter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class ShowAllMarkAndModel extends Application {
 static Stage sta=new Stage();
  static VBox vbox = new VBox();
    private TableView<Student> table = new TableView<Student>();
   
    private final static ObservableList<Student> data =FXCollections.observableArrayList();
   
    
 
    @Override
    public void start(Stage stage) {
       
       
 
        final Label label = new Label("Show All Model");
 
        table.setEditable(true);
        table.setMinSize(800, 700);
        table.setMaxSize(1300, 800);
      
        TableColumn colid = new TableColumn("   ID   ");
        colid.setMinWidth(100);
        colid.setCellValueFactory(
                new PropertyValueFactory<Student, String>("id"));

        TableColumn colName = new TableColumn("   Year   ");
        colName.setMinWidth(150);
        colName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));


        TableColumn colNrc = new TableColumn("     Model     ");
        colNrc.setMinWidth(150);
        colNrc.setCellValueFactory(
                new PropertyValueFactory<Student, String>("nrc"));


        TableColumn colFName = new TableColumn("    Manufacture   ");
        colFName.setMinWidth(150);
        colFName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("fname"));


        TableColumn colGender = new TableColumn("   Price   ");
        colGender.setMinWidth(100);
        colGender.setCellValueFactory(
                new PropertyValueFactory<Student, String>("gender"));


        TableColumn colBirthday = new TableColumn("    Km Travelled    ");
        colBirthday.setMinWidth(150);
        colBirthday.setCellValueFactory(
                new PropertyValueFactory<Student, String>("birthday"));


        TableColumn colYear = new TableColumn("  Extra Infrmation ");
        colYear.setMinWidth(200);
        colYear.setCellValueFactory(
                new PropertyValueFactory<Student, String>("year"));


        table.setItems(data);
        table.getColumns().addAll(colid,colName,colNrc,colFName,colGender,colBirthday,colYear);
        
        //Add close button
        Button btnClose=new Button("    Close  ");
        FlowPane  fpane=new FlowPane();
        fpane.getChildren().add(btnClose);
        fpane.setAlignment(Pos.CENTER);
        		
        
        
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table,fpane);
        
      
        
        
        btnClose.setOnAction(e->{
        	sta.close();
        });
        //Design
        table.setStyle("-fx-color :greenyellow;");
      
       label.setFont(new Font("Times New Roman", 22));
       btnClose.setFont(new Font("Times New Roman", 18));
       
    }
    public static void FillData() throws FileNotFoundException, IOException
    {
    	data.clear();
    	try{
    	SetAndGetDataForUpdate stuData=new SetAndGetDataForUpdate();
    		String input=stuData.getStudentDataArray();
    		String[] AllStuData=input.split("!");
    		
    		String studentData[][]=new String[AllStuData.length][7];
    		System.out.println(AllStuData.length);
    		for(int i=0;i<AllStuData.length;i++)
    		{
    			String line[]=AllStuData[i].split(",");
    			for(int j=0;j<7;j++)
    			{
    			studentData[i][j]=line[j];
    			}
    		}
    		for(int i=0;i<AllStuData.length;i++)
    		{
    			for(int j=0;j<7;j++)
    			{
    			System.out.print(studentData[i][j]+"\t");
    			}
    			System.out.println();
    		}
    		for(int i=0;i<AllStuData.length;i++)
    		{
    			data.add(new Student(studentData[i][0],studentData[i][1],studentData[i][2],studentData[i][3],studentData[i][4],studentData[i][5],studentData[i][6]));
    		}
    	}catch(Exception e)
    	{
    		System.out.println("No data in StudentDataListing class");
    	}
    	
    }
 
    public static class Student{
 
    	private final SimpleStringProperty name;
    	private final SimpleStringProperty nrc;
    	private final SimpleStringProperty fname;
    	private final SimpleStringProperty gender;
    	private final SimpleStringProperty birthday;
    	private final SimpleStringProperty year;
    	private final SimpleStringProperty id;
    	
    	
        
  Student(String id,String name,String nrc,String fname,String gender,String birthday,String year) {
	  this.id=new SimpleStringProperty(id);
       this.name=new SimpleStringProperty(name);
            this.nrc=new SimpleStringProperty(nrc);
            this.fname=new SimpleStringProperty(fname);
            this.gender=new SimpleStringProperty(gender);
            this.birthday=new SimpleStringProperty(birthday);
            this.year=new SimpleStringProperty(year);
            
  }










public String getBirthday() {
	return birthday.get();
}


public String getId() {
	return id.get();
}



public String getName() {
	return name.get();
}



public String getNrc() {
	return nrc.get();
}

public String getFname() {
	return fname.get();
}



public String getGender() {
	return gender.get();
}



public String getYear() {
	return year.get();
}

 }



	

	public static VBox getShowAllMarkAndModel() throws FileNotFoundException, IOException
	{
		FillData();
		
		return vbox;	
	}
	public ShowAllMarkAndModel()
	{
		start(sta);
	}

}
