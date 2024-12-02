package gui.guiStaedtischeEinrichtungen;

import java.awt.Button;
import java.awt.Font;
import java.awt.TextArea;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import business.MoebelnModel;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class WarenuebersichtView implements Observer {
	private WarenuebersichtControl
 	warenuebersichtControl;

	private MoebelnModel moebelModel;		
	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeige   	 	    	= new Label("Anzeige");
	private TextArea txtAnzeige  = new TextArea();
	private Button btnAnzeige = new Button("Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	public WarenuebersichtView(
		WarenuebersichtControl 
		warenuebersichtControl, 
	 	Stage primaryStage, 
		MoebelnModel moebelModel){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige der Warenübersicht");
		primaryStage.show();
		this.warenuebersichtControl 
			= warenuebersichtControl;
		this.moebelModel = moebelModel;
		this.initKomponenten();
		this.initListener();
		
	}

	private void initKomponenten(){
		// Label
		Font font = new Font("Arial", 24); 
		lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
		pane.getChildren().add(lblAnzeige);           
		//Textbereich	
		txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige);       	
    	// Button
 		btnAnzeige.setLayoutX(310);
 		btnAnzeige.setLayoutY(290);
    	pane.getChildren().add(btnAnzeige); 
	}

	private void initListener() {
	//    btnAnzeigeMoebel.setOnAction(
	//			new EventHandler<ActionEvent>() {
	//    		@Override
	//        	public void handle(ActionEvent e) {
	//            	zeigeMoebelAn();
	//        	} 
	//	    });
	}
	//
	//private void zeigeMoebelAn(){
	//		if(moebelModel.getBuergeramt() != null){
	//			txtAnzeigeMoebel.setText(
	//				moebelModel.getMoebelstueck()
	//				.gibMoebelstueckZurueck(' '));
	//		}
	//		else{
	//			zeigeInformationsfensterAn(
	//				"Bisher wurde kein Möbelstück aufgenommen!");
	//		}
	//}	
	
	private void zeigeInformationsfensterAn(String meldung){
		  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	           	"Information", meldung).zeigeMeldungsfensterAn();
	}	
	
	@Override
	public void update() {
		if (this.moebelModel.getMoebeln() != null) {
			txtAnzeige.setText(this.moebelModel.getMoebeln().gibMoebeknZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Moebeln aufgenommen!");
		}
		
	}	
		   

}
