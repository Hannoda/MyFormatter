package com.hannoda.klimenko.State;

import com.hannoda.klimenko.Writter.WriterException;

/**
 * Created by hanno on 29.05.2016.
 */
public class StateException extends Exception {
    private Exception hidden;

    public StateException(String message, Exception e) {
        super(message);
        hidden = e;
    }

    public Exception getHiddenException() {
        return hidden;

    }

    public StateException(String message, WriterException e) {
        super(message);
        hidden = e;
    }
}
