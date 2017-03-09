package com.alegerd.SaQFront.controller;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.alegerd.SaQFront.Model;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by alegerd on 24.02.17.
 */
public class MainController {

    private enum TabSort {
        STANDARD, PRIORITY
    }

    Model model = new Model();
    TabSort tabSort = TabSort.STANDARD;

    @FXML
    Button stackArrayButton;
    @FXML
    Button queueArrayButton;
    @FXML
    Button stackListButton;
    @FXML
    Button queueListButton;
    @FXML
    TextField input;
    @FXML
    TextField output;
    @FXML
    TextField inputValue;
    @FXML
    TextField inputPriority;
    @FXML
    TextField outputPriority;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    Button defaultBtn = stackArrayButton;

    @FXML
    private void standardTabSelected(Event e) {
        tabSort = TabSort.STANDARD;
        model.listMode = Model.ListType.ArrayStack;
        model.currentListType = Model.CurrentListType.Stack;
    }

    @FXML
    private void priorityTabSelected(Event e) {
        tabSort = TabSort.PRIORITY;
        model.listMode = Model.ListType.PriorityQueue;
        model.currentListType = Model.CurrentListType.PriorityQueue;
    }

    @FXML
    private void setStackArrayButtonClicked(ActionEvent e)
    {
        model.listMode = Model.ListType.ArrayStack;
        model.currentListType = Model.CurrentListType.Stack;
    }
    @FXML
    private void setQueueArrayButtonClicked(ActionEvent e)
    {
        model.listMode = Model.ListType.ArrayQueue;
        model.currentListType = Model.CurrentListType.Queue;
    }
    @FXML
    private void setStackListButtonClicked(ActionEvent e)
    {
        model.listMode = Model.ListType.LinkedStack;
        model.currentListType = Model.CurrentListType.Stack;
    }
    @FXML
    private void setQueueListButtonClicked(ActionEvent e)
    {
        model.listMode = Model.ListType.LinkedQueue;
        model.currentListType = Model.CurrentListType.Queue;
    }


    @FXML
    private void pushButton(ActionEvent e){
        if(!model.isStackExists())
            model.makeStack(input.getText());
        try {
            model.push(input.getText().split(" "));
        } catch (NullObjectSendedException e1) {
            alert.setTitle("Error");
            alert.setHeaderText("Collection can't store 'null' elements.");
            alert.showAndWait();
        }
    }

    @FXML
    private void pushButton_Priority(ActionEvent e){
        if(!model.isStackExists())
            model.makePriorityQueue(inputValue.getText(), inputPriority.getText());
        try {
            model.pushPriority(inputValue.getText(), inputPriority.getText());
        } catch (Exception e1) {
            alert.setTitle("Error");
            alert.setHeaderText("Exception occurred");
            alert.showAndWait();
        }
    }

    @FXML
    private void popButton(ActionEvent e) {
            try{
                if(model.isStackExists())
                    output.appendText(" " + String.valueOf(model.pop()));
            }
            catch (Exception ex){
                alert.setTitle("Danger Zone");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
    }

    @FXML
    private void popButton_Priority(ActionEvent e) {
        try{
            if(model.isStackExists())
                outputPriority.appendText(" " + model.popPriority());
        }
        catch (Exception ex){
            alert.setTitle("Danger Zone");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void peekButton(ActionEvent e) {
        try{
            if(model.isStackExists())
                output.appendText(" " + String.valueOf(model.peek()));
        }
        catch (Exception ex){
            alert.setTitle("Danger Zone");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void clearButton(ActionEvent e) {
        output.clear();
        model.clearStack();
    }

    @FXML
    private void clearButtonPriority(ActionEvent e) {
        outputPriority.clear();
        model.clearStack();
    }
}
