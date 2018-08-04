package com.agunga.exception;

/**
 * Created by agufed on 8/4/18.
 */
public class JobConflictException extends Exception {

    private String message = "Job interview day and time matches another job already applied for.";
    private Throwable throwable;

    public JobConflictException(String message, Throwable t){
        super(message, t);
        setMessage(message);
        setThrowable(t);
    }
    public JobConflictException(){

    }

    public JobConflictException(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
