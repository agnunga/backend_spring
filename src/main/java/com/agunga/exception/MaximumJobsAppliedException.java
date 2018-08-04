package com.agunga.exception;

/**
 * Created by agufed on 8/4/18.
 */
public class MaximumJobsAppliedException extends Exception {
    
    private String message = "You cannot apply for more than 3 jobs with interviews on the same day.";
    private Throwable throwable;

    public MaximumJobsAppliedException(String message, Throwable t){
        super(message, t);
        setMessage(message);
        setThrowable(t);
    }
    public  MaximumJobsAppliedException(){
        
    }

    public MaximumJobsAppliedException(String msg){
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
