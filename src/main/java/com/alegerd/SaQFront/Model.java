package com.alegerd.SaQFront;

import com.app.mainPackage.Classes.ArrayQueue;
import com.app.mainPackage.Classes.ArrayStack;
import com.app.mainPackage.Classes.LinkedQueue;
import com.app.mainPackage.Classes.LinkedStack;
import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IQueue;
import com.app.mainPackage.Interfaces.IStack;



public class Model {

    public enum ListType{
        ArrayStack,
        LinkedStack,
        ArrayQueue,
        LinkedQueue
    }

    public enum CurrentListType{
        Stack,
        Queue
    }


    IStack stack = null;
    IQueue queue = null;

    public ListType listMode = ListType.ArrayStack;
    public CurrentListType currentListType = CurrentListType.Stack;

    public <T> void MakeStack(T e){
        switch (listMode){
            case ArrayStack:
                stack = new ArrayStack<T>(e);
                break;
            case LinkedStack:
                stack = new LinkedStack<T>();
                break;
            case ArrayQueue:
                queue = new ArrayQueue<T>(e);
                break;
            case LinkedQueue:
                queue = new LinkedQueue<T>();
                break;
        }
        }

    public <T> void Push(T[] args) throws NullObjectSendedException {
        switch (currentListType){
            case Stack:
                for (T arg: args) {
                    stack.push(arg);
                    System.out.println("stack");
                }
                break;

            case Queue:
                for (T arg: args) {
                    queue.enqueue(arg);
                    System.out.println("queue");
                }
                break;
        }
    }

    public Object Pop() throws OutOfBordersException {
        switch (currentListType){
            case Stack:
                    return stack.pop();
            case Queue:
                return queue.dequeue();
        }
        return null;
    }

    public Object Peek() throws OutOfBordersException {
        switch (currentListType){
            case Stack:
                return stack.peek();
            case Queue:
                return queue.peek();
        }
        return null;
    }

    public boolean isStackExists() {
        switch (currentListType){
            case Stack:
                return (stack != null) ? true : false;
            case Queue:
                return (queue != null) ? true : false;
        }
        return false;
    }

    public boolean isStackEmpty() {
        switch (currentListType){
        case Stack:
            return stack.isEmpty();
        case Queue:
            return queue.isEmpty();
        }
        return true;
    }

    public void ClearStack(){
        if(stack != null) stack.clear();
        if(queue != null) queue.clear();
    }
}
