package com.alegerd.SaQFront.controller;

import com.alegerd.SaQFront.Model;
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
        if(!model.isStackEmpty()) {
            output.appendText(" " + String.valueOf(model.Pop()));
        }
    }

    @FXML
    private void peekButton(ActionEvent e){
        if(!model.isStackEmpty()) {
            output.appendText(" " + String.valueOf(model.Peek()));
        }
    }

    @FXML
    private void clearButton(ActionEvent e){
        output.clear();
        model.ClearStack();
    }
}
