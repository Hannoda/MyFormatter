package com.hannoda.klimenko.Writter;


/**
 * Provides writing
 */
public interface IWriter {

    /**
     * Writing
     *
     * @param ch
     * @throws WriterException
     */
    void write(String ch) throws WriterException;

    void printIndent(int i) throws WriterException;

}
