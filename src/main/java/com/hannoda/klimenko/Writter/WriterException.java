package com.hannoda.klimenko.Writter;


/**
 * WriterException
 */
public class WriterException extends Exception {
    private Exception hidden;

    public WriterException(String message, Exception e) {
        super(message);
        hidden = e;
    }

    public Exception getHiddenException() {

        return hidden;

    }
}
