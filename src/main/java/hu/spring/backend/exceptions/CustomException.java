package hu.spring.backend.exceptions;

import java.util.Date;

public class CustomException {

    private Date time;
    private String message;
    private String details;

    public CustomException(Date time, String message, String details) {
        this.time = time;
        this.message = message;
        this.details = details;
    }

    public Date getTime() {
        return time;
    }


    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }

}
