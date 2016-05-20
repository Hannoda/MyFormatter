package com.hannoda.klimenko.Writter;

/**
 * Created by hanno on 20.05.2016.
 */
public class WriterException extends Exception {
    private Exception hidden;

    public WriterException(String fileNotFound, Exception e) {

    }

    public Exception getHiddenException() {

        return hidden;

    }
}
