package main;


import gui.MoebelnAnwendersystem;
import gui.MoebelnControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelnControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
