package Exceptions;

/**
 * Created by Anatoly on 02.03.2017.
 */
public class NullOutputException extends Exception{
    public NullOutputException(){}
    public NullOutputException(String message){
        super(message);
    }
}
