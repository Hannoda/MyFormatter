package com.hannoda.klimenko.Reader;



/**
 * Provides reading
 */
public interface IReader {
    /**
     * Reading
     *
     *
     * @return
     * @throws ReaderException
     */
    char read() throws ReaderException;
   // public int getNext() throws ReaderException;
    boolean isTheNext();
    void close() throws ReaderException;
}
