package main;

import constants.WinConstants;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import win.WinProcess;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button runButton;

    @FXML
    private TextArea log;

    private AppLog appLog = new AppLog();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpLog();
        setUpRunButton();
    }

    private void setUpLog() {
        appLog.getLog().addListener((ListChangeListener<String>) newEntry -> {
            newEntry.next();
            if (newEntry.wasAdded()) {
                log.appendText(newEntry.getAddedSubList().get(0));
            }
        });
    }

    private void setUpRunButton() {
        runButton.setOnAction(event -> {
            if (WinProcess.isProcessRunning(WinConstants.FORTNITE_PROCESS_NAME)) {
                appLog.addEntry("Fortnite process found, starting bot...");
            }
            else {
                appLog.addEntry("Fortnite process not found, please start Fortnite");
            }
        });
    }
}
