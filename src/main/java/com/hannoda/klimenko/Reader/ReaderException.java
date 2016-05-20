package com.hannoda.klimenko.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ReaderException
 */
public class ReaderException extends Exception {
    private Exception hidden;

    public Exception getHiddenException() {

        return hidden;

    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, IOException e) {
        super(message);
        hidden = e;
    }

    public ReaderException(String message, ReaderException e) {
        super(message);
        hidden = e;
    }

    public ReaderException(String message, FileNotFoundException e) {
        super(message);
        hidden = e;
    }
}
