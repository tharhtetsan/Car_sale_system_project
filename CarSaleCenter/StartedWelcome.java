package CarSaleCenter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartedWelcome extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Image im=new Image("ProjectImage/1.png");
		ImageView imv=new ImageView(im);
		imv.setFitHeight(200);
		imv.setFitWidth(300);
		FlowPane fpaneTitle=new FlowPane();
		Label lbTitle=new Label("\t\t\t\t\t\t\tCar Scale Center");
		fpaneTitle.getChildren().add(lbTitle);
		fpaneTitle.setAlignment(Pos.CENTER);
		
		
		//Add Top 
		HBox hboxTop=new HBox();
		hboxTop.getChildren().addAll(imv,fpaneTitle);
		
		//Add Button
		String functions[]={"Welcome","Add a Car","Show All marks and models","Search on ID","Search on Model"};
		ListView lv=new ListView<>(FXCollections.observableArrayList(functions));
		
		FlowPane fpaneFunction=new FlowPane();
		welcome wel=new welcome();
		AddCar addCar=new AddCar();
		SearchOnAge searchOnAge=new SearchOnAge();
		SearchOnModel searchOnModel=new SearchOnModel();
		ShowAllMarkAndModel show=new ShowAllMarkAndModel();
		
		
		fpaneFunction.getChildren().add(wel.getWelcome());
		HBox hboxeButton=new HBox();
		hboxeButton.setSpacing(20);
		hboxeButton.getChildren().add(lv);
		hboxeButton.getChildren().add(fpaneFunction);
		lv.getSelectionModel().selectedItemProperty().addListener(ov->{
			
			fpaneFunction.getChildren().clear();
			if(lv.getSelectionModel().getSelectedIndex()==0)
			{ 
				fpaneFunction.getChildren().add(wel.getWelcome());
			}
			if(lv.getSelectionModel().getSelectedIndex()==1)
			{ 
				
				fpaneFunction.getChildren().add(addCar.getAddCar());
			}
			if(lv.getSelectionModel().getSelectedIndex()==2)
			{ 
				
				try {
					fpaneFunction.getChildren().add(show.getShowAllMarkAndModel());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(lv.getSelectionModel().getSelectedIndex()==3)
			{
				fpaneFunction.getChildren().add(searchOnAge.getSerchOnAge());
			}
			if(lv.getSelectionModel().getSelectedIndex()==4)
			{
				fpaneFunction.getChildren().add(searchOnModel.getSerchOnModel());
			}
			
			
			
		});
		
		
		
		VBox vboxAll=new VBox();
		vboxAll.getChildren().add(hboxTop);
		vboxAll.getChildren().add(hboxeButton);
		
		
		
		Scene scene=new Scene(vboxAll);
		primaryStage.setTitle("Car Sale System");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		//Desing 
		lbTitle.setFont(Font.font("Monotype Corsiva", 30));
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
