package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import win.WinProcess;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("FortGrind");
        primaryStage.setScene(new Scene(root, 640, 640));
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("Fortnite Running: " + WinProcess.isProcessRunning("FortniteClient"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
