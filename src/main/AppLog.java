package main;

import helper.DateHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppLog {

    private ObservableList<String> log;
    private LocalDateTime ldt;

    public AppLog() {
        log = FXCollections.observableArrayList();
    }

    public ObservableList<String> getLog() {
        return log;
    }

    public void addEntry(String entry) {
        log.add(DateHelper.getTimeStamp() + ": " + entry + "\n");
    }

    public void clearLog() {
        log.clear();
    }

}
