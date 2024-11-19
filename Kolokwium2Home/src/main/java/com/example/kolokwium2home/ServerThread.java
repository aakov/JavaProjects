package com.example.kolokwium2home;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServerThread extends Thread {
    private Socket socket;
    private PrintWriter writer;
    private boolean running;
    public int wordCount = 0;
    private HelloController controller = null;

    //ArrayList<LineWord> list = new ArrayList<LineWord>();
    ObservableList<LineWord> list= FXCollections.observableArrayList();
    public ServerThread(String address, int port) {
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setController(HelloController controller) {
        this.controller = controller;
    }

    String w = String.valueOf(wordCount);

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            String message;
            while ((message = reader.readLine()) != null){
                System.out.println(message + "  ");
                wordCount++;
                w = String.valueOf(wordCount);

                String wordTime = DateTimeFormatter.ofPattern ("HH:mm:ss").format (LocalDateTime.now ()) + " " + message;
                String time = DateTimeFormatter.ofPattern ("HH:mm:ss").format (LocalDateTime.now ());
                //LineWord lineWord = new LineWord(time, message);
                //list.add(DateTimeFormatter.ofPattern ("HH:mm:ss").format (LocalDateTime.now ()) + " " + message);

                String finalMessage = message;
                Platform.runLater (()->
                        list.add(new LineWord(time, finalMessage))
                );

                //list.add(new LineWord(time, message));
                //String finalMessage = message;
                //Platform.runLater (()-> { list.add(new LineWord(time, finalMessage)); });

                Platform.runLater (()->controller.setWordCountLabel(w));
                //list.forEach(System.out::println);
                //Platform.runLater (()->controller.wordList.getItems().add(DateTimeFormatter.ofPattern ("hh:mm:ss").format (LocalDateTime.now ()) + " " + message));
               // Platform.runLater (()->controller.wordList.getItems().add(lineWord));
               if (controller.filterField.getText().isEmpty())
               {
                   Platform.runLater (()->Collections.sort(list, Comparator.comparing(LineWord::getWord)));
                   Platform.runLater (()->controller.wordList.setItems(list));
               } else //if (message.startsWith(controller.filterField.getText()))
                 {
                     ObservableList<LineWord> listFiltered= FXCollections.observableArrayList();
                     for (int i = 0; i < list.size(); i++) {
                         if (list.get(i).getWord().startsWith(controller.filterField.getText()))
                         {
                             listFiltered.add(list.get(i));
                         }
                     }
                     Platform.runLater (()->controller.wordList.setItems(listFiltered));
               }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





