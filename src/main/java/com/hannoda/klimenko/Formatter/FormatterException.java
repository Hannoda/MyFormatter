package com.hannoda.klimenko.Formatter;

import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.WriterException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by hanno on 28.05.2016.
 */
public class FormatterException  extends Exception {
    private Exception hidden;

    public FormatterException(String message, Exception e) {
        super(message);
        hidden = e;
    }

    public Exception getHiddenException() {
        return hidden;

    }

    public FormatterException(String message, ReaderException e) {
        super(message);
        hidden = e;
    }

    public FormatterException(String message) {
        super(message);

    }
    public FormatterException(String message, WriterException e) {
        super(message);
        hidden = e;
    }

    public FormatterException(String message, IOException e) {
        super(message);
        hidden = e;
    }

    public FormatterException(String message, FileNotFoundException e) {
        super(message);
        hidden = e;
    }
}