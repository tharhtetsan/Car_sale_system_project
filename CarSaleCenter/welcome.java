package CarSaleCenter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class welcome extends Application{
static VBox vbox=new VBox();
	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		
	Label lbTotalCar=new Label("Total number of cars  :");
	
	Label lbVersion=new Label("Version 1.0");
	Line lie=new Line(0,0,150,0);
	Label lbD=new Label("About Developers",lie);
	lbD.setContentDisplay(ContentDisplay.BOTTOM);
	Label lbtr=new Label("Supervise by -");
	Label lbtr1=new Label("Daw Khin Soe Moe Kyaw");
	Label lbl=new Label("Leader      -");
	Label lbl1=new Label("Mg Nan Win Soe");
	Label lbm=new Label ("Memebers     -");
	Label lbm1=new Label("Mg Thu Ka Min Soe");
	Label lbm2=new Label("Mg June Ko Win");
	Label lbm3=new Label("Mg Myo Myint Ko");
	Label lbm4=new Label("Mg Kyaw Ye Zaw");
	
	GridPane gpane=new GridPane();
	gpane.add(lbtr, 0,0 );
	gpane.add(lbtr1, 1, 0);
	gpane.add(lbl, 0, 1);
	gpane.add(lbl1, 1, 1);
	gpane.add(lbm, 0, 2);
	gpane.add(lbm1, 1, 2);
	gpane.add(lbm2, 1, 3);
	gpane.add(lbm3, 1, 4);
	gpane.add(lbm4, 1, 5);
	
	VBox vboxDe=new VBox();
	vboxDe.setSpacing(10);
	vboxDe.getChildren().add(lbD);
	vboxDe.getChildren().add(gpane);
	
	
	VBox vboxAbout=new VBox();
	vboxAbout.setSpacing(30);
	vboxAbout.getChildren().add(lbTotalCar);
	
	vboxAbout.getChildren().add(lbVersion);

	Label lbwe=new Label("\t\t\t\t\t\t\t\t\t\tWelcome to the Car Seales System ");
	vbox.setAlignment(Pos.CENTER);
	vbox.setSpacing(30);
	vbox.getChildren().add(lbwe);
	vbox.getChildren().add(vboxAbout);
	vbox.getChildren().add(vboxDe);
	
	
	
	//Design 
	lbwe.setFont(Font.font("Times New Roman",18));
	
	lbTotalCar.setFont(Font.font("Arial",16));
	lbVersion.setFont(Font.font("Arial",16));
	lbD.setFont(Font.font("Arial",16));
	lbtr.setFont(Font.font("Arial",14));
	lbtr1.setFont(Font.font("Arial",14));
	lbl.setFont(Font.font("Arial",14));
	lbl1.setFont(Font.font("Arial",14));
	lbm.setFont(Font.font("Arial",14));
	lbm1.setFont(Font.font("Arial",14));
	lbm2.setFont(Font.font("Arial",14));
	lbm3.setFont(Font.font("Arial",14));
	lbm4.setFont(Font.font("Arial",14));
	}
	
	public static VBox getWelcome()
	{
		
		return vbox;
	}
	public welcome()
	{
		Stage p=new Stage();
		start(p);
	}
}
