package com.alegerd.SaQFront;

import com.app.mainPackage.Classes.*;
import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IPriorityQueue;
import com.app.mainPackage.Interfaces.IQueue;
import com.app.mainPackage.Interfaces.IStack;



public class Model {

    public enum ListType{
        ArrayStack,
        LinkedStack,
        ArrayQueue,
        LinkedQueue,
        PriorityQueue
    }

    public enum CurrentListType{
        Stack,
        Queue,
        PriorityQueue
    }


    IStack stack = null;
    IQueue queue = null;
    IPriorityQueue priorityQueue = null;

    public ListType listMode = ListType.ArrayStack;
    public CurrentListType currentListType = CurrentListType.Stack;

    public <T> void makeStack(T e){
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

    public <T1, T2 extends Comparable> void makePriorityQueue(T1 value, T2 priority) {
        priorityQueue = new PriorityQueue<T1,T2>();
        listMode = ListType.PriorityQueue;
        currentListType = CurrentListType.PriorityQueue;
    }

    public <T> void push(T[] args) throws NullObjectSendedException {
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

    public Object pop() throws OutOfBordersException {
        switch (currentListType){
            case Stack:
                    return stack.pop();
            case Queue:
                return queue.dequeue();
        }
        return null;
    }

    public Object peek() throws OutOfBordersException {
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
            case PriorityQueue:
                return (priorityQueue != null) ? true : false;
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

    public void clearStack(){
        if(stack != null) stack.clear();
        if(queue != null) queue.clear();
        if(priorityQueue != null) priorityQueue = new PriorityQueue();
    }

    public <T,T2 extends Comparable> void pushPriority(T value, T2 priority) {
        priorityQueue.enqueue(value, priority);
    }

    public <T> String popPriority() throws OutOfBordersException {
        return String.valueOf(priorityQueue.dequeue());
    }


}
