package com.example.kolokwium2home;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    public Label wordCountLabel;

    public void setWordCountLabel(String w)
    {
        wordCountLabel.setText(w);
    }

    @FXML
    public TextField filterField;

    @FXML
    public ListView wordList;
}