package com.agunga.exception;

/**
 * Created by agufed on 8/4/18.
 */
public class MaximumJobsParticipantsException extends Exception {

    private String message = "Maximum participants for reached.";
    private Throwable throwable;

    public MaximumJobsParticipantsException(String message, Throwable t){
        super(message, t);
        setMessage(message);
        setThrowable(t);
    }
    public MaximumJobsParticipantsException(){

    }

    public MaximumJobsParticipantsException(String msg){
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
