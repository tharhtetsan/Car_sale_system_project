package CarSaleCenter;

import javax.swing.JOptionPane;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddCar extends Application{
static VBox vbox=new VBox();
TextField txtManufacture=new TextField();
TextField txtYear=new TextField();
TextField txtModel=new TextField();
TextField txtPrice=new TextField();
TextField txtKm=new TextField();
TextArea txtAInfo=new TextArea();
static TextField txtid=new TextField();


Button btnReset=new Button("   Reset   ");
Button btnSave=new Button("    Save    ");
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		Label lbm=new Label   ("Manufacturer");
		Label lbYear=new Label("Year ");
		Label lbModel=new Label("Model");
		Label lbPirce=new Label("Price");
		Label lbKm=new Label("Km Travel");
		Label lbExtra=new Label("Extra Information");
		Label lbid=new Label("ID");
		txtAInfo.setPrefSize(300,100);
		
		HBox hbox=new HBox();
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.BASELINE_RIGHT);
		hbox.getChildren().add(btnReset);
		hbox.getChildren().add(btnSave);
		
		txtid.setEditable(false);
		GridPane gpane=new GridPane();
		gpane.setHgap(10);
		gpane.setVgap(10);
		gpane.add(lbid, 0, 0);
		gpane.add(txtid, 1, 0);
		gpane.add(lbm, 0,1);
		gpane.add(txtManufacture, 1,1);
		gpane.add(lbYear, 0,2);
		gpane.add(txtYear, 1,2);
		gpane.add(lbModel, 0,3);
		gpane.add(txtModel, 1,3);
		gpane.add(lbPirce, 0,4);
		gpane.add(txtPrice, 1,4);
		gpane.add(lbKm, 0,5);
		gpane.add(txtKm, 1,5);
		gpane.add(lbExtra, 0, 6);
		gpane.add(txtAInfo, 1, 6);
		gpane.add(hbox, 1, 7);
		
		
		Label lbTitle=new Label("Add Car");
		vbox.getChildren().add(lbTitle);
		vbox.getChildren().add(gpane);
		vbox.setAlignment(Pos.CENTER);
	
		//Design
		lbTitle.setFont(Font.font("Times New Roman",20));
		lbExtra.setFont(Font.font("Arial",14));
		lbKm.setFont(Font.font("Arial",14));
		lbm.setFont(Font.font("Arial",14));
		lbModel.setFont(Font.font("Arial",14));
		lbPirce.setFont(Font.font("Arial",14));
		lbid.setFont(Font.font("Arial",14));
		lbYear.setFont(Font.font("Arial",14));
		btnReset.setFont(Font.font("Arial",14));
		btnSave.setFont(Font.font("Arial",14));
		
		//Action
		btnReset.setOnAction(e->{
			clearData();
		});
		btnSave.setOnAction(e->{
			checkData();
		});
		
	}

public static VBox getAddCar()
{
return vbox;	
}
public AddCar() 
{
	AutoID();
Stage p=new Stage();
start(p);
}
public void checkData()
{

	if(txtYear.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}
	else if(txtModel.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}
	else if(txtManufacture.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}
	else if(txtPrice.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}else if(txtKm.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}
	else if(txtAInfo.getText().equals(""))
	{
		JOptionPane.showMessageDialog(null, "Must be Fill All Data","Error",0);
		
	}
	else {
		SaveRecord();
	}
}
public void clearData()
{
	txtAInfo.setText("");
	txtKm.setText("");
	txtManufacture.setText("");
	txtModel.setText("");
	txtPrice.setText("");
	txtYear.setText("");
}

public void SaveRecord()
{
	SetAndGetData g=new SetAndGetData();
	String str[]=new String[7];
	str[0]=txtid.getText().toString().trim();
	str[1]=txtYear.getText().toString().trim();
	str[2]=txtModel.getText().toString().trim();
	str[3]=txtManufacture.getText().toString().trim();
	str[4]=txtPrice.getText().toString().trim();
	str[5]=txtKm.getText().toString().trim();
	str[6]=txtAInfo.getText().toString().trim();
	g.setData(str);
	JOptionPane.showMessageDialog(null,"Save Sccessfully","Save",1);
	AutoID();
	clearData();
}

public static void AutoID()
{
	try{
	
		SetAndGetData studata=new SetAndGetData();
		int id=0;
		id=studata.getLastID();
		System.out.println(id);
		if(id==0)
		{
			txtid.setText("1");
		}
		else
		{
			txtid.setText(""+(id+1));
		}
			
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
}
