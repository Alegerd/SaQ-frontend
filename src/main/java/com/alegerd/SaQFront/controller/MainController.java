package com.alegerd.SaQFront.controller;

import Exceptions.NullOutputException;
import com.alegerd.SaQFront.Model;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

/**
 * Created by alegerd on 24.02.17.
 */
public class MainController {

    Model model = new Model();

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

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    Button defaultBtn = stackArrayButton;

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
            model.MakeStack(input.getText());
        model.Push(input.getText().split(" "));
    }

    @FXML
    private void popButton(ActionEvent e){
            try{
                //if(element == null) throw new NullOutputException("list is empty");
                output.appendText(" " + String.valueOf(model.Pop()));
            }
            catch (Exception ex){
                alert.setTitle("Danger Zone");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
    }

    @FXML
    private void peekButton(ActionEvent e){
        try{
            output.appendText(" " + String.valueOf(model.Peek()));
        }
        catch (Exception ex){
            alert.setTitle("Danger Zone");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void clearButton(ActionEvent e){
        output.clear();
        model.ClearStack();
    }
}
