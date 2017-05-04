package CarSaleCenter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchOnAge extends Application{
static boolean isFound=false;
static VBox vbox=new VBox();
static TextField txtid=new TextField();

static TextField txtManufacture=new TextField();
static TextField txtYear=new TextField();
static TextField txtModel=new TextField();
static TextField txtPrice=new TextField();
static TextField txtKm=new TextField();
static TextArea txtAInfo=new TextArea();
static ComboBox cboid=new ComboBox();
Button btnSearch=new Button(" Search  ");
Button btnReset=new Button("  Reset  ");

@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		//ForFound
		Label lbm=new Label   ("Manufacturer");
		Label lbYear=new Label("Year ");
		Label lbModel=new Label("Model");
		Label lbPirce=new Label("Price");
		Label lbKm=new Label("Km Travel");
		Label lbExtra=new Label("Extra Information");
		Label lbid=new Label("ID");
		
		txtAInfo.setPrefSize(300,100);
		
		
		
		GridPane gpane=new GridPane();
		gpane.setHgap(10);
		gpane.setVgap(10);
		gpane.add(lbm, 0,0);
		gpane.add(txtManufacture, 1,0);
		gpane.add(lbYear, 0,1);
		gpane.add(txtYear, 1,1);
		gpane.add(lbModel, 0,2);
		gpane.add(txtModel, 1,2);
		gpane.add(lbPirce, 0,3);
		gpane.add(txtPrice, 1,3);
		gpane.add(lbKm, 0,4);
		gpane.add(txtKm, 1,4);
		gpane.add(lbExtra, 0, 5);
		gpane.add(txtAInfo, 1, 5);
		
		
		
		
		
		cboid.setValue("");
		Label lbCarAge=new Label(" Car Age ");
		
		
		HBox hboxcbo=new HBox();
		hboxcbo.setSpacing(10);
		hboxcbo.getChildren().add(lbCarAge);
		hboxcbo.getChildren().add(cboid);
		
		HBox hboxbtn=new HBox();
		hboxbtn.setSpacing(15);
		hboxbtn.getChildren().add(btnSearch);
		hboxbtn.getChildren().add(btnReset);
		
		VBox vboxTop=new VBox();
		vboxTop.setSpacing(15);
		vboxTop.getChildren().add(hboxcbo);
		vboxTop.getChildren().add(hboxbtn);
		
		//Set for Editable
		txtManufacture.setEditable(false);
		txtModel.setEditable(false);
		txtPrice.setEditable(false);
		txtYear.setEditable(false);
		txtAInfo.setEditable(false);
		txtKm.setEditable(false);
		
		
		
		
		
		
		
		
		
		FlowPane fpaneForFound=new FlowPane();
		fpaneForFound.setAlignment(Pos.CENTER);
		
		
		//add Vbox
		Label lbTitle=new Label("Serach On Age");
		vbox.setSpacing(20);
		vbox.getChildren().add(lbTitle);
		vbox.getChildren().add(vboxTop);
		vbox.getChildren().add(fpaneForFound);
		vbox.setAlignment(Pos.CENTER);
		
		//Design 
		lbCarAge.setFont(Font.font("Arial",16));
		lbTitle.setFont(Font.font("Times New Roman",20));
		lbExtra.setFont(Font.font("Arial",14));
		lbKm.setFont(Font.font("Arial",14));
		lbm.setFont(Font.font("Arial",14));
		lbModel.setFont(Font.font("Arial",14));
		lbPirce.setFont(Font.font("Arial",14));
		lbYear.setFont(Font.font("Arial",14));
		lbid.setFont(Font.font("Arial",14));
		btnReset.setFont(Font.font("Arial",14));
		
		btnSearch.setFont(Font.font("Arial",14));
		//Actions
		btnReset.setOnAction(e->{
			clearData();
			fpaneForFound.getChildren().clear();
		});
		btnSearch.setOnAction(e->{
						{
				
				FillData(cboid.getSelectionModel().getSelectedItem().toString().trim());
				isFound=true;
				}
			
			if(isFound)
			{
				fpaneForFound.getChildren().clear();
				fpaneForFound.getChildren().add(gpane);
			
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Sorry ,no each of reslult were return ", "Searych Fail", 2);
			}
			
		});
		
		
		
		
	}

	
	public static VBox getSerchOnAge()
	{
		clearData();
	return vbox;	
	}
	public SearchOnAge()
	{
		SetAndGetData g=new SetAndGetData();
		
		FillID();
		Stage p=new Stage();
		start(p);
	}
	public void FillID()
	{
		SetAndGetData g=new SetAndGetData();
		int id=g.getLastID();
		cboid.getItems().clear();
		int i=1;
		while(i<=id)
		{
			cboid.getItems().add(i+"");
			i++;
		}
	}
	public void FillData(String id)
	{
		SetAndGetData g=new SetAndGetData();
		String str[]=g.SearchID(id).split(",");
		txtid.setText(str[0]);
		txtYear.setText(str[1]);
		txtModel.setText(str[2]);
		txtManufacture.setText(str[3]);
		txtPrice.setText(str[4]);
		txtKm.setText(str[5]);
		txtAInfo.setText(str[6]);
		
	}
	public static void clearData()
	{
		txtid.setText("");
		txtYear.setText("");
		txtModel.setText("");
		txtManufacture.setText("");
		txtPrice.setText("");
		txtKm.setText("");
		txtAInfo.setText("");
		cboid.setValue("");
		isFound=false;
		
	}
}
